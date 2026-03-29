package com.example.Foodie.controller;

import com.example.Foodie.model.Admin;
import com.example.Foodie.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // 🔥 REGISTER
    @PostMapping("/register")
    public Admin register(@RequestBody Admin admin) {
        return adminService.register(admin);
    }

    // 🔥 GET ALL ADMINS
    @GetMapping("/showAll")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    // 🔥 LOGIN (IMPORTANT)
    @PostMapping("/login")
    public ResponseEntity<?> AdminLogin(@RequestBody Admin admin) {

        Admin ad = adminService.adminLogin(admin.getEmail(), admin.getPassword());

        if (ad != null) {
            System.out.println("ADMIN HOTEL: " + ad.getHotel()); // debug
            return ResponseEntity.ok(ad); // 🔥 hotel also returned
        } else {
            return ResponseEntity.status(401).body("Invalid");
        }
    }
}