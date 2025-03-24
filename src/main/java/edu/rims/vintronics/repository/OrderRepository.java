package edu.rims.vintronics.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.vintronics.entity.Order;
import edu.rims.vintronics.constant.OrderStatus;


public interface OrderRepository extends JpaRepository<Order, String>{

    Optional<Order> findByUserUserIdAndOrderStatus(Integer userId, OrderStatus Status);

    List<Order> findByUserUserEmailAndOrderStatusNot(String email, OrderStatus status);
    
}
