package com.example.coursework.forms;

import com.example.coursework.model.*;

public class ArmyForm {

    private String id;
    private String name;
    private String personnel;
    private String battalion;
    private String armament;
    private String generals;
    private String permanentDislocation;
    private String temporaryDislocation;
    private String obj;

    public ArmyForm() {
    }

    public ArmyForm(String id, String name, String personnel, String battalion, String armament, String generals, String permanentDislocation, String temporaryDislocation, String obj) {
        this.id = id;
        this.name = name;
        this.personnel = personnel;
        this.battalion = battalion;
        this.armament = armament;
        this.generals = generals;
        this.permanentDislocation = permanentDislocation;
        this.temporaryDislocation = temporaryDislocation;
        this.obj = obj;
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

    public String getBattalion() {
        return battalion;
    }

    public void setBattalion(String battalion) {
        this.battalion = battalion;
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

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }
}
