package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.Army
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:52
 * @Version: Army: 1.0
 */
@Document
public class Army {
    @Id
    private String id;
    private String name;
    private int personnel;
    private Battalion battalion;
    private Armament armament;
    private Generals generals;
    private PermanentDislocation permanentDislocation;
    private TemporaryDislocation temporaryDislocation;
    private Obj obj;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public Army() {
    }

    public Army(String id, String name, int personnel, Battalion battalion, Armament armament, Generals generals, PermanentDislocation permanentDislocation, TemporaryDislocation temporaryDislocation, Obj obj, LocalDateTime created_at, LocalDateTime modify_at) {
        this.id = id;
        this.name = name;
        this.personnel = personnel;
        this.battalion = battalion;
        this.armament = armament;
        this.generals = generals;
        this.permanentDislocation = permanentDislocation;
        this.temporaryDislocation = temporaryDislocation;
        this.obj = obj;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public Army(String name, int personnel, Battalion battalion, Armament armament, Generals generals, PermanentDislocation permanentDislocation, TemporaryDislocation temporaryDislocation, Obj obj, LocalDateTime created_at, LocalDateTime modify_at) {
        this.name = name;
        this.personnel = personnel;
        this.battalion = battalion;
        this.armament = armament;
        this.generals = generals;
        this.permanentDislocation = permanentDislocation;
        this.temporaryDislocation = temporaryDislocation;
        this.obj = obj;
        this.created_at = created_at;
        this.modify_at = modify_at;
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

    public int getPersonnel() {
        return personnel;
    }

    public void setPersonnel(int personnel) {
        this.personnel = personnel;
    }

    public Battalion getBattalion() {
        return battalion;
    }

    public void setBattalion(Battalion battalion) {
        this.battalion = battalion;
    }

    public Armament getArmament() {
        return armament;
    }

    public void setArmament(Armament armament) {
        this.armament = armament;
    }

    public Generals getGenerals() {
        return generals;
    }

    public void setGenerals(Generals generals) {
        this.generals = generals;
    }

    public PermanentDislocation getPermanentDislocation() {
        return permanentDislocation;
    }

    public void setPermanentDislocation(PermanentDislocation permanentDislocation) {
        this.permanentDislocation = permanentDislocation;
    }

    public TemporaryDislocation getTemporaryDislocation() {
        return temporaryDislocation;
    }

    public void setTemporaryDislocation(TemporaryDislocation temporaryDislocation) {
        this.temporaryDislocation = temporaryDislocation;
    }

    public Obj getObj() {
        return obj;
    }

    public void setObj(Obj obj) {
        this.obj = obj;
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
        Army army = (Army) o;
        return id.equals(army.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Army{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", personnel='" + personnel + '\'' +
                ", battalion=" + battalion +
                ", armament=" + armament +
                ", generals=" + generals +
                ", permanentDislocation=" + permanentDislocation +
                ", temporaryDislocation=" + temporaryDislocation +
                ", obj=" + obj +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
    