package edu.rims.vintronics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.vintronics.entity.Category;
import edu.rims.vintronics.repository.CategoryRepository;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/customer")
public class HomeController {
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping({"/home", "/"})
     String home(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "customer/home";
    }
    
}
