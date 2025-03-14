package edu.rims.vintronics.repository;

import edu.rims.vintronics.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    void save(java.util.Locale.Category category);
}