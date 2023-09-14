package com.simpleBankTransfer.simpleBankTransfer.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.simpleBankTransfer.simpleBankTransfer.DTO.TransactionDTO;
import com.simpleBankTransfer.simpleBankTransfer.entities.transaction.Transaction;
import com.simpleBankTransfer.simpleBankTransfer.entities.user.User;
import com.simpleBankTransfer.simpleBankTransfer.repositories.TransactionRepository;

@Service
public class TransactionService {
    
    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Transaction createTransaction(TransactionDTO transaction) throws Exception{
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.amount());

        // if(!this.authorizeTransaction(sender, transaction.amount()))
        //     throw new Exception("Transaction not authorized");

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.amount());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimeStamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.amount()));
        receiver.setBalance(receiver.getBalance().add(transaction.amount()));

        transactionRepository.save(newTransaction);
        userService.saveUser(sender);
        userService.saveUser(receiver);

        this.notificationService.sendNotification(sender, "Transfer completed successfully");
        this.notificationService.sendNotification(receiver, "Transfer received successfully");

        return newTransaction;
    }

    public boolean authorizeTransaction(User sender, BigDecimal amount){
        var responseEntity = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);

        if(responseEntity.getStatusCode() == HttpStatus.OK){
            String message = (String) responseEntity.getBody().get("message");
            return "Autorizado".equalsIgnoreCase(message);
        }

        return false;
    }
}
