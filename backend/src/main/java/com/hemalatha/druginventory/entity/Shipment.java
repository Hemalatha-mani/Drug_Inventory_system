package com.hemalatha.druginventory.entity;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="shipments")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipmentId;

    private Long orderId;

    private LocalDate shipmentDate;
    private LocalDate expectedDelivery;
    

    private String status;
}