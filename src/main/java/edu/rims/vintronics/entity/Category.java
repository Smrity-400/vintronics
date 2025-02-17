package edu.rims.vintronics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import edu.rims.vintronics.constant.CategoryStatus;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category extends Auditable {
    
    @Id
    @Column(name = "category_id", nullable = false, length = 255)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String categoryId;

    @Column(name = "category_title", nullable = false, length = 255)
    private String categoryTitle;

    @Column(name = "category_description", columnDefinition = "TEXT")
    private String categoryDescription;

    @Column(name = "category_image_url", nullable = false, columnDefinition = "TEXT")
    private String categoryImageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_status", columnDefinition = "ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE'")
    private CategoryStatus categoryStatus = CategoryStatus.ACTIVE;

    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "updated_date")
    private LocalDateTime updatedDate = LocalDateTime.now();

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @PreUpdate
    public void preUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}