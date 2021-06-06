package com.example.coursework.forms;

import java.time.LocalDateTime;

public class PistolsForm {
    private String id;
    private String model;
    private String caliber;
    private int numberOfCartridgesInMagazine;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public PistolsForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public int getNumberOfCartridgesInMagazine() {
        return numberOfCartridgesInMagazine;
    }

    public void setNumberOfCartridgesInMagazine(int numberOfCartridgesInMagazine) {
        this.numberOfCartridgesInMagazine = numberOfCartridgesInMagazine;
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
        return "PistolsForm{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", caliber='" + caliber + '\'' +
                ", numberOfCartridgesInMagazine=" + numberOfCartridgesInMagazine +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
