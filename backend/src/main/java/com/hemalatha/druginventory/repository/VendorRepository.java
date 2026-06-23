package com.hemalatha.druginventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemalatha.druginventory.entity.Vendor;

public interface VendorRepository
        extends JpaRepository<Vendor, Long> {
}
