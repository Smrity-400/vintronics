package edu.rims.vintronics.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.rims.vintronics.entity.Category;
import edu.rims.vintronics.entity.Product;
import edu.rims.vintronics.entity.Seller;
import edu.rims.vintronics.repository.CategoryRepository;
import edu.rims.vintronics.repository.ProductRepository;
import edu.rims.vintronics.repository.SellerRepository;
import edu.rims.vintronics.repository.UserRepository;

@Controller
@RequestMapping("/seller")
public class SellerController {

    private final AdminController adminController;

    @Autowired
    private SellerRepository sellerRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @SuppressWarnings("unused")
    @Autowired
    private UserRepository userRepository;

    SellerController(AdminController adminController) {
        this.adminController = adminController;
    }

    @GetMapping("/home")
    String sellerProduct(Model model) {
        List<Product> products = productRepository.findAll();
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "seller/home";
    }

    @PostMapping("/home")
    public String productAdd(@ModelAttribute Product product, @RequestParam("productImage") MultipartFile file)
            throws IOException {

        if (!file.isEmpty()) {
            String originalName = file.getOriginalFilename();
            String fileName = "uploads/" + UUID.randomUUID().toString()
                    + originalName.substring(originalName.lastIndexOf("."));

            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(file.getBytes());
            product.setProductImageUrl(fileName);
            fileOutputStream.close();
        }

        Seller seller = sellerRepository.findById(1).orElseThrow();
        product.setCreatedDate(LocalDateTime.now());
        product.setUpdatedDate(LocalDateTime.now());
        product.setCreatedBy(seller.getSellerName());
        product.setUpdatedBy(seller.getSellerName());
        product.setSeller(seller);
        productRepository.save(product);
        return "redirect:/seller/home";
    }

    @GetMapping({ "/sellerlogin", "/" })
    String contact() {
        return "seller/sellerlogin";
    }

    @PostMapping("/signup")
    String signUp(@ModelAttribute Seller seller) {
        seller.setCreatedDate(LocalDateTime.now());
        seller.setUpdatedDate(LocalDateTime.now());
        seller.setCreatedBy(seller.getSellerName());
        seller.setUpdatedBy(seller.getSellerName());
        sellerRepository.save(seller);
        return "redirect:/seller/sellerlogin";
    }


}
