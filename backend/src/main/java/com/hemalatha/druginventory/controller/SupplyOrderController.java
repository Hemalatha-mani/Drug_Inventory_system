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

import com.hemalatha.druginventory.entity.SupplyOrder;
import com.hemalatha.druginventory.repository.SupplyOrderRepository;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class SupplyOrderController {

    @Autowired
    private SupplyOrderRepository repository;

    @GetMapping
    public List<SupplyOrder> getAllOrders() {
        return repository.findAll();
    }

    @PostMapping
    public SupplyOrder addOrder(
            @RequestBody SupplyOrder order) {
        if (order == null) {
        throw new RuntimeException(
            "order data cannot be null");
    }
        return repository.save(order);
    }

    @PutMapping("/{id}")
    public SupplyOrder updateOrder(
            @PathVariable long id,
            @RequestBody SupplyOrder updatedOrder) {

        SupplyOrder order =
                repository.findById(id)
                .orElseThrow();

        order.setVendor(updatedOrder.getVendor());
        order.setOrderDate(updatedOrder.getOrderDate());
        order.setTotalAmount(updatedOrder.getTotalAmount());
        order.setStatus(updatedOrder.getStatus());

        return repository.save(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(
            @PathVariable long id) {

        repository.deleteById(id);
    }
}
