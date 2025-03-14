package edu.rims.vintronics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.rims.vintronics.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findByCategory(Category category);

    List<Product> findByCategoryCategoryId(String categoryId);

}
