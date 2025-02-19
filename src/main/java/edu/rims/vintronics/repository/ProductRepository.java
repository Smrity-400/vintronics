package edu.rims.vintronics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.rims.vintronics.entity.Product;
import edu.rims.vintronics.entity.Category;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    // Fetch products by category entity
    List<Product> findByCategory(Category category);

    // Fetch products by categoryId directly (More efficient)
    List<Product> findByCategoryCategoryId(String categoryId);
}
