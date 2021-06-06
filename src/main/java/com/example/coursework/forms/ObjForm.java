package com.example.coursework.forms;

import java.time.LocalDateTime;
import java.util.List;

public class ObjForm {

    private String id;
    private String typesOfBuildings;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public ObjForm() {
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
    public String toString() {
        return "ObjForm{" +
                "id='" + id + '\'' +
                ", typesOfBuildings=" + typesOfBuildings +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }

}
