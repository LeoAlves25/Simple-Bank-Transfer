package com.simpleBankTransfer.simpleBankTransfer.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.simpleBankTransfer.simpleBankTransfer.DTO.ExceptionDTO;

import jakarta.persistence.EntityNotFoundException;

@RestController
public class ControllerExceptionHandler {
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threatDuplicateEntry(DataIntegrityViolationException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Already registered user ", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(EntityNotFoundException ex){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity threat500(Exception ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage(), "500");
        return ResponseEntity.status(500).body(exceptionDTO);
    }
}
