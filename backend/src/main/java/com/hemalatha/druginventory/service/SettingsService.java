package com.hemalatha.druginventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemalatha.druginventory.entity.Settings;
import com.hemalatha.druginventory.repository.SettingsRepository;

@Service
public class SettingsService {

    @Autowired
    private SettingsRepository repository;

    public String getBackupFrequency() {

        Settings settings =
                repository.findById(1L)
                          .orElseThrow();

        return settings.getBackupFrequency();
    }
}