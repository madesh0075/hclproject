package com.example.Foodie.service;

import com.example.Foodie.model.Admin;
import com.example.Foodie.model.Hotel;
import com.example.Foodie.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 🔥 REGISTER (FIXED)
    public Admin register(Admin admin) {

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setRole("ADMIN");

        // 🔥 Use hotel sent from frontend
        Hotel hotel = admin.getHotel();

        if (hotel == null) {
            throw new RuntimeException("Hotel details required");
        }

        return adminRepo.save(admin);
    }

    // 🔥 GET ALL
    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    // 🔥 LOGIN (IMPORTANT)
    public Admin adminLogin(String email, String password) {

        Admin admin = adminRepo.findByEmail(email);

        if (admin == null) {
            return null;
        }

        if (passwordEncoder.matches(password, admin.getPassword())) {
            return admin; // 🔥 contains hotel
        } else {
            return null;
        }
    }
}