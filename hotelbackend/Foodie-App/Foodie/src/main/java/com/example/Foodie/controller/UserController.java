package com.example.Foodie.controller;


import com.example.Foodie.model.User;
import com.example.Foodie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public User Adduser(@RequestBody User user){
        return userService.Adduser(user);
    }

    @PostMapping("user-login")
    public String UserLogin(@RequestBody User user){
        return userService.Userlogin(user.getEmail(),user.getPassword());

    }

    @GetMapping("show-user")
    public List<User> Getalluser(){
        return userService.Getalluser();
    }

}
