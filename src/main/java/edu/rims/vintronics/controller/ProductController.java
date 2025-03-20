package edu.rims.vintronics.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import edu.rims.vintronics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import edu.rims.vintronics.entity.Category;
import edu.rims.vintronics.entity.Product;
import edu.rims.vintronics.repository.CategoryRepository;
import edu.rims.vintronics.repository.ProductRepository;

@Controller
@RequestMapping("/customer")
public class ProductController {

    private final UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    ProductController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

     @GetMapping("/product/home")
    public String searchProduct(@RequestParam("search") String productTitle, Model model) {
        List<Product> products = productRepository.findByProductTitleContainingIgnoreCase(productTitle);
        model.addAttribute("products", products);
        model.addAttribute(productTitle, products);
        return "customer/product";
    }
    
    @GetMapping("/image/{id}")
    @ResponseBody
    byte[]  getProductImage(@PathVariable String id) throws IOException{
        Product product = productRepository.findById(id).orElseThrow();
        String imageName = product.getProductImageUrl();
        FileInputStream fileInputStream = new FileInputStream(imageName);
        return fileInputStream.readAllBytes();
    }
}
