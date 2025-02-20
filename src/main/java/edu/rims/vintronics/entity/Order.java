package edu.rims.vintronics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
// import java.time.LocalDateTime;
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
    @JoinColumn(name = "buyer_user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user"))
    private User buyer;

    @Column(name = "order_total_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal orderTotalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", columnDefinition = "ENUM('PENDING', 'SHIPPED', 'DELIVERED', 'CANCELLED', 'CART') DEFAULT 'PENDING'")
    private OrderStatus orderStatus = OrderStatus.PENDING;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;
}