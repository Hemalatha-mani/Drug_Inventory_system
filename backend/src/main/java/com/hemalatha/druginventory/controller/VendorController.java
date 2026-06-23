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

import com.hemalatha.druginventory.entity.Vendor;
import com.hemalatha.druginventory.repository.VendorRepository;

@RestController
@RequestMapping("/api/vendors")
@CrossOrigin(origins = "http://localhost:3000")
public class VendorController {

    @Autowired
    private VendorRepository repository;

    @GetMapping
    public List<Vendor> getAllVendors() {
        return repository.findAll();
    }

    @PostMapping
    public Vendor addVendor(
            @RequestBody Vendor vendor) {
        if (vendor == null) {
        throw new RuntimeException(
            "Vendor data cannot be null");
    }
        return repository.save(vendor);
    }

    @PutMapping("/{id}")
    public Vendor updateVendor(
            @PathVariable long id,
            @RequestBody Vendor updatedVendor) {

        Vendor vendor = repository
                .findById(id)
                .orElseThrow();

        vendor.setVendorName(
                updatedVendor.getVendorName());

        vendor.setContactPerson(
                updatedVendor.getContactPerson());

        vendor.setPhone(
                updatedVendor.getPhone());

        vendor.setEmail(
                updatedVendor.getEmail());

        return repository.save(vendor);
    }

    @DeleteMapping("/{id}")
    public void deleteVendor(
            @PathVariable long id) {

        repository.deleteById(id);
    }
}