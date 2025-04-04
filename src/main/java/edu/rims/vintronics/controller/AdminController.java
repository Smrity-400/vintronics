package edu.rims.vintronics.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.rims.vintronics.constant.WidgetStatus;
import edu.rims.vintronics.entity.Category;
import edu.rims.vintronics.entity.Order;
import edu.rims.vintronics.entity.Product;
import edu.rims.vintronics.entity.Widget;
import edu.rims.vintronics.repository.CategoryRepository;
import edu.rims.vintronics.repository.OrderRepository;
import edu.rims.vintronics.repository.ProductRepository;
import edu.rims.vintronics.repository.UserRepository;
import edu.rims.vintronics.repository.WidgetRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @SuppressWarnings("unused")
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WidgetRepository widgetRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/homepage")
    String adminCategory(Model model) {
        List<edu.rims.vintronics.entity.Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "/admin/homepage";
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

        try (FileInputStream fis = new FileInputStream(imageName)) {
            return fis.readAllBytes();
        }
    }

    @PostMapping("/admin/edit-category")
    @ResponseBody
    public ResponseEntity<?> editCategory(@RequestBody Category category) {
        Optional<Category> existingCategory = categoryRepository.findById(category.getId());
        if (existingCategory.isPresent()) {
            Category updatedCategory = existingCategory.get();
            updatedCategory.setCategoryTitle(category.getCategoryTitle());
            updatedCategory.setCategoryDescription(category.getCategoryDescription());
            updatedCategory.setCategoryStatus(category.getCategoryStatus());

            categoryRepository.save(updatedCategory);
            return ResponseEntity.ok(Collections.singletonMap("success", true));
        }
        return ResponseEntity.badRequest().body(Collections.singletonMap("success", false));
    }


    @GetMapping("/dashboard")
    String admin() {
       return "admin/dashboard";
   }


   @GetMapping("/widget")
   public String getWidgets(Model model) {
      model.addAttribute("widgets", widgetRepository.findAll());
      return "admin/widget";
  }

  @PostMapping("/widget/add")
    public String postMethodName(@RequestParam String widgetName, @RequestParam String widgetId,
            @RequestParam int sequence) {
        Widget widget = widgetRepository.findById(widgetId).orElse(new Widget());
        widget.setWidgetName(widgetName);
        widget.setSequence(sequence);
        widget.setUpdatedDate(LocalDateTime.now());
        widget.setCreatedDate(LocalDateTime.now());
        widget.setUpdatedDate(LocalDateTime.now());
        widget.setCreatedBy("admin");
        widget.setUpdatedBy("admin");
        widgetRepository.save(widget);
        return "redirect:/admin/widget";
    }

    @GetMapping("/widget/remove")
    public String removeWidget(@RequestParam("id") String widgetId) {
        Widget widget = widgetRepository.findById(widgetId).orElseThrow();
        widget.setWidgetStatus(WidgetStatus.INACTIVE);
        widgetRepository.save(widget);
        return "redirect:/admin/widget";
    }

    @GetMapping("/widget/edit")
    public String editWidget(@RequestParam("id") String widgetId, Model model) {
        Widget widget = widgetRepository.findById(widgetId).orElseThrow();
        model.addAttribute("widget", widget);
        model.addAttribute("widgets", widgetRepository.findAll());
        return "admin/widget";
    }

    @GetMapping(value = "/productimage/{productId}", produces = { "image/jpg", "image/jpeg", "image/png" })
    @ResponseBody
    public byte[] getProductImage(@PathVariable String productId) throws IOException {

        Product product = productRepository.findById(productId).orElseThrow();
        String productImageUrl = product.getProductImageUrl();
        if (productImageUrl == null || productImageUrl.startsWith("http")) {
            return null;
        }
        try (FileInputStream fis = new FileInputStream(productImageUrl)) {
            return fis.readAllBytes();
        }
    }

    @PostMapping("/widget/product/add")
    public String addProductToWidget(@RequestParam MultipartFile file) {

        if (file.isEmpty())
            return "redirect:/admin/widget";

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            // for header
            bufferedReader.readLine();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",");
                processDetails(split[0], split[1]);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "redirect:/admin/widget";
    }

    @GetMapping("/widget/products")
    public String getMethodName(@RequestParam("id") String wigetId, Model model) {
        Widget widget = widgetRepository.findById(wigetId).orElseThrow();
        model.addAttribute("widget", widget);
        return "admin/widget-product";
    }

    private void processDetails(String widgetId, String productId) {
        Product product = productRepository.findById(productId).orElse(null);
        Widget widget = widgetRepository.findById(widgetId).orElse(null);

        if (product != null && widget != null) {
            if (!widget.getProducts().contains(product)) {
                widget.addProduct(product);
                widgetRepository.save(widget);
            }
        }
    }

    @GetMapping("/widget/product/remove")
    public String getMethodName(@RequestParam String widgetId, @RequestParam String productId) {
        Widget widget = widgetRepository.findById(widgetId).orElseThrow();

        widget.removeProduct(productId);

        widgetRepository.save(widget);
        return "redirect:/admin/widget";
    }

   @GetMapping("/customer")
   String customer() {
      return "admin/customer";
  }

  @GetMapping({"/payment", "/"})
    String payment() {
       return "admin/payment";
   }
  
    @GetMapping("/order")
    String order(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "admin/order";
    }

}
