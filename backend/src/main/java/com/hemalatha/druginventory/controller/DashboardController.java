package com.hemalatha.druginventory.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hemalatha.druginventory.repository.DrugRepository;
import com.hemalatha.druginventory.repository.ShipmentRepository;
import com.hemalatha.druginventory.repository.SupplyOrderRepository;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private SupplyOrderRepository orderRepository;

    @GetMapping
    public Map<String,Object> getDashboardData(){

        Map<String,Object> data =
                new HashMap<>();

        data.put(
            "totalDrugs",
            drugRepository.getTotalDrugs()
        );

        data.put(
            "availableStock",
            drugRepository.getTotalStock()
        );

        data.put(
            "lowStock",
            drugRepository.getLowStockCount()
        );

        data.put(
            "pendingShipments",
            shipmentRepository.getPendingShipments()
        );
        data.put(
            "recentOrders",
            orderRepository.findTop5ByOrderByOrderIdDesc()
        );

        data.put(
    "deliveredShipments",
    shipmentRepository
        .countByStatus("Delivered")
);

data.put(
    "pendingShipments",
    shipmentRepository
        .countByStatus("Pending")
);

        return data;
    }
}
