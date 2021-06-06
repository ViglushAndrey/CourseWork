package com.example.coursework.forms;


import java.time.LocalDateTime;

public class TanksForm {

    private String id;
    private String name;
    private int personnel;
    private double combatWeight;
    private String enginePower;
    private String engineType;
    private int caliberOfGun;
    private String gunModel;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public TanksForm() {
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
    public String toString() {
        return "TanksForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", personnel=" + personnel +
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
