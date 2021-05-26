package com.example.coursework.MSSQL.ms_sql;

import javax.persistence.*;


@Entity
@Table(name = "Viddilenia")
public class ViddileniaSQL {
    @Id
    private Long id;

    private String name;
    private Long people_Sklad;

    public ViddileniaSQL() {
    }

    public ViddileniaSQL(Long id, String name, Long people_Sklad) {
        this.id = id;
        this.name = name;
        this.people_Sklad = people_Sklad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPeople_Sklad() {
        return people_Sklad;
    }

    public void setPeople_Sklad(Long people_Sklad) {
        this.people_Sklad = people_Sklad;
    }

    @Override
    public String toString() {
        return "ViddileniaSQL{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", people_Sklad=" + people_Sklad +
                '}';
    }
}
