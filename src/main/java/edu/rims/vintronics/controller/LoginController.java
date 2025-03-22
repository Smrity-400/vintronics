package edu.rims.vintronics.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.vintronics.entity.User;
import edu.rims.vintronics.repository.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/customer")
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping({ "/login", "/" })
    String login() {
        return "customer/login";
    }

    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute User user) {
        user.setCreatedDate(LocalDateTime.now());
        user.setUpdatedDate(LocalDateTime.now());
        user.setCreatedBy("user");
        user.setUpdatedBy("user");
        user.setUserPassword(encoder.encode(user.getUserPassword()));
        userRepository.save(user);
        return "redirect:/customer/login";
    }

}
