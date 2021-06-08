package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.Automats
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:55
 * @Version: Automats: 1.0
 */
@Document
public class Automats {
    @Id
    private String id;
    private String model;
    private String caliber;
    private int numberOfCartridgesInMagazine;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public Automats() {
    }

    public Automats(String id, String model, String caliber, int numberOfCartridgesInMagazine, LocalDateTime created_at, LocalDateTime modify_at) {
        this.id = id;
        this.model = model;
        this.caliber = caliber;
        this.numberOfCartridgesInMagazine = numberOfCartridgesInMagazine;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public Automats(String model, String caliber, int numberOfCartridgesInMagazine, LocalDateTime created_at, LocalDateTime modify_at) {
        this.model = model;
        this.caliber = caliber;
        this.numberOfCartridgesInMagazine = numberOfCartridgesInMagazine;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Automats automats = (Automats) o;
        return id.equals(automats.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Automats{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", caliber='" + caliber + '\'' +
                ", numberOfCartridgesInMagazine=" + numberOfCartridgesInMagazine +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
    