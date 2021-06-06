package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.Grenades
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:58
 * @Version: Grenades: 1.0
 */
@Document
public class Grenades {
    @Id
    private String id;

    private String model;
    private String type;
    private String theRadiusOfTheScatteringOfFragments;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public Grenades() {
    }

    public Grenades(String id, String model, String type, String theRadiusOfTheScatteringOfFragments, LocalDateTime created_at, LocalDateTime modify_at) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.theRadiusOfTheScatteringOfFragments = theRadiusOfTheScatteringOfFragments;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public Grenades(String model, String type, String theRadiusOfTheScatteringOfFragments, LocalDateTime created_at, LocalDateTime modify_at) {
        this.model = model;
        this.type = type;
        this.theRadiusOfTheScatteringOfFragments = theRadiusOfTheScatteringOfFragments;
        this.created_at = created_at;
        this.modify_at = modify_at;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grenades grenades = (Grenades) o;
        return getId().equals(grenades.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Grenades{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", theRadiusOfTheScatteringOfFragments='" + theRadiusOfTheScatteringOfFragments + '\'' +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
    