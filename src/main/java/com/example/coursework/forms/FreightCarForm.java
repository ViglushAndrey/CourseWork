package com.example.coursework.forms;

import java.time.LocalDateTime;

public class FreightCarForm {

    private String id;
    private String name;
    private double weight;
    private int maximumSpeed;
    private String liftingCapacity;
    private String bodyType;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public FreightCarForm() {
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

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getLiftingCapacity() {
        return liftingCapacity;
    }

    public void setLiftingCapacity(String liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(int maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
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
        return "FreightCarForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", maximumSpeed=" + maximumSpeed +
                ", liftingCapacity='" + liftingCapacity + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
