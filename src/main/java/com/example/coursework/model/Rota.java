package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.Rota
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:52
 * @Version: Rota: 1.0
 */
@Document
public class Rota {
    @Id
    private String id;
    private String name;
    private int osoboviySklad;
    private List<Vzvods> vzvods;
    private Armament armament;
    private Officers officers;
    private Obj obj;
    private PermanentDislocation permanentDislocation;
    private TemporaryDislocation temporaryDislocation;

    public Rota() {
    }

    public Rota(String name, int osoboviySklad, List<Vzvods> vzvods, Armament armament, Officers officers, Obj obj, PermanentDislocation permanentDislocation, TemporaryDislocation temporaryDislocation) {
        this.name = name;
        this.osoboviySklad = osoboviySklad;
        this.vzvods = vzvods;
        this.armament = armament;
        this.officers = officers;
        this.obj = obj;
        this.permanentDislocation = permanentDislocation;
        this.temporaryDislocation = temporaryDislocation;
    }

    public Rota(String id, String name, int osoboviySklad, List<Vzvods> vzvods, Armament armament, Officers officers, Obj obj, PermanentDislocation permanentDislocation, TemporaryDislocation temporaryDislocation) {
        this.id = id;
        this.name = name;
        this.osoboviySklad = osoboviySklad;
        this.vzvods = vzvods;
        this.armament = armament;
        this.officers = officers;
        this.obj = obj;
        this.permanentDislocation = permanentDislocation;
        this.temporaryDislocation = temporaryDislocation;
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

    public int getOsoboviySklad() {
        return osoboviySklad;
    }

    public void setOsoboviySklad(int osoboviySklad) {
        this.osoboviySklad = osoboviySklad;
    }

    public List<Vzvods> getVzvods() {
        return vzvods;
    }

    public void setVzvods(List<Vzvods> vzvods) {
        this.vzvods = vzvods;
    }

    public Armament getArmament() {
        return armament;
    }

    public void setArmament(Armament armament) {
        this.armament = armament;
    }

    public Officers getOfficers() {
        return officers;
    }

    public void setOfficers(Officers officers) {
        this.officers = officers;
    }

    public Obj getObj() {
        return obj;
    }

    public void setObj(Obj obj) {
        this.obj = obj;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rota rota = (Rota) o;
        return getId().equals(rota.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Rota{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", osoboviySklad=" + osoboviySklad +
                ", vzvods=" + vzvods +
                ", armament=" + armament +
                ", officers=" + officers +
                ", obj=" + obj +
                ", permanentDislocation=" + permanentDislocation +
                ", temporaryDislocation=" + temporaryDislocation +
                '}';
    }
}
    