package edu.rims.vintronics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rims.vintronics.entity.User;
import edu.rims.vintronics.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int getUserId(String email){
        return userRepository.findByUserEmail(email).orElseThrow().getUserId();
    }

    public User getUser(String email){
        return userRepository.findByUserEmail(email).orElseThrow();
    }
    
}
