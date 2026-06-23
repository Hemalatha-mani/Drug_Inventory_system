package com.hemalatha.druginventory.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BackupService {

    @Scheduled(cron = "0 0 12 * * MON")
    public void weeklyBackup() {

        System.out.println(
            "Weekly Database Backup Executed"
        );
    }
}
