package com.hemalatha.druginventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemalatha.druginventory.entity.Settings;
public interface SettingsRepository extends JpaRepository<Settings,Long>{

}
