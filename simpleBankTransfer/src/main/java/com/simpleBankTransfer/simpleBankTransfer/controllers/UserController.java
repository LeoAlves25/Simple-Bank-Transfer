package com.simpleBankTransfer.simpleBankTransfer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpleBankTransfer.simpleBankTransfer.DTO.UserDTO;
import com.simpleBankTransfer.simpleBankTransfer.entities.user.User;
import com.simpleBankTransfer.simpleBankTransfer.services.UserService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDTO user){
        User newUser = userService.createUser(user);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
