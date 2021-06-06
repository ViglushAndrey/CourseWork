package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.Generals
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:53
 * @Version: Generals: 1.0
 */
@Document
public class Generals {
    @Id
    private String id;

    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate bDay;
    private String speciality;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfAssignmentOfAnOfficerRank;
    private String awards;
    private GeneralsRanks generalsRanks;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public Generals() {
    }

    public Generals(String id, String name, LocalDate bDay, String speciality, LocalDate dateOfAssignmentOfAnOfficerRank, String awards, GeneralsRanks generalsRanks, LocalDateTime created_at, LocalDateTime modify_at) {
        this.id = id;
        this.name = name;
        this.bDay = bDay;
        this.speciality = speciality;
        this.dateOfAssignmentOfAnOfficerRank = dateOfAssignmentOfAnOfficerRank;
        this.awards = awards;
        this.generalsRanks = generalsRanks;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public Generals(String name, LocalDate bDay, String speciality, LocalDate dateOfAssignmentOfAnOfficerRank, String awards, GeneralsRanks generalsRanks, LocalDateTime created_at, LocalDateTime modify_at) {
        this.name = name;
        this.bDay = bDay;
        this.speciality = speciality;
        this.dateOfAssignmentOfAnOfficerRank = dateOfAssignmentOfAnOfficerRank;
        this.awards = awards;
        this.generalsRanks = generalsRanks;
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

    public LocalDate getbDay() {
        return bDay;
    }

    public void setbDay(LocalDate bDay) {
        this.bDay = bDay;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public LocalDate getDateOfAssignmentOfAnOfficerRank() {
        return dateOfAssignmentOfAnOfficerRank;
    }

    public void setDateOfAssignmentOfAnOfficerRank(LocalDate dateOfAssignmentOfAnOfficerRank) {
        this.dateOfAssignmentOfAnOfficerRank = dateOfAssignmentOfAnOfficerRank;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public GeneralsRanks getGeneralsRanks() {
        return generalsRanks;
    }

    public void setGeneralsRanks(GeneralsRanks generalsRanks) {
        this.generalsRanks = generalsRanks;
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
        Generals generals = (Generals) o;
        return getId().equals(generals.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Generals{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bDay=" + bDay +
                ", speciality='" + speciality + '\'' +
                ", dateOfAssignmentOfAnOfficerRank=" + dateOfAssignmentOfAnOfficerRank +
                ", awards='" + awards + '\'' +
                ", generalsRanks=" + generalsRanks +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
    