package com.hemalatha.druginventory.controller;

import java.time.LocalDate;
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

import com.hemalatha.druginventory.entity.Alert;
import com.hemalatha.druginventory.entity.Drug;
import com.hemalatha.druginventory.repository.AlertRepository;
import com.hemalatha.druginventory.repository.DrugRepository;
import com.hemalatha.druginventory.service.EmailService;

@RestController
@RequestMapping("/api/drugs")
@CrossOrigin(origins = "http://localhost:3000")
public class DrugController {

    private final DrugRepository repository;
    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private EmailService emailService;

    public DrugController(DrugRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Drug> getAllDrugs() {
        return repository.findAll();
    }

    @PostMapping
public Drug addDrug(@RequestBody Drug drug) {
    if (drug == null) {
        throw new RuntimeException("Drug data cannot be null");
    }


    Drug savedDrug = repository.save(drug);
    if(savedDrug.getStock() == 0){

    alertRepository.deleteByDrugName(savedDrug.getDrugName());

    Alert alert = new Alert();

    alert.setAlertType("Out Of Stock");
    alert.setDrugName(savedDrug.getDrugName());
    alert.setMessage("Drug is out of stock");
    alert.setAlertDate(LocalDate.now());
    alert.setPriority("High");

    alertRepository.save(alert);

}

    else if(savedDrug.getStock() < 100 ){
        //System.out.println("Inside Alert Condition");
        System.out.println("Creating Alert for " + savedDrug.getDrugName());


        Alert alert = new Alert();

        alert.setAlertType("Low Stock");
        alert.setDrugName(savedDrug.getDrugName());
        alert.setMessage("Stock below 100 units");
        alert.setAlertDate(LocalDate.now());
        alert.setPriority("High");

        alertRepository.save(alert);
        System.out.println("Alert Saved");

        emailService.sendEmail(
    "admin@gmail.com",
    "Low Stock Alert",
    savedDrug.getDrugName() +
    " stock is below threshold"
);
    }

    return savedDrug;
}

    @PutMapping("/{id}")
public Drug updateDrug(
        @PathVariable long id,
        @RequestBody Drug updatedDrug) {

    Drug drug = repository.findById(id).orElseThrow(() -> new RuntimeException(
                      "Drug not found"
                  ));

    drug.setDrugName(updatedDrug.getDrugName());
    drug.setCategory(updatedDrug.getCategory());
    drug.setBatchNo(updatedDrug.getBatchNo());
    drug.setExpiryDate(updatedDrug.getExpiryDate());
    drug.setStock(updatedDrug.getStock());

    Drug savedDrug = repository.save(drug);
    System.out.println("Stock = " + savedDrug.getStock());
    
    if(savedDrug.getStock() == 0){

    alertRepository.deleteByDrugName(savedDrug.getDrugName());

    Alert alert = new Alert();

    alert.setAlertType("Out Of Stock");
    alert.setDrugName(savedDrug.getDrugName());
    alert.setMessage("Drug is out of stock");
    alert.setAlertDate(LocalDate.now());
    alert.setPriority("High");

    alertRepository.save(alert);

}
    else if(savedDrug.getStock() < 100 ){
        alertRepository.deleteByDrugName(savedDrug.getDrugName());


        Alert alert = new Alert();

        alert.setAlertType("Low Stock");
        alert.setDrugName(savedDrug.getDrugName());
        alert.setMessage("Stock below 100 units");
        alert.setAlertDate(LocalDate.now());
        alert.setPriority("High");

        alertRepository.save(alert);
    }
    else {

    alertRepository.deleteByDrugName(savedDrug.getDrugName());

}


    return savedDrug;
}

    @DeleteMapping("/{id}")
    public void deleteDrug(@PathVariable long id) {
        repository.deleteById(id);
    }
}