package com.hemalatha.druginventory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hemalatha.druginventory.repository.DrugRepository;
import com.hemalatha.druginventory.repository.ShipmentRepository;
import com.hemalatha.druginventory.repository.SupplyOrderRepository;


@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "http://localhost:3000")
public class ReportController {

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private SupplyOrderRepository supplyOrderRepository;   

    

    @GetMapping("/inventory")
    public Map<String, Object> inventoryReport() {

        long available =
                drugRepository.countByStockGreaterThan(100);
        long lowStock =
        drugRepository.countByStockBetween(1, 100);

        long outOfStock =
                drugRepository.countByStock(0);

        Map<String,Object> response =
                new HashMap<>();

        response.put("available", available);
        response.put("lowStock", lowStock);
        response.put("outOfStock", outOfStock);

        return response;
    }

    @GetMapping("/shipment-status")
    public Map<String, Long> shipmentStatus() {

        Map<String, Long> map = new HashMap<>();

        map.put("Delivered",
                shipmentRepository.countByStatus("Delivered"));

        map.put("Pending",
                shipmentRepository.countByStatus("Pending"));

        map.put("In Transit",
                shipmentRepository.countByStatus("In Transit"));

        return map;
    }
  
    @GetMapping("/vendor")
    public List<Object[]> vendorReport() {
        return supplyOrderRepository.vendorPerformanceReport();
}
     @GetMapping("/monthly")
     public List<Object[]> monthlyReport(
        @RequestParam String fromDate,@RequestParam String toDate) {
                return shipmentRepository.monthlyDistributionReport(fromDate,toDate);
}
}