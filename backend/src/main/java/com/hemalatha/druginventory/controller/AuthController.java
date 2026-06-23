package com.hemalatha.druginventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hemalatha.druginventory.entity.User;
import com.hemalatha.druginventory.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public User login(
            @RequestBody User user) {

        return repository
                .findByUsernameAndPassword(
                        user.getUsername(),
                        user.getPassword());
    }
}