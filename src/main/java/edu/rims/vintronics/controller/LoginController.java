package edu.rims.vintronics.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
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
        userRepository.save(user);
        return "redirect:/customer/login";
    }

}
