package edu.rims.vintronics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import edu.rims.vintronics.entity.Category;
import edu.rims.vintronics.entity.Product;
import edu.rims.vintronics.repository.CategoryRepository;
import edu.rims.vintronics.repository.ProductRepository;

@Controller
@RequestMapping("/customer")
public class ProductController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    // PLP - Fetch all products in a category
    @GetMapping("/product")
    public String product(@RequestParam(value = "category") String categoryId, Model model) {
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        model.addAttribute("category", category);
        model.addAttribute("categories", categoryRepository.findAll());
        return "customer/product"; // PLP Page
    }

    // PDP - Fetch product details by ID
    @GetMapping("/pdp/{id}")
    public String pdp(@PathVariable("id") String productId, Model model) {
        Product product = productRepository.findById(productId).orElseThrow();
        model.addAttribute("product", product);
        return "customer/pdp"; // PDP Page
    }
}
