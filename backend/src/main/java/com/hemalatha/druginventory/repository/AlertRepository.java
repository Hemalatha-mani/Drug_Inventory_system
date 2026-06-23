package com.hemalatha.druginventory.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hemalatha.druginventory.entity.Alert;

public interface AlertRepository
        extends JpaRepository<Alert, Long> {
                
                @Transactional
                void deleteByDrugName(String drugName);

}