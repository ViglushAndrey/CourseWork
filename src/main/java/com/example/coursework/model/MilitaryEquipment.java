package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.MilitaryEquipment
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:57
 * @Version: MilitaryEquipment: 1.0
 */
@Document
public class MilitaryEquipment {
    @Id
    private String id;
   // private String types;

    private Tanks tanks;
    private int numberOfTanks;
    private BMP bmp;
    private int numberOfBmp;
    private BTR btr;
    private int numberOfBtr;
    private String totalMilitaryEquipment;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public MilitaryEquipment() {
    }

    public MilitaryEquipment(String id, Tanks tanks, int numberOfTanks, BMP bmp, int numberOfBmp, BTR btr, int numberOfBtr, String totalMilitaryEquipment, LocalDateTime created_at, LocalDateTime modify_at) {
        this.id = id;
        this.tanks = tanks;
        this.numberOfTanks = numberOfTanks;
        this.bmp = bmp;
        this.numberOfBmp = numberOfBmp;
        this.btr = btr;
        this.numberOfBtr = numberOfBtr;
        this.totalMilitaryEquipment = totalMilitaryEquipment;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public MilitaryEquipment(Tanks tanks, int numberOfTanks, BMP bmp, int numberOfBmp, BTR btr, int numberOfBtr, String totalMilitaryEquipment, LocalDateTime created_at, LocalDateTime modify_at) {
        this.tanks = tanks;
        this.numberOfTanks = numberOfTanks;
        this.bmp = bmp;
        this.numberOfBmp = numberOfBmp;
        this.btr = btr;
        this.numberOfBtr = numberOfBtr;
        this.totalMilitaryEquipment = totalMilitaryEquipment;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tanks getTanks() {
        return tanks;
    }

    public void setTanks(Tanks tanks) {
        this.tanks = tanks;
    }

    public int getNumberOfTanks() {
        return numberOfTanks;
    }

    public void setNumberOfTanks(int numberOfTanks) {
        this.numberOfTanks = numberOfTanks;
    }

    public BMP getBmp() {
        return bmp;
    }

    public void setBmp(BMP bmp) {
        this.bmp = bmp;
    }

    public int getNumberOfBmp() {
        return numberOfBmp;
    }

    public void setNumberOfBmp(int numberOfBmp) {
        this.numberOfBmp = numberOfBmp;
    }

    public BTR getBtr() {
        return btr;
    }

    public void setBtr(BTR btr) {
        this.btr = btr;
    }

    public int getNumberOfBtr() {
        return numberOfBtr;
    }

    public void setNumberOfBtr(int numberOfBtr) {
        this.numberOfBtr = numberOfBtr;
    }

    public String getTotalMilitaryEquipment() {
        return totalMilitaryEquipment;
    }

    public void setTotalMilitaryEquipment(String totalMilitaryEquipment) {
        this.totalMilitaryEquipment = totalMilitaryEquipment;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getModify_at() {
        return modify_at;
    }

    public void setModify_at(LocalDateTime modify_at) {
        this.modify_at = modify_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MilitaryEquipment that = (MilitaryEquipment) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "MilitaryEquipment{" +
                "id='" + id + '\'' +
                ", tanks=" + tanks +
                ", numberOfTanks=" + numberOfTanks +
                ", bmp=" + bmp +
                ", numberOfBmp=" + numberOfBmp +
                ", btr=" + btr +
                ", numberOfBtr=" + numberOfBtr +
                ", totalMilitaryEquipment=" + totalMilitaryEquipment +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
    