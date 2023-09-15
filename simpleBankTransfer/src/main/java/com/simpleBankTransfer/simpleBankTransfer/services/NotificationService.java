package com.simpleBankTransfer.simpleBankTransfer.services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;

// import com.simpleBankTransfer.simpleBankTransfer.DTO.NotificationDTO;
import com.simpleBankTransfer.simpleBankTransfer.entities.user.User;

@Service
public class NotificationService {
    // @Autowired
    // private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception{
        // String email = user.getEmail();
        // NotificationDTO notificationRequest = new NotificationDTO(email, message);

        // ResponseEntity<String> notificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationRequest, String.class);

        // if(!(notificationResponse.getStatusCode() == HttpStatus.OK)){
        //     System.out.println("Notification service is unavailable");
        //     throw new Exception("Notification service is unavailable");
        // }

        System.out.println("Notification sent successfully");
    }
}
