package com.hemalatha.druginventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hemalatha.druginventory.entity.Shipment;
public interface ShipmentRepository
        extends JpaRepository<Shipment, Long> {
   
    @Query("""
           SELECT COUNT(s)
           FROM Shipment s
           WHERE s.status='Pending'
           """)
    Long getPendingShipments();

    long countByStatus(String status);

     @Query(value = """
SELECT
SUBSTRING(shipment_date,6,2),
COUNT(*)
FROM shipments
WHERE shipment_date BETWEEN :fromDate AND :toDate
GROUP BY SUBSTRING(shipment_date,6,2)
ORDER BY SUBSTRING(shipment_date,6,2)
""", nativeQuery = true)
List<Object[]> monthlyDistributionReport(
        @Param("fromDate") String fromDate,
        @Param("toDate") String toDate);
}
