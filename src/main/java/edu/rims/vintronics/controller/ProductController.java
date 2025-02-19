package edu.rims.vintronics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rims.vintronics.entity.Category;
import edu.rims.vintronics.entity.Product;
import edu.rims.vintronics.repository.CategoryRepository;
import edu.rims.vintronics.repository.ProductRepository;

@Controller
@RequestMapping("/customer")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/product")
    public String product(@RequestParam(value = "category") String categoryId, Model model) {
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        model.addAttribute("category", category);
        model.addAttribute("categories", categoryRepository.findAll());
        return "customer/product";
    }



    @GetMapping({"/pdp", "/"})
     String pdp() {
        return "customer/pdp";
    }
}
