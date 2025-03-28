package edu.rims.vintronics.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.vintronics.constant.OrderStatus;
import edu.rims.vintronics.entity.Order;
import edu.rims.vintronics.entity.OrderItem;
import edu.rims.vintronics.entity.Product;
import edu.rims.vintronics.entity.User;
import edu.rims.vintronics.repository.OrderRepository;
import edu.rims.vintronics.repository.ProductRepository;
import edu.rims.vintronics.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;


@Controller
@RequestMapping("/customer")
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/cart")
    public String getCart(Principal principal,Model  model){
        String email = principal.getName();
        User user = userService.getUser(email);

        Order order = orderRepository.findByUserUserIdAndOrderStatus(user.getUserId(),
         OrderStatus.CART) .orElse(new Order());
        model.addAttribute("order", order);
        return "customer/cart";
    }

    @GetMapping({"/cart/add"})
     String cart(Principal principal, @RequestParam String productId) {
        String username = principal.getName();
        User user = userService.getUser(username);
        Order order = orderRepository.findByUserUserIdAndOrderStatus(user.getUserId(),
         OrderStatus.CART) .orElse(new Order());
        Product product = productRepository.findById(productId).orElseThrow();

        OrderItem orderItem = new OrderItem(product);
        order.addOrderItem(orderItem);

        order.setCreatedBy(user.getUserName());
        order.setUpdatedBy(user.getUserName());
        order.setCreatedDate(LocalDateTime.now());
        order.setUpdatedDate(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.CART);
        order.setUser(user);
        order.setOrderTotalPrice(orderItem.getOrderItemTotalPrice());
        orderItem.setCreatedDate(LocalDateTime.now());
        orderItem.setUpdatedDate(LocalDateTime.now());
        orderItem.setCreatedBy(user.getUserName());
        orderItem.setUpdatedBy(user.getUserName());
        orderRepository.save(order);
        return "redirect:/customer/cart";
    }

    @GetMapping("/cart/remove")
    public String removeItem(@RequestParam("OrderItem") String orderItemId, Principal principal) {
        String username = principal.getName();
        User user = userService.getUser(username);
        Order order = orderRepository.findByUserUserIdAndOrderStatus(user.getUserId(), OrderStatus.CART)
            .orElse(null);
        orderRepository.save(order);
        return "redirect:/customer/cart";
    }

    @GetMapping("/customer/placeorder")
    public String placeorder(Principal principal) {
        String username = principal.getName();
        User user = userService.getUser(username);
        Order order = orderRepository.findByUserUserIdAndOrderStatus(user.getUserId(), OrderStatus.CART)
            .orElse(null);
        order.setOrderStatus(OrderStatus.DELIVERED);
        orderRepository.save(order);
        return "customer/placeorder";
    }
    
    
}
