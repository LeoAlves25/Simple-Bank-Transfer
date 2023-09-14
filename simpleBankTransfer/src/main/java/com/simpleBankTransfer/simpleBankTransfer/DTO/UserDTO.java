package com.simpleBankTransfer.simpleBankTransfer.DTO;

import java.math.BigDecimal;

import com.simpleBankTransfer.simpleBankTransfer.entities.user.UserType;

public record UserDTO(String firstName, String lastName, String document, BigDecimal balance, String email, String password, UserType userType) {
    
}
