package com.example.coursework.forms;

import com.example.coursework.model.SerguantsRanks;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SerguantsForm {
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

    public SerguantsForm() {
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
    public String toString() {
        return "SerguantsForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bDay=" + bDay +
                ", speciality='" + speciality + '\'' +
                ", dateOfAssignmentOfAnOfficerRank=" + dateOfAssignmentOfAnOfficerRank +
                ", awards='" + awards + '\'' +
                ", serguantsRanks=" + serguantsRanks +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
