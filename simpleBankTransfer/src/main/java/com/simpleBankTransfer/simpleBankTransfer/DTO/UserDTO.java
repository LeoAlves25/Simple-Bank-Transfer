package com.simpleBankTransfer.simpleBankTransfer.DTO;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import com.simpleBankTransfer.simpleBankTransfer.entities.user.UserType;
import com.simpleBankTransfer.simpleBankTransfer.entities.user.groups.CnpjGroup;
import com.simpleBankTransfer.simpleBankTransfer.entities.user.groups.CpfGroup;
import com.simpleBankTransfer.simpleBankTransfer.infra.ClientGroupSequenceProvider;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@GroupSequenceProvider(value = ClientGroupSequenceProvider.class)
public record UserDTO(
    
    @NotBlank(message = "First name is required")
    String firstName, 
    
    @NotBlank(message = "Last name is required")
    String lastName, 
    
    @NotBlank(message = "CPF/CNPJ is required")
    @CPF(groups = CpfGroup.class, message = "CPF invalid")
    @CNPJ(groups = CnpjGroup.class, message = "CNPJ invalid")
    String document, 
    
    @NotNull(message = "Value is required")
    @Min(value = 0, message = "Value must be greater than zero")
    BigDecimal balance, 
   
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    String email, 
    
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    String password, 
    
    @NotNull(message = "User type is required")
    UserType userType) {}
