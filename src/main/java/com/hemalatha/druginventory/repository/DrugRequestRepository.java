package com.hemalatha.druginventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemalatha.druginventory.entity.DrugRequest;

public interface DrugRequestRepository
extends JpaRepository<DrugRequest, Long> {
}
