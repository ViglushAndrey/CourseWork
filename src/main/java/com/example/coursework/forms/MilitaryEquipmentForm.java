package com.example.coursework.forms;

import com.example.coursework.model.BMP;
import com.example.coursework.model.BTR;
import com.example.coursework.model.Tanks;

public class MilitaryEquipmentForm {

    private String id;
    // private String types;

    private String tanks;
    private String numberOfTanks;
    private String bmp;
    private String numberOfBmp;
    private String btr;
    private String numberOfBtr;
    private String totalMilitaryEquipment;

    public MilitaryEquipmentForm() {
    }

    public MilitaryEquipmentForm(String id, String tanks, String numberOfTanks, String bmp, String numberOfBmp, String btr, String numberOfBtr, String totalMilitaryEquipment) {
        this.id = id;
        this.tanks = tanks;
        this.numberOfTanks = numberOfTanks;
        this.bmp = bmp;
        this.numberOfBmp = numberOfBmp;
        this.btr = btr;
        this.numberOfBtr = numberOfBtr;
        this.totalMilitaryEquipment = totalMilitaryEquipment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTanks() {
        return tanks;
    }

    public void setTanks(String tanks) {
        this.tanks = tanks;
    }

    public String getNumberOfTanks() {
        return numberOfTanks;
    }

    public void setNumberOfTanks(String numberOfTanks) {
        this.numberOfTanks = numberOfTanks;
    }

    public String getBmp() {
        return bmp;
    }

    public void setBmp(String bmp) {
        this.bmp = bmp;
    }

    public String getNumberOfBmp() {
        return numberOfBmp;
    }

    public void setNumberOfBmp(String numberOfBmp) {
        this.numberOfBmp = numberOfBmp;
    }

    public String getBtr() {
        return btr;
    }

    public void setBtr(String btr) {
        this.btr = btr;
    }

    public String getNumberOfBtr() {
        return numberOfBtr;
    }

    public void setNumberOfBtr(String numberOfBtr) {
        this.numberOfBtr = numberOfBtr;
    }

    public String getTotalMilitaryEquipment() {
        return totalMilitaryEquipment;
    }

    public void setTotalMilitaryEquipment(String totalMilitaryEquipment) {
        this.totalMilitaryEquipment = totalMilitaryEquipment;
    }
}
