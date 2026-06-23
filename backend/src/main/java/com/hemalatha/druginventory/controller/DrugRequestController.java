package com.hemalatha.druginventory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hemalatha.druginventory.entity.DrugRequest;
import com.hemalatha.druginventory.repository.DrugRequestRepository;

@RestController
@RequestMapping("/api/drugrequests")
@CrossOrigin(origins = "*")
public class DrugRequestController {

    private final DrugRequestRepository repository;

    public DrugRequestController(
            DrugRequestRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<DrugRequest> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public DrugRequest add(
            @RequestBody DrugRequest request) {
        if (request == null) {
        throw new RuntimeException(
            "Request data cannot be null");
    }

        return repository.save(request);
    }

    @PutMapping("/{id}")
    public DrugRequest update(
            @PathVariable long id,
            @RequestBody DrugRequest request) {

        request.setRequestId(id);

        return repository.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable long id) {

        repository.deleteById(id);
    }
}
