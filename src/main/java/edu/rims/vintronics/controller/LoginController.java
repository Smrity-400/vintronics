package edu.rims.vintronics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/customer")
public class LoginController {
    @GetMapping({"/login","/"})
     String login() {
        return "customer/login";
    }
    
    
}
