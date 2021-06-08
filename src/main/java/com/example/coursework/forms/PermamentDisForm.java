package com.example.coursework.forms;

import java.time.LocalDateTime;

public class PermamentDisForm {

    private String id;
    private String permanentDislocation;
    private String city;
    private String address;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public PermamentDisForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermanentDislocation() {
        return permanentDislocation;
    }

    public void setPermanentDislocation(String permanentDislocation) {
        this.permanentDislocation = permanentDislocation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "PermamentDisForm{" +
                "id='" + id + '\'' +
                ", permanentDislocation='" + permanentDislocation + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
