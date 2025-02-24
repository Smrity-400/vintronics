package edu.rims.vintronics.controller;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.vintronics.repository.CategoryRepository;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryRepository categoryRepository; 

    @GetMapping({ "/homepage", "/" })
    String admin() {
        return "admin/homepage";
    }

    @GetMapping("/admin/category")
    String adminCategory(Model model) {
        List<edu.rims.vintronics.entity.Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "admin/category";
    }

    @PostMapping ("/admin/category")
    public String categoryAdd(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/admin/category";
    }
    
}
