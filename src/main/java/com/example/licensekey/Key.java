package com.example.licensekey;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Key {
    private SimpleIntegerProperty id;
    private SimpleStringProperty serialNumber;
    private SimpleStringProperty licenseKey;

    public Key(int id, String serialNumber, String licenseKey ) {
        this.id = new SimpleIntegerProperty(id);
        this.serialNumber = new SimpleStringProperty(serialNumber);
        this.licenseKey = new SimpleStringProperty(licenseKey);

    }

    public String getSerialNumber() {
        return serialNumber.get();
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = new SimpleStringProperty(serialNumber);
    }

    public String getLicenseKey() {
        return licenseKey.get();
    }

    public void setLicenseKey(String licenseKey) {
        this.licenseKey = new SimpleStringProperty(licenseKey);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }
}
