package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.Permanent_dislocation
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|17:00
 * @Version: Permanent_dislocation: 1.0
 */
@Document
public class PermanentDislocation {
    @Id
    private String id;
    private String permanentDislocation;
    private String city;
    private String address;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public PermanentDislocation() {
    }

    public PermanentDislocation(String id, String permanentDislocation, String city, String address, LocalDateTime created_at, LocalDateTime modify_at) {
        this.id = id;
        this.permanentDislocation = permanentDislocation;
        this.city = city;
        this.address = address;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public PermanentDislocation(String permanentDislocation, String city, String address, LocalDateTime created_at, LocalDateTime modify_at) {
        this.permanentDislocation = permanentDislocation;
        this.city = city;
        this.address = address;
        this.created_at = created_at;
        this.modify_at = modify_at;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermanentDislocation that = (PermanentDislocation) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PermanentDislocation{" +
                "id='" + id + '\'' +
                ", permanentDislocation='" + permanentDislocation + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
    