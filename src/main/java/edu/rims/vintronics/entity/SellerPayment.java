package edu.rims.vintronics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import edu.rims.vintronics.constant.SellerPaymentMethod;
import edu.rims.vintronics.constant.SellerPaymentStatus;

import java.math.BigDecimal;

@Entity
@Table(name = "SellerPayment")
@Getter
@Setter
public class SellerPayment extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sellerPaymentId;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    private Order order;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "seller_payment_status", nullable = false)
    private SellerPaymentStatus sellerPaymentStatus = SellerPaymentStatus.PENDING;

    @Enumerated(EnumType.STRING)
    @Column(name = "seller_payment_method", nullable = false)
    private SellerPaymentMethod sellerPaymentMethod;

    @Column(name = "transaction_reference", unique = true, length = 255)
    private String transactionReference;

}

