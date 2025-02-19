package edu.rims.vintronics.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import edu.rims.vintronics.constant.Rating;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "review")
@Getter
@Setter

public class  Review extends Auditable {

    @Id
    @Column(name = "review_id", nullable = false, unique = true)
    private String reviewId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Enumerated(EnumType.STRING) // Store ENUM as a string (ONE, TWO, etc.)
    @Column(name = "rating", nullable = false)
    private Rating rating;

    @Column(name = "review_text")
    private String reviewText;

    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
