package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.Serguants
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:53
 * @Version: Serguants: 1.0
 */
@Document
public class Serguants {
    @Id
    private String id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate bDay;
    private String speciality;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfAssignmentOfAnOfficerRank;
    private String awards;
    private SerguantsRanks serguantsRanks;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public Serguants() {
    }

    public Serguants(String id, String name, LocalDate bDay, String speciality, LocalDate dateOfAssignmentOfAnOfficerRank, String awards, SerguantsRanks serguantsRanks, LocalDateTime created_at, LocalDateTime modify_at) {
        this.id = id;
        this.name = name;
        this.bDay = bDay;
        this.speciality = speciality;
        this.dateOfAssignmentOfAnOfficerRank = dateOfAssignmentOfAnOfficerRank;
        this.awards = awards;
        this.serguantsRanks = serguantsRanks;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public Serguants(String name, LocalDate bDay, String speciality, LocalDate dateOfAssignmentOfAnOfficerRank, String awards, SerguantsRanks serguantsRanks, LocalDateTime created_at, LocalDateTime modify_at) {
        this.name = name;
        this.bDay = bDay;
        this.speciality = speciality;
        this.dateOfAssignmentOfAnOfficerRank = dateOfAssignmentOfAnOfficerRank;
        this.awards = awards;
        this.serguantsRanks = serguantsRanks;
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

    public SerguantsRanks getSerguantsRanks() {
        return serguantsRanks;
    }

    public void setSerguantsRanks(SerguantsRanks serguantsRanks) {
        this.serguantsRanks = serguantsRanks;
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
        Serguants serguants = (Serguants) o;
        return getId().equals(serguants.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Serguants{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bDay=" + bDay +
                ", speciality='" + speciality + '\'' +
                ", dateOfAssignmentOfAnOfficerRank=" + dateOfAssignmentOfAnOfficerRank +
                ", awards='" + awards + '\'' +
                ", serguantsRanks=" + serguantsRanks +
                '}';
    }
}
    