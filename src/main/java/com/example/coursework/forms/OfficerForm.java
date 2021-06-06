package com.example.coursework.forms;

import com.example.coursework.model.OfficersRanks;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * course.Officars
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:53
 * @Version: Officars: 1.0
 */
public class OfficerForm {

    private String id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate bDay;
    private String speciality;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfAssignmentOfAnOfficerRank;
    private String awards;
    private OfficersRanks officersRanks;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public OfficerForm() {
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

    public OfficersRanks getOfficersRanks() {
        return officersRanks;
    }

    public void setOfficersRanks(OfficersRanks officersRanks) {
        this.officersRanks = officersRanks;
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
        return "OfficerForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bDay=" + bDay +
                ", speciality='" + speciality + '\'' +
                ", dateOfAssignmentOfAnOfficerRank=" + dateOfAssignmentOfAnOfficerRank +
                ", awards='" + awards + '\'' +
                ", officersRanks=" + officersRanks +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
    