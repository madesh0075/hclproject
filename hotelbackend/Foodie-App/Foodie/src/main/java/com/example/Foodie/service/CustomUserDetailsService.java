package com.example.Foodie.service;

import com.example.Foodie.model.Admin;
import com.example.Foodie.model.User;
import com.example.Foodie.repository.AdminRepo;
import com.example.Foodie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Check User table
        User user = userRepository.findByEmail(username);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    List.of(new SimpleGrantedAuthority(user.getRole()))
            );
        }

        // Check Admin table
        Admin admin = adminRepo.findByEmail(username);
        if (admin != null) {
            return new org.springframework.security.core.userdetails.User(
                    admin.getEmail(),
                    admin.getPassword(),
                    List.of(new SimpleGrantedAuthority(admin.getRole()))
            );
        }

        throw new UsernameNotFoundException("User not found");
    }
}