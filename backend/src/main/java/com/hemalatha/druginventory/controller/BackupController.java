package com.hemalatha.druginventory.controller;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BackupController {

    @GetMapping("/api/backup/run")
    public String runBackup() {

        try {

            File folder = new File("backups");

            if(!folder.exists()) {
                folder.mkdir();
            }

            String fileName =
                "backup_" +
                LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern(
                    "yyyyMMdd_HHmmss"))
                + ".sql";

            String backupPath =
        folder.getAbsolutePath()
        + "/" + fileName;

ProcessBuilder pb =
        new ProcessBuilder(

        "/Applications/Postgres.app/Contents/Versions/latest/bin/pg_dump",

        "-U",
        "postgres",

        "-d",
        "druginventory",

        "-f",
        backupPath
);

pb.environment().put(
        "PGPASSWORD",
        "postgres123");

Process process = pb.start();

int exitCode = process.waitFor();

if(exitCode == 0) {

    return "Backup Created Successfully";

} else {

    return "Backup Failed. Exit Code = " + exitCode;
}

        } catch(Exception e) {

            e.printStackTrace();

            return "Backup Failed : " + e.getMessage();
        }
    }
}