package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.Tanks
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|17:02
 * @Version: Tanks: 1.0
 */
@Document
public class Tanks {
    @Id
    private String id;
    private String name;
    private int personnel;
    private double combatWeight;
    private String enginePower;
    private String engineType;
    private String gunModel;
    private int caliberOfGun;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public Tanks() {
    }

    public Tanks(String id, String name, int personnel, double combatWeight, String enginePower, String engineType, int caliberOfGun, String gunModel, LocalDateTime created_at, LocalDateTime modify_at) {
        this.id = id;
        this.name = name;
        this.personnel = personnel;
        this.combatWeight = combatWeight;
        this.enginePower = enginePower;
        this.engineType = engineType;
        this.caliberOfGun = caliberOfGun;
        this.gunModel = gunModel;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public Tanks(String name, int personnel, double combatWeight, String enginePower, String engineType, int caliberOfGun, String gunModel, LocalDateTime created_at, LocalDateTime modify_at) {
        this.name = name;
        this.personnel = personnel;
        this.combatWeight = combatWeight;
        this.enginePower = enginePower;
        this.engineType = engineType;
        this.caliberOfGun = caliberOfGun;
        this.gunModel = gunModel;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonnel() {
        return personnel;
    }

    public void setPersonnel(int personnel) {
        this.personnel = personnel;
    }

    public double getCombatWeight() {
        return combatWeight;
    }

    public void setCombatWeight(double combatWeight) {
        this.combatWeight = combatWeight;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getCaliberOfGun() {
        return caliberOfGun;
    }

    public void setCaliberOfGun(int caliberOfGun) {
        this.caliberOfGun = caliberOfGun;
    }

    public String getGunModel() {
        return gunModel;
    }

    public void setGunModel(String gunModel) {
        this.gunModel = gunModel;
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
        Tanks tanks = (Tanks) o;
        return id.equals(tanks.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Tanks{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", combatWeight=" + combatWeight +
                ", enginePower='" + enginePower + '\'' +
                ", engineType='" + engineType + '\'' +
                ", caliberOfGun=" + caliberOfGun +
                ", gunModel='" + gunModel + '\'' +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
    