package com.hemalatha.druginventory.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hemalatha.druginventory.entity.Drug;
import com.hemalatha.druginventory.repository.DrugRepository;

@Service
public class ExpiryAlertService {

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 9 * * ?")
    public void checkExpiry() {

        List<Drug> drugs = drugRepository.findAll();

        LocalDate today = LocalDate.now();

        for (Drug drug : drugs) {

            if (drug.getExpiryDate() == null)
                continue;

            long days = ChronoUnit.DAYS.between(today, drug.getExpiryDate());

            // Expiry within 30 days
            if (days >= 0 && days <= 30) {

                emailService.sendEmail(
                        "bloodbank.admin@gmail.com",
                        "Medicine Expiry Alert",
                        "Medicine Name : " + drug.getDrugName()
                        + "\nBatch No : " + drug.getBatchNo()
                        + "\nExpiry Date : " + drug.getExpiryDate()
                        + "\nRemaining Days : " + days
                        + "\n\nThis medicine will expire within 30 days."
                        + "\nPlease take necessary action."
                );
            }

            // Already Expired
            if (drug.getExpiryDate().isBefore(today)) {

                emailService.sendEmail(
                        "bloodbank.admin@gmail.com",
                        "Expired Medicine Alert",
                        "Medicine Name : " + drug.getDrugName()
                        + "\nBatch No : " + drug.getBatchNo()
                        + "\nExpired On : " + drug.getExpiryDate()
                        + "\n\nPlease remove this medicine immediately."
                );
            }
        }
    }
}

