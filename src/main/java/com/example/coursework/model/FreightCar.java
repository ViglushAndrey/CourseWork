package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.FreightCar
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|16:56
 * @Version: FreightCar: 1.0
 */
@Document
public class FreightCar {

    @Id
    private String id;

    private String name;
    private double weight;
    private int maximumSpeed;
    private String liftingCapacity;
    private String bodyType;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;


    public FreightCar() {
    }

    public FreightCar(String id, String name, double weight, int maximumSpeed, String liftingCapacity, String bodyType, LocalDateTime created_at, LocalDateTime modify_at) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.maximumSpeed = maximumSpeed;
        this.liftingCapacity = liftingCapacity;
        this.bodyType = bodyType;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public FreightCar(String name, double weight, int maximumSpeed, String liftingCapacity, String bodyType, LocalDateTime created_at, LocalDateTime modify_at) {
        this.name = name;
        this.weight = weight;
        this.maximumSpeed = maximumSpeed;
        this.liftingCapacity = liftingCapacity;
        this.bodyType = bodyType;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FreightCar that = (FreightCar) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "FreightCar{" +
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
    