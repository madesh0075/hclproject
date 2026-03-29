package com.example.Foodie.controller;

import com.example.Foodie.model.Orders;
import com.example.Foodie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 🔥 ADD ORDER + EMAIL
    @PostMapping("/add-order")
    public Orders Addorder(@RequestBody Orders order,
                           @RequestParam String email) {

        System.out.println("Order controller hit");
        return orderService.Addorder(order, email);
    }

    // 🔥 CANCEL ORDER
    @PutMapping("/cancel-order/{id}")
    public Orders cancelorder(@PathVariable int id){
        return orderService.cancelorder(id);
    }
}