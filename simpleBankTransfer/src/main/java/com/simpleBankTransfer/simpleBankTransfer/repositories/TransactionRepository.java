package com.simpleBankTransfer.simpleBankTransfer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleBankTransfer.simpleBankTransfer.entities.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    
}
