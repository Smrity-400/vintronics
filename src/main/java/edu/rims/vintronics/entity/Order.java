package edu.rims.vintronics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import edu.rims.vintronics.constant.OrderStatus;

@Entity
@Table(name = "product_order")
@Getter
@Setter
public class Order extends Auditable{

    @Id
    @Column(name = "order_id", nullable = false, length = 255)
    private String orderId;

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_user"))
    private User user;

    @Column(name = "order_total_price", nullable = false)
    private double orderTotalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", columnDefinition = "ENUM('PENDING', 'SHIPPED', 'DELIVERED', 'CANCELLED', 'CART') DEFAULT 'PENDING'")
    private OrderStatus orderStatus = OrderStatus.PENDING;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    public boolean addOrderItem(OrderItem orderItem) {
        if (orderItems == null) {
            orderItems = new ArrayList<>();
        }

        if (itemExists(orderItem.getProduct().getProductId())) {
            return false;
        }

        orderItem.setOrder(this);
        orderItems.add(orderItem);
        updateDetails();
        return true;
    }

    private void updateDetails() {
        int totalQuantity = 0;
        double totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalQuantity += orderItem.getOrderItemQuantity();
            totalPrice += orderItem.getOrderItemUnitPrice();
        }
        this.orderTotalPrice = totalPrice;
        // orderQuantity = totalQuantity;
    }

    private boolean itemExists(String itemId) {
        for (OrderItem orderItem : orderItems) {
            if (itemId.equals(orderItem.getProduct().getProductId())) {
                return true;
            }
        }
        return false;
    }

    public void removeOrderItem(String ordertItemId) {
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getOrderItemId().equals(ordertItemId)) {
                orderItem.setOrder(null);
                orderItems.remove(orderItem);
                break;
            }
        }
        updateDetails();
    }
}
