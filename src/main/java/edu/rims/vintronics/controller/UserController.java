package edu.rims.vintronics.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import edu.rims.vintronics.constant.UserRole;
import edu.rims.vintronics.entity.User;
import edu.rims.vintronics.repository.UserRepository;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    String home(Principal principal) {
        User user = userRepository.findByUserEmail(principal.getName()).orElseThrow();
        if (user.getUserRole() == UserRole.CUSTOMER) {
            return "redirect:/customer/home";
        } else if (user.getUserRole() == UserRole.ADMIN) {
            return "redirect:/admin/homepage";
        } else {
            return "redirect:/seller/home";
        }
    }
}