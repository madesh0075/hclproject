package com.example.Foodie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendOrderMail(String toEmail, String food, int price) {


        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Order Confirmation");
        message.setText("Order Confirmed\nFood: " + food + "\nPrice: " + price);
        message.setFrom("madhanarasan3@gmail.com");

        mailSender.send(message);

        System.out.println("==== MAIL SENT ====");
    }
}