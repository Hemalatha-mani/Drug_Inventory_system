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

import com.hemalatha.druginventory.entity.Shipment;
import com.hemalatha.druginventory.repository.ShipmentRepository;
import com.hemalatha.druginventory.service.EmailService;


@RestController
@RequestMapping("/api/shipments")

@CrossOrigin(origins = "*")

public class ShipmentController {

    @Autowired
    private ShipmentRepository repository;
    @Autowired
    private EmailService emailService;

    @GetMapping
    public List<Shipment> getAllShipments() {
        return repository.findAll();
    }

    @PostMapping
    public Shipment addShipment(
        @RequestBody Shipment shipment
    ) {
        if (shipment == null) {
        throw new RuntimeException(
            "Shipment data cannot be null");
    }
        return repository.save(shipment);
    }

    @PutMapping("/{id}")
    public Shipment updateShipment(
        @PathVariable long id,
        @RequestBody Shipment shipment
    ) {

        Shipment existing =
        repository.findById(id).orElseThrow();

        existing.setOrderId(
            shipment.getOrderId()
        );

        existing.setShipmentDate(
            shipment.getShipmentDate()
        );

        existing.setExpectedDelivery(
            shipment.getExpectedDelivery()
        );

        existing.setStatus(
            shipment.getStatus()
        );
        if(existing.getStatus().equalsIgnoreCase("Delivered")){

    emailService.sendEmail(
        "bloodbank.admin@gmail.com",
        "Shipment Delivered",
        "Shipment ID : " + existing.getShipmentId()
        + "\nOrder ID : " + existing.getOrderId()
        + "\n\nShipment has been delivered successfully."
    );

}
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteShipment(
        @PathVariable long id
    ) {
        repository.deleteById(id);
    }
}
