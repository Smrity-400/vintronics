package edu.rims.vintronics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import edu.rims.vintronics.entity.User;
import edu.rims.vintronics.repository.SellerRepository;
import edu.rims.vintronics.repository.UserRepository;

@Configuration
public class SecurityConfig {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(request -> request.requestMatchers("/login", "/customer/login", 
        "/error", "/style/**","/customer/sign-up","/js/**", "/image/**","/video/**", "seller/sellerlogin")
            .permitAll()
            .requestMatchers("/seller/**").hasRole("SELLER")
            .requestMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated());
            http.formLogin(form -> form.loginPage("/customer/login").successForwardUrl("/user"));
            http.logout(Customizer.withDefaults());
            return http.build();
    }

    @Bean
    PasswordEncoder encoder(){
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    UserDetailsService detailsService(){
        return (username) -> {
            User user = userRepository.findByUserEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("userNotFound"));
            return org.springframework.security.core.userdetails.User.builder()
                .username(username)
                .password(user.getUserPassword())
                .roles(user.getUserRole().toString())
                .build();
                
        };
    }
    
}
