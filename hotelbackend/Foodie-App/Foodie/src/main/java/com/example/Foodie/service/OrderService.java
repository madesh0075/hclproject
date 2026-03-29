package com.example.Foodie.service;

import com.example.Foodie.model.Orders;
import com.example.Foodie.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EmailService emailService;

    // 🔥 ADD ORDER + SEND EMAIL
    public Orders Addorder(Orders order, String email) {

        Orders savedOrder = orderRepository.save(order);

        try {
            emailService.sendOrderMail(
                    email,
                    order.getFood(),
                    order.getTotalprice()
            );
        } catch (Exception e) {
            System.out.println("Email Error: " + e.getMessage());
        }

        return savedOrder;
    }

    // 🔥 CANCEL ORDER
    public Orders cancelorder(int id){
        Orders order = orderRepository.findById(id).orElse(null);

        if(order != null){
            order.setStatus("CANCELLED");
            return orderRepository.save(order);
        }

        return null;
    }
}