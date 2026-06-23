package com.hemalatha.druginventory.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="settings")
public class Settings {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long settingId;

    private String hospitalName;
    private String email;
    private String phone;

    private Integer lowStockThreshold;
    private Integer expiryAlertDays;

    private String emailNotifications;
    private String smsNotifications;

    private String backupFrequency;

    public String getHospitalName() {
    return hospitalName;
}

public void setHospitalName(String hospitalName) {
    this.hospitalName = hospitalName;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getPhone() {
    return phone;
}

public void setPhone(String phone) {
    this.phone = phone;
}

public Integer getLowStockThreshold() {
    return lowStockThreshold;
}

public void setLowStockThreshold(Integer lowStockThreshold) {
    this.lowStockThreshold = lowStockThreshold;
}

public Integer getExpiryAlertDays() {
    return expiryAlertDays;
}

public void setExpiryAlertDays(Integer expiryAlertDays) {
    this.expiryAlertDays = expiryAlertDays;
}

public String getEmailNotifications() {
    return emailNotifications;
}

public void setEmailNotifications(String emailNotifications) {
    this.emailNotifications = emailNotifications;
}

public String getSmsNotifications() {
    return smsNotifications;
}

public void setSmsNotifications(String smsNotifications) {
    this.smsNotifications = smsNotifications;
}

    // Generate Getters & Setters
    public Long getSettingId() {
    return settingId;
}
    
    public void setSettingId(Long settingId) {
        this.settingId = settingId;
}
    public String getBackupFrequency() {
    return backupFrequency;
}

    public void setBackupFrequency(String backupFrequency) {
        this.backupFrequency = backupFrequency;
}
}
