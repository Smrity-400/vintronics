package edu.rims.vintronics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.vintronics.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
