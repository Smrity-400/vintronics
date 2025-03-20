package edu.rims.vintronics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.vintronics.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer>{
    
}
