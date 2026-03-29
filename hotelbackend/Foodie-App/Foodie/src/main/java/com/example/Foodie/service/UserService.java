package com.example.Foodie.service;

import com.example.Foodie.model.User;
import com.example.Foodie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User Adduser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        return userRepository.save(user);
    }

    public String Userlogin(String email, String password) {
        User user=userRepository.findByEmail(email);
        if (user == null) {
            return "User not found";
        }

        if (passwordEncoder.matches(password, user.getPassword())) {
            return "Login Success";
        } else {
            return "Invalid Password";
        }
    }

    public List<User> Getalluser() {
        return userRepository.findAll();
    }


}
