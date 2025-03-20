package edu.rims.vintronics.controller;

import java.io.FileInputStream;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.rims.vintronics.entity.Category;
import edu.rims.vintronics.repository.CategoryRepository;
import edu.rims.vintronics.repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryRepository categoryRepository;

    @SuppressWarnings("unused")
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/homepage")
    String adminCategory(Model model) {
        List<edu.rims.vintronics.entity.Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "admin/homepage";
    }

    @PostMapping("/admin/homepage")
    public String categoryAdd(@ModelAttribute Category category, @RequestParam("categoryImage") MultipartFile file)
            throws IOException {
        String originalName = file.getOriginalFilename();
        String fileName = "uploads/" + UUID.randomUUID().toString()
                + originalName.substring(originalName.lastIndexOf("."));
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();
        category.setCategoryImageUrl(fileName);
        category.setCreatedDate(LocalDateTime.now());
        category.setUpdatedDate(LocalDateTime.now());
        category.setCreatedBy("admin");
        category.setUpdatedBy("admin");

        categoryRepository.save(category);
        return "redirect:/admin/homepage";
    }

    @GetMapping("/image/{categoryId}")
    @ResponseBody
    public byte[] getImage(@PathVariable String categoryId) throws IOException{
        Category category = categoryRepository.findById(categoryId).orElseThrow();

        String imageName = category.getCategoryImageUrl();

        FileInputStream fis = new FileInputStream(imageName);

        return fis.readAllBytes();
    }

    @GetMapping("/dashboard")
    String admin() {
       return "admin/dashboard";
   }

}
