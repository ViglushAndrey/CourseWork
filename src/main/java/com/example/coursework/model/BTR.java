package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.BTR
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:56
 * @Version: BTR: 1.0
 */
@Document
public class BTR {
    @Id
    private String id;
    private String name;
    private int personnel;
    private String type;
    private String armament;
    private String combatWeight;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public BTR() {
    }

    public BTR(String id, String name, int personnel, String type, String armament, String combatWeight, LocalDateTime created_at, LocalDateTime modify_at) {
        this.id = id;
        this.name = name;
        this.personnel = personnel;
        this.type = type;
        this.armament = armament;
        this.combatWeight = combatWeight;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public BTR(String name, int personnel, String type, String armament, String combatWeight, LocalDateTime created_at, LocalDateTime modify_at) {
        this.name = name;
        this.personnel = personnel;
        this.type = type;
        this.armament = armament;
        this.combatWeight = combatWeight;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BTR btr = (BTR) o;
        return getId().equals(btr.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "BTR{" +
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
    