package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.Viddilenia
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:52
 * @Version: Viddilenia: 1.0
 */
@Document
public class Department {
    @Id
    private String id;
    private String name;
    private int personnel;
    //private Serguants serguants;
    private Ordinarys ordinarys;
    private Obj obj;
    private PermanentDislocation permanentDislocation;
    private TemporaryDislocation temporaryDislocation;
    private TransportEquipment transportEquipment;
    private MilitaryEquipment militaryEquipment;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public Department() {
    }

    public Department(String id, String name, int personnel, Ordinarys ordinarys, Obj obj, PermanentDislocation permanentDislocation, TemporaryDislocation temporaryDislocation, TransportEquipment transportEquipment, MilitaryEquipment militaryEquipment, LocalDateTime created_at, LocalDateTime modify_at) {
        this.id = id;
        this.name = name;
        this.personnel = personnel;
        this.ordinarys = ordinarys;
        this.obj = obj;
        this.permanentDislocation = permanentDislocation;
        this.temporaryDislocation = temporaryDislocation;
        this.transportEquipment = transportEquipment;
        this.militaryEquipment = militaryEquipment;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public Department(String name, int personnel, Ordinarys ordinarys, Obj obj, PermanentDislocation permanentDislocation, TemporaryDislocation temporaryDislocation, TransportEquipment transportEquipment, MilitaryEquipment militaryEquipment, LocalDateTime created_at, LocalDateTime modify_at) {
        this.name = name;
        this.personnel = personnel;
        this.ordinarys = ordinarys;
        this.obj = obj;
        this.permanentDislocation = permanentDislocation;
        this.temporaryDislocation = temporaryDislocation;
        this.transportEquipment = transportEquipment;
        this.militaryEquipment = militaryEquipment;
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

    public Ordinarys getOrdinarys() {
        return ordinarys;
    }

    public void setOrdinarys(Ordinarys ordinarys) {
        this.ordinarys = ordinarys;
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

    public TransportEquipment getTransportEquipment() {
        return transportEquipment;
    }

    public void setTransportEquipment(TransportEquipment transportEquipment) {
        this.transportEquipment = transportEquipment;
    }

    public MilitaryEquipment getMilitaryEquipment() {
        return militaryEquipment;
    }

    public void setMilitaryEquipment(MilitaryEquipment militaryEquipment) {
        this.militaryEquipment = militaryEquipment;
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
        Department that = (Department) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Viddilenia{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", personnel=" + personnel +
                ", ordinarys=" + ordinarys +
                ", obj=" + obj +
                ", permanentDislocation=" + permanentDislocation +
                ", temporaryDislocation=" + temporaryDislocation +
                ", transportEquipment=" + transportEquipment +
                ", militaryEquipment=" + militaryEquipment +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
    