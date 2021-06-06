package com.example.coursework.forms;

import java.time.LocalDateTime;

public class GrenadesForm {

    private String id;
    private String model;
    private String type;
    private String theRadiusOfTheScatteringOfFragments;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public GrenadesForm() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTheRadiusOfTheScatteringOfFragments() {
        return theRadiusOfTheScatteringOfFragments;
    }

    public void setTheRadiusOfTheScatteringOfFragments(String theRadiusOfTheScatteringOfFragments) {
        this.theRadiusOfTheScatteringOfFragments = theRadiusOfTheScatteringOfFragments;
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
        return "GrenadesForm{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", theRadiusOfTheScatteringOfFragments='" + theRadiusOfTheScatteringOfFragments + '\'' +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
