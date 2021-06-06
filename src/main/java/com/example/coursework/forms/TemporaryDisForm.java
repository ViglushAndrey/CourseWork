package com.example.coursework.forms;

import java.time.LocalDateTime;

public class TemporaryDisForm {

    private String id;
    private String temporaryDislocation;
    private String city;
    private String address;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public TemporaryDisForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemporaryDislocation() {
        return temporaryDislocation;
    }

    public void setTemporaryDislocation(String temporaryDislocation) {
        this.temporaryDislocation = temporaryDislocation;
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
        return "TemporaryDisForm{" +
                "id='" + id + '\'' +
                ", temporaryDislocation='" + temporaryDislocation + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
