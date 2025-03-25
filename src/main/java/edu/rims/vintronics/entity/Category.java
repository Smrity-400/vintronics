package edu.rims.vintronics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

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
    @Column(name = "category_status", nullable = false)
    private CategoryStatus categoryStatus = CategoryStatus.ACTIVE;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public String getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}
