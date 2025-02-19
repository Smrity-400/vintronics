package edu.rims.vintronics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.vintronics.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{
        
}
