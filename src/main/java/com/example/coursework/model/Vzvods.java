package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.Vzvods
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:52
 * @Version: Vzvods: 1.0
 */
@Document
public class Vzvods {
    @Id
    private String id;
    private String name;
    private int osoboviySklad;
    private List<Viddilenia> viddilenia;
    private Armament armament;
    private Serguants serguants;
    private Obj obj;
    private PermanentDislocation permanentDislocation;
    private TemporaryDislocation temporaryDislocation;

    public Vzvods() {
    }

    public Vzvods(String name, int osoboviySklad, List<Viddilenia> viddilenia, Armament armament, Serguants serguants, Obj obj, PermanentDislocation permanentDislocation, TemporaryDislocation temporaryDislocation) {
        this.name = name;
        this.osoboviySklad = osoboviySklad;
        this.viddilenia = viddilenia;
        this.armament = armament;
        this.serguants = serguants;
        this.obj = obj;
        this.permanentDislocation = permanentDislocation;
        this.temporaryDislocation = temporaryDislocation;
    }

    public Vzvods(String id, String name, int osoboviySklad, List<Viddilenia> viddilenia, Armament armament, Serguants serguants, Obj obj, PermanentDislocation permanentDislocation, TemporaryDislocation temporaryDislocation) {
        this.id = id;
        this.name = name;
        this.osoboviySklad = osoboviySklad;
        this.viddilenia = viddilenia;
        this.armament = armament;
        this.serguants = serguants;
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

    public List<Viddilenia> getViddilenia() {
        return viddilenia;
    }

    public void setViddilenia(List<Viddilenia> viddilenia) {
        this.viddilenia = viddilenia;
    }

    public Armament getArmament() {
        return armament;
    }

    public void setArmament(Armament armament) {
        this.armament = armament;
    }

    public Serguants getSerguants() {
        return serguants;
    }

    public void setSerguants(Serguants serguants) {
        this.serguants = serguants;
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
        Vzvods vzvods = (Vzvods) o;
        return getId().equals(vzvods.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Vzvods{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", osoboviySklad='" + osoboviySklad + '\'' +
                ", viddilenia=" + viddilenia +
                ", armament=" + armament +
                ", serguants=" + serguants +
                ", obj=" + obj +
                ", permanentDislocation=" + permanentDislocation +
                ", temporaryDislocation=" + temporaryDislocation +
                '}';
    }
}
    