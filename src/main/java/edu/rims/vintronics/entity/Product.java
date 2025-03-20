package edu.rims.vintronics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import edu.rims.vintronics.constant.ProductStatus;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product extends Auditable {

    @Id
    @Column(name = "product_id", nullable = false, length = 255)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productId;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @JoinColumn(name = "seller_id", nullable = false)
    @ManyToOne
    private Seller seller;

    @Column(name = "product_title", nullable = false, length = 255)
    private String productTitle;

    @Column(name = "product_description", columnDefinition = "TEXT")
    private String productDescription;

    @Column(name = "product_price", nullable = false)
    private Double productPrice;

    @Column(name = "product_stock_quantity", nullable = false)
    private Integer productStockQuantity;

    @Column(name = "product_image_url", nullable = false, columnDefinition = "TEXT")
    private String productImageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_status", columnDefinition = "ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE'")
    private ProductStatus productStatus = ProductStatus.ACTIVE;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    public void addWidget(Widget widget) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addWidget'");
    }

    public void removeWidget(Widget widget) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeWidget'");
    }
}