package edu.rims.vintronics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

import edu.rims.vintronics.constant.SellerStatus;

@Entity
@Table(name = "seller")
@Getter
@Setter
public class Seller extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Integer sellerId;

    @Column(name = "seller_name", nullable = false, length = 100)
    private String sellerName;

    @Column(name = "seller_store_name", nullable = false, length = 100)
    private String sellerStoreName;

    @Column(name = "seller_email", nullable = false, unique = true, length = 100)
    private String sellerEmail;

    @Column(name = "seller_phone", nullable = false, length = 15)
    private String sellerPhone;

    @Column(name = "gst_no", nullable = false, unique = true, length = 15)
    private String gstNo;

    @Column(name = "address", nullable = false, columnDefinition = "TEXT")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "seller_status", columnDefinition = "ENUM('Active','Inactive') DEFAULT 'Active'")
    private SellerStatus sellerStatus = SellerStatus.ACTIVE;

    @Column(name = "commission_percentage", precision = 5, scale = 2, columnDefinition = "DECIMAL(5,2) DEFAULT 5.00")
    private BigDecimal commissionPercentage = new BigDecimal("5.00");

    @Column(name = "seller_bank_account_number", nullable = false, unique = true, length = 20)
    private String sellerBankAccountNumber;

    @Column(name = "seller_ifsc_code", nullable = false, length = 11)
    private String sellerIfscCode;

}

