package com.hemalatha.druginventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hemalatha.druginventory.entity.User;
import com.hemalatha.druginventory.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins="http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @PostMapping
    public User addUser(
            @RequestBody User user) {
        if (user == null) {
        throw new RuntimeException(
            "User data cannot be null");
    }
        return repository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable long id,
            @RequestBody User updatedUser) {

        User user =
            repository.findById(id)
            .orElseThrow();

        user.setFullName(
                updatedUser.getFullName());

        user.setEmail(
                updatedUser.getEmail());

        user.setPhone(
                updatedUser.getPhone());

        user.setRole(
                updatedUser.getRole());

        user.setUsername(
                updatedUser.getUsername());

        user.setPassword(
                updatedUser.getPassword());

        user.setStatus(
                updatedUser.getStatus());

        return repository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(
            @PathVariable long id) {

        repository.deleteById(id);
    }
}
