package com.example.coursework.forms;

import com.example.coursework.model.*;

public class BattalionForm {

    private String id;
    private String name;
    private String personnel;
    private String brigade;
    private String armament;
    private String generals;
    private String officers;
    private String obj;
    private String permanentDislocation;
    private String temporaryDislocation;

    public BattalionForm() {
    }

    public BattalionForm(String id, String name, String personnel, String brigade, String armament, String generals, String officers, String obj, String permanentDislocation, String temporaryDislocation) {
        this.id = id;
        this.name = name;
        this.personnel = personnel;
        this.brigade = brigade;
        this.armament = armament;
        this.generals = generals;
        this.officers = officers;
        this.obj = obj;
        this.permanentDislocation = permanentDislocation;
        this.temporaryDislocation = temporaryDislocation;
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

    public String getBrigade() {
        return brigade;
    }

    public void setBrigade(String brigade) {
        this.brigade = brigade;
    }

    public String getArmament() {
        return armament;
    }

    public void setArmament(String armament) {
        this.armament = armament;
    }

    public String getGenerals() {
        return generals;
    }

    public void setGenerals(String generals) {
        this.generals = generals;
    }

    public String getOfficers() {
        return officers;
    }

    public void setOfficers(String officers) {
        this.officers = officers;
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
}
