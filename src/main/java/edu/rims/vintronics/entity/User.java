package edu.rims.vintronics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import edu.rims.vintronics.constant.UserRole;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "user_name", nullable = false, length = 255)
    private String userName;

    @Column(name = "user_email", nullable = false, unique = true, length = 255)
    private String userEmail;

    @Column(name = "user_password", nullable = false, length = 255)
    private String userPassword;

    @Column(name = "user_phone", length = 20)
    private String userPhone;

    @Column(name = "user_address", columnDefinition = "TEXT")
    private String userAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", columnDefinition = "ENUM('CUSTOMER', 'ADMIN', 'SELLER')")
    private UserRole userRole = UserRole.CUSTOMER;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

}