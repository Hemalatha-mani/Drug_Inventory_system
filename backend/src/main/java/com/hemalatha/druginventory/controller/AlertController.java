package com.hemalatha.druginventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hemalatha.druginventory.entity.Alert;
import com.hemalatha.druginventory.repository.AlertRepository;

@RestController

@RequestMapping("/api/alerts")
@CrossOrigin(origins = "http://localhost:3000")
public class AlertController {

    @Autowired
    private AlertRepository repository;

    @GetMapping
    public List<Alert> getAllAlerts() {
        return repository.findAll();
    }
    
    @DeleteMapping("/{id}")
    public void deleteAlert(@PathVariable("id") long id) {
        
        if (repository.existsById(id)) {
        repository.deleteById(id);
    }
       
    }
}