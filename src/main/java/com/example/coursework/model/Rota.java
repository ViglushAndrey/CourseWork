package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.Rota
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:52
 * @Version: Rota: 1.0
 */
@Document
public class Rota {
    @Id
    private String id;
    private String name;
    private int personnel;
    private Vzvods vzvods;
    private Armament armament;
    private Officers officers;
    private Obj obj;
    private PermanentDislocation permanentDislocation;
    private TemporaryDislocation temporaryDislocation;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public Rota() {
    }

    public Rota(String id, String name, int personnel, Vzvods vzvods, Armament armament, Officers officers, Obj obj, PermanentDislocation permanentDislocation, TemporaryDislocation temporaryDislocation, LocalDateTime created_at, LocalDateTime modify_at) {
        this.id = id;
        this.name = name;
        this.personnel = personnel;
        this.vzvods = vzvods;
        this.armament = armament;
        this.officers = officers;
        this.obj = obj;
        this.permanentDislocation = permanentDislocation;
        this.temporaryDislocation = temporaryDislocation;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public Rota(String name, int personnel, Vzvods vzvods, Armament armament, Officers officers, Obj obj, PermanentDislocation permanentDislocation, TemporaryDislocation temporaryDislocation, LocalDateTime created_at, LocalDateTime modify_at) {
        this.name = name;
        this.personnel = personnel;
        this.vzvods = vzvods;
        this.armament = armament;
        this.officers = officers;
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

    public Vzvods getVzvods() {
        return vzvods;
    }

    public void setVzvods(Vzvods vzvods) {
        this.vzvods = vzvods;
    }

    public Armament getArmament() {
        return armament;
    }

    public void setArmament(Armament armament) {
        this.armament = armament;
    }

    public Officers getOfficers() {
        return officers;
    }

    public void setOfficers(Officers officers) {
        this.officers = officers;
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
        Rota rota = (Rota) o;
        return getId().equals(rota.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Rota{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", personnel=" + personnel +
                ", vzvods=" + vzvods +
                ", armament=" + armament +
                ", officers=" + officers +
                ", obj=" + obj +
                ", permanentDislocation=" + permanentDislocation +
                ", temporaryDislocation=" + temporaryDislocation +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
    