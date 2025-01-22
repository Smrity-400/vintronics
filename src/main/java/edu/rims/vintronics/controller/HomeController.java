package edu.rims.vintronics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/customer")
public class HomeController {
    @GetMapping({"/home", "/"})
     String home() {
        return "customer/home";
    }
    
}
