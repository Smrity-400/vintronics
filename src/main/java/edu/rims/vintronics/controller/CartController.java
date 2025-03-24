package edu.rims.vintronics.controller;

import java.security.Principal;

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


@Controller
@RequestMapping("/customer")
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping({"/cart", "/"})
     String cart(Principal principal, Model model) {
        String username = principal.getName();
        User user = userService.getUser(username);
        Order order = orderRepository.findByUserUserIdAndOrderStatus(user.getUserId(),
         OrderStatus.CART) .orElse(new Order());
        order.setBuyer(user);

        Product product = productRepository.findById(productId).orElseThrow();

        OrderItem orderItem = new OrderItem(product);
        order.addOrderItem(orderItem);

        orderRepository.save(order);
        return "redirect:/customer/cart";
    }

    @GetMapping("/cutomer/cart/remove")
    public String removeItem(@RequestParam("OrderItem") String orderItemId, Principal principal) {
        String username = principal.getName();
        User user = userService.getUser(username);
        Order order = orderRepository.findByUserUserIdAndOrderStatus(user.getUserId(), OrderStatus.CART)
            .orElse("null");
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
