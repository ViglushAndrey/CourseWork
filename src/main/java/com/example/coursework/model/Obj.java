package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.Objects
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:57
 * @Version: Objects: 1.0
 */
@Document
public class Obj {
    @Id
    private String id;
    private String typesOfBuildings;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public Obj() {
    }

    public Obj(String id, String typesOfBuildings, LocalDateTime created_at, LocalDateTime modify_at) {
        this.id = id;
        this.typesOfBuildings = typesOfBuildings;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public Obj(String typesOfBuildings, LocalDateTime created_at, LocalDateTime modify_at) {
        this.typesOfBuildings = typesOfBuildings;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypesOfBuildings() {
        return typesOfBuildings;
    }

    public void setTypesOfBuildings(String typesOfBuildings) {
        this.typesOfBuildings = typesOfBuildings;
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
        Obj obj = (Obj) o;
        return getId().equals(obj.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Obj{" +
                "id='" + id + '\'' +
                ", typesOfBuildings=" + typesOfBuildings +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
    