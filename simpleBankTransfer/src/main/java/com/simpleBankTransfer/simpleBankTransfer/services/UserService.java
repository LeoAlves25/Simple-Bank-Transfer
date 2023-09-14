package com.simpleBankTransfer.simpleBankTransfer.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleBankTransfer.simpleBankTransfer.DTO.UserDTO;
import com.simpleBankTransfer.simpleBankTransfer.entities.user.User;
import com.simpleBankTransfer.simpleBankTransfer.entities.user.UserType;
import com.simpleBankTransfer.simpleBankTransfer.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception{
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Merchant cannot make transactions");
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Insufficient funds");
        }
    }

    public User findUserById(Long id) throws Exception{
        return userRepository.findUserById(id).orElseThrow(() -> new Exception("User not found"));
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User createUser(UserDTO user) {
        User newUser = new User(user);

        return userRepository.save(newUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
