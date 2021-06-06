package com.example.coursework.forms;


import java.time.LocalDateTime;

public class BTRForm {
    private String id;
    private String name;
    private int personnel;
    private String type;
    private String armament;
    private String combatWeight;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;


    public BTRForm() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArmament() {
        return armament;
    }

    public void setArmament(String armament) {
        this.armament = armament;
    }

    public String getCombatWeight() {
        return combatWeight;
    }

    public void setCombatWeight(String combatWeight) {
        this.combatWeight = combatWeight;
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
        return "BTRForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", osoboviySklad=" + personnel +
                ", type='" + type + '\'' +
                ", armament='" + armament + '\'' +
                ", combatWeight='" + combatWeight + '\'' +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
