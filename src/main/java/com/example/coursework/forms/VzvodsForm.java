package com.example.coursework.forms;

import com.example.coursework.model.*;

import java.time.LocalDateTime;
import java.util.List;

public class VzvodsForm {

    private String id;
    private String name;
    private String personnel;
    private String department;
    private String armament;
    private String serguants;
    private String obj;
    private String permanentDislocation;
    private String temporaryDislocation;

    public VzvodsForm() {
    }

    public VzvodsForm(String id, String name, String personnel, String department, String armament, String serguants, String obj, String permanentDislocation, String temporaryDislocation) {
        this.id = id;
        this.name = name;
        this.personnel = personnel;
        this.department = department;
        this.armament = armament;
        this.serguants = serguants;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getArmament() {
        return armament;
    }

    public void setArmament(String armament) {
        this.armament = armament;
    }

    public String getSerguants() {
        return serguants;
    }

    public void setSerguants(String serguants) {
        this.serguants = serguants;
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
