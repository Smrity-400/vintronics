package edu.rims.vintronics.controller;

// import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CartController {

    @GetMapping({"/cart", "/"})
     String cart() {
        // System.out.println(principal.getName());
        return "customer/cart";
    }
}
