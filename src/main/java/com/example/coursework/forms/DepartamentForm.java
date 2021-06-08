package com.example.coursework.forms;

public class DepartamentForm {

    private String id;
    private String name;
    private String personnel;
    //private Serguants serguants;
    private String ordinarys;
    private String obj;
    private String permanentDislocation;
    private String temporaryDislocation;
    private String transportEquipment;
    private String militaryEquipment;

    public DepartamentForm() {
    }

    public DepartamentForm(String id, String name, String personnel, String ordinarys, String obj, String permanentDislocation, String temporaryDislocation, String transportEquipment, String militaryEquipment) {
        this.id = id;
        this.name = name;
        this.personnel = personnel;
        this.ordinarys = ordinarys;
        this.obj = obj;
        this.permanentDislocation = permanentDislocation;
        this.temporaryDislocation = temporaryDislocation;
        this.transportEquipment = transportEquipment;
        this.militaryEquipment = militaryEquipment;
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

    public String getPersonnel() {
        return personnel;
    }

    public void setPersonnel(String personnel) {
        this.personnel = personnel;
    }

    public String getOrdinarys() {
        return ordinarys;
    }

    public void setOrdinarys(String ordinarys) {
        this.ordinarys = ordinarys;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public String getPermanentDislocation() {
        return permanentDislocation;
    }

    public void setPermanentDislocation(String permanentDislocation) {
        this.permanentDislocation = permanentDislocation;
    }

    public String getTemporaryDislocation() {
        return temporaryDislocation;
    }

    public void setTemporaryDislocation(String temporaryDislocation) {
        this.temporaryDislocation = temporaryDislocation;
    }

    public String getTransportEquipment() {
        return transportEquipment;
    }

    public void setTransportEquipment(String transportEquipment) {
        this.transportEquipment = transportEquipment;
    }

    public String getMilitaryEquipment() {
        return militaryEquipment;
    }

    public void setMilitaryEquipment(String militaryEquipment) {
        this.militaryEquipment = militaryEquipment;
    }
}
