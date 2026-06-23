package com.hemalatha.druginventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hemalatha.druginventory.entity.Drug;

public interface DrugRepository extends JpaRepository<Drug, Long> {

    @Query("SELECT COUNT(d) FROM Drug d")
    Long getTotalDrugs();

    @Query("SELECT SUM(d.stock) FROM Drug d")
    Long getTotalStock();

    @Query("SELECT COUNT(d) FROM Drug d WHERE d.stock BETWEEN 1 AND 100")
    Long getLowStockCount();

    


    long countByStockGreaterThan(int stock);

    long countByStockBetween(
            int start,
            int end
    );

    long countByStock(int stock);
    
}