package com.hemalatha.druginventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hemalatha.druginventory.entity.SupplyOrder;

public interface SupplyOrderRepository
extends JpaRepository<SupplyOrder, Long> {
    @Query("""
    SELECT
    s.vendor,
    COUNT(s.orderId),
    SUM(s.totalAmount)
    FROM SupplyOrder s
    GROUP BY s.vendor
    """)
    List<Object[]> vendorPerformanceReport();

    List<SupplyOrder> findTop5ByOrderByOrderIdDesc();
}
