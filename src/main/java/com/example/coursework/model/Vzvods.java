package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.Vzvods
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:52
 * @Version: Vzvods: 1.0
 */
@Document
public class Vzvods {
    @Id
    private String id;
    private String name;
    private int personnel;
    private Department department;
    private Armament armament;
    private Serguants serguants;
    private Obj obj;
    private PermanentDislocation permanentDislocation;
    private TemporaryDislocation temporaryDislocation;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public Vzvods() {
    }

    public Vzvods(String id, String name, int personnel, Department department, Armament armament, Serguants serguants, Obj obj, PermanentDislocation permanentDislocation, TemporaryDislocation temporaryDislocation, LocalDateTime created_at, LocalDateTime modify_at) {
        this.id = id;
        this.name = name;
        this.personnel = personnel;
        this.department = department;
        this.armament = armament;
        this.serguants = serguants;
        this.obj = obj;
        this.permanentDislocation = permanentDislocation;
        this.temporaryDislocation = temporaryDislocation;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public Vzvods(String name, int personnel,Department department, Armament armament, Serguants serguants, Obj obj, PermanentDislocation permanentDislocation, TemporaryDislocation temporaryDislocation, LocalDateTime created_at, LocalDateTime modify_at) {
        this.name = name;
        this.personnel = personnel;
        this.department = department;
        this.armament = armament;
        this.serguants = serguants;
        this.obj = obj;
        this.permanentDislocation = permanentDislocation;
        this.temporaryDislocation = temporaryDislocation;
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

    public Department getViddilenia() {
        return department;
    }

    public void setViddilenia(Department department) {
        this.department = department;
    }

    public Armament getArmament() {
        return armament;
    }

    public void setArmament(Armament armament) {
        this.armament = armament;
    }

    public Serguants getSerguants() {
        return serguants;
    }

    public void setSerguants(Serguants serguants) {
        this.serguants = serguants;
    }

    public Obj getObj() {
        return obj;
    }

    public void setObj(Obj obj) {
        this.obj = obj;
    }

    public PermanentDislocation getPermanentDislocation() {
        return permanentDislocation;
    }

    public void setPermanentDislocation(PermanentDislocation permanentDislocation) {
        this.permanentDislocation = permanentDislocation;
    }

    public TemporaryDislocation getTemporaryDislocation() {
        return temporaryDislocation;
    }

    public void setTemporaryDislocation(TemporaryDislocation temporaryDislocation) {
        this.temporaryDislocation = temporaryDislocation;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
        Vzvods vzvods = (Vzvods) o;
        return getId().equals(vzvods.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Vzvods{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", personnel=" + personnel +
                ", department=" + department +
                ", armament=" + armament +
                ", serguants=" + serguants +
                ", obj=" + obj +
                ", permanentDislocation=" + permanentDislocation +
                ", temporaryDislocation=" + temporaryDislocation +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
    