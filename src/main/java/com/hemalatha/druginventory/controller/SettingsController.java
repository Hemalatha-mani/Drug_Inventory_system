package com.hemalatha.druginventory.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hemalatha.druginventory.entity.Settings;
import com.hemalatha.druginventory.repository.SettingsRepository;
@RestController
@RequestMapping("/api/settings")
@CrossOrigin(origins="http://localhost:3000")
public class SettingsController {

    @Autowired
    private SettingsRepository repository;

    @GetMapping
    public Settings getSettings(){

        return repository
                .findById(1L)
                .orElse(null);
    }

    @PutMapping
    public Settings updateSettings(
            @RequestBody Settings settings){

        settings.setSettingId(1L);

        return repository.save(settings);
    }
}
