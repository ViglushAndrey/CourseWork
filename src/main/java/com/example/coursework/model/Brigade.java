package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.Brigade
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:55
 * @Version: Brigade: 1.0
 */
@Document
public class Brigade {
    @Id
    private String id;
    private String name;
    private String osoboviySklad;
    private Rota rota;
    private Armament armament;
    private Officers officers;
    private Obj obj;
    private PermanentDislocation permanentDislocation;
    private TemporaryDislocation temporaryDislocation;

    public Brigade() {
    }

    public Brigade(String id, String name, String osoboviySklad) {
        this.id = id;
        this.name = name;
        this.osoboviySklad = osoboviySklad;
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

    public String getOsoboviySklad() {
        return osoboviySklad;
    }

    public void setOsoboviySklad(String osoboviySklad) {
        this.osoboviySklad = osoboviySklad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brigade brigade = (Brigade) o;
        return id.equals(brigade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Brigade{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", osoboviySklad='" + osoboviySklad + '\'' +
                '}';
    }
}
    