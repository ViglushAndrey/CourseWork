package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.BMP
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:55
 * @Version: BMP: 1.0
 */
@Document
public class BMP {
    @Id
    private String id;
    private String name;
    private int personnel;
    private String armament;
    private String combatWeight;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public BMP() {
    }

    public BMP(String id, String name, int personnel, String armament, String combatWeight, LocalDateTime created_at, LocalDateTime modify_at) {
        this.id = id;
        this.name = name;
        this.personnel = personnel;
        this.armament = armament;
        this.combatWeight = combatWeight;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public BMP(String name, int personnel, String armament, String combatWeight, LocalDateTime created_at, LocalDateTime modify_at) {
        this.name = name;
        this.personnel = personnel;
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
        BMP bmp = (BMP) o;
        return id.equals(bmp.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BMP{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", osoboviySklad=" + personnel +
                ", armament='" + armament + '\'' +
                ", combatWeight='" + combatWeight + '\'' +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
    