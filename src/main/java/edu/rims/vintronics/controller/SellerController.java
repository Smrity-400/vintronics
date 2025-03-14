package edu.rims.vintronics.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.rims.vintronics.entity.Product;
import edu.rims.vintronics.repository.ProductRepository;
import edu.rims.vintronics.repository.UserRepository;

@Controller
@RequestMapping("/seller")
public class SellerController {

    private final AdminController adminController;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    SellerController(AdminController adminController) {
        this.adminController = adminController;
    }

    @GetMapping({ "/home", "/" })
    String sellerProduct(Model model) {
        List<edu.rims.vintronics.entity.Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "seller/home";
    }  // <-- Fixed missing closing brace

    @PostMapping("/home") 
    public String productAdd(@ModelAttribute Product product, @RequestParam("productImageUrl") MultipartFile file)
            throws IOException {

        String originalName = file.getOriginalFilename();
        String fileName = "uploads/" + UUID.randomUUID().toString()
                + originalName.substring(originalName.lastIndexOf("."));
        
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();
        
        product.setCreatedDate(LocalDateTime.now());
        product.setUpdatedDate(LocalDateTime.now());
        product.setCreatedBy("admin");
        product.setUpdatedBy("admin");
        product.setProductImageUrl(fileName);

        productRepository.save(product);  // Fixed incorrect repository name
        return "redirect:/seller/home";
    }
}
