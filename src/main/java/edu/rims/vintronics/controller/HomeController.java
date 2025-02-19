package edu.rims.vintronics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.vintronics.entity.Category;
import edu.rims.vintronics.entity.Product;
import edu.rims.vintronics.repository.CategoryRepository;
import edu.rims.vintronics.repository.ProductRepository;

@Controller
@RequestMapping("/customer")
public class HomeController {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping({ "/home", "/" })
    public String home(Model model) {
        List<Category> categories = categoryRepository.findAll();
        List<Product> allProducts = productRepository.findAll(); // Show all products initially

        model.addAttribute("categories", categories);
        model.addAttribute("products", allProducts); // Add products for homepage display
        model.addAttribute("selectedCategory", "All Products"); 

        return "customer/home";
    }
}
