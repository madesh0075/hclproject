package com.example.Foodie.repository;

import com.example.Foodie.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin, Integer> {



    //Admin findByEmailAndPassword(String email, String password);

    Admin findByEmail(String email);
}
