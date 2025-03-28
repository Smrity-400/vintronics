package edu.rims.vintronics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import edu.rims.vintronics.constant.OrderItemStatus;

@Entity
@Table(name = "order_item")
@Getter
@Setter
public class OrderItem extends Auditable {

    @Id
    @Column(name = "order_item_id", nullable = false, length = 255)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "order_item_quantity", nullable = false)
    private Integer orderItemQuantity;

    @Column(name = "order_item_unit_price", nullable = false)
    private double orderItemUnitPrice;

    @Column(name = "order_item_total_price", nullable = false)
    private double orderItemTotalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_item_status")
    private OrderItemStatus orderItemStatus = OrderItemStatus.ADDED;

    public OrderItem() {

    }

    public OrderItem(Product product) {
        this.product = product;
        orderItemQuantity = 1;
        orderItemUnitPrice = product.getProductPrice();
    }

    public void incrementQuantity() {
        orderItemQuantity += 1;
        orderItemUnitPrice = product.getProductPrice() * orderItemQuantity;
    }

    public void decrementQuantity() {
        orderItemQuantity -= 1;
        orderItemUnitPrice = product.getProductPrice() * orderItemQuantity;
    }

}