package com.example.coursework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * course.TransportEquipment
 *
 * @Autor: Andrey
 * @DateTime: 03.03.2021|17:01
 * @Version: TransportEquipment: 1.0
 */
@Document
public class TransportEquipment {
    @Id
    private String id;

    private FreightCar freightCar;
    private int numberOfFreightCar;
    private Tractor tractor;
    private int numberOfTractor;
    private String totalTransportEquipment;
    private LocalDateTime created_at;
    private LocalDateTime modify_at;

    public TransportEquipment() {
    }

    public TransportEquipment(String id, FreightCar freightCar, int numberOfFreightCar, Tractor tractor, int numberOfTractor, String totalTransportEquipment, LocalDateTime created_at, LocalDateTime modify_at) {
        this.id = id;
        this.freightCar = freightCar;
        this.numberOfFreightCar = numberOfFreightCar;
        this.tractor = tractor;
        this.numberOfTractor = numberOfTractor;
        this.totalTransportEquipment = totalTransportEquipment;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public TransportEquipment(FreightCar freightCar, int numberOfFreightCar, Tractor tractor, int numberOfTractor, String totalTransportEquipment, LocalDateTime created_at, LocalDateTime modify_at) {
        this.freightCar = freightCar;
        this.numberOfFreightCar = numberOfFreightCar;
        this.tractor = tractor;
        this.numberOfTractor = numberOfTractor;
        this.totalTransportEquipment = totalTransportEquipment;
        this.created_at = created_at;
        this.modify_at = modify_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FreightCar getFreightCar() {
        return freightCar;
    }

    public void setFreightCar(FreightCar freightCar) {
        this.freightCar = freightCar;
    }

    public int getNumberOfFreightCar() {
        return numberOfFreightCar;
    }

    public void setNumberOfFreightCar(int numberOfFreightCar) {
        this.numberOfFreightCar = numberOfFreightCar;
    }

    public Tractor getTractor() {
        return tractor;
    }

    public void setTractor(Tractor tractor) {
        this.tractor = tractor;
    }

    public int getNumberOfTractor() {
        return numberOfTractor;
    }

    public void setNumberOfTractor(int numberOfTractor) {
        this.numberOfTractor = numberOfTractor;
    }

    public String getTotalTransportEquipment() {
        return totalTransportEquipment;
    }

    public void setTotalTransportEquipment(String totalTransportEquipment) {
        this.totalTransportEquipment = totalTransportEquipment;
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
        TransportEquipment that = (TransportEquipment) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TransportEquipment{" +
                "id='" + id + '\'' +
                ", freightCar=" + freightCar +
                ", numberOfFreightCar=" + numberOfFreightCar +
                ", tractor=" + tractor +
                ", numberOfTractor=" + numberOfTractor +
                ", totalTransportEquipment=" + totalTransportEquipment +
                ", created_at=" + created_at +
                ", modify_at=" + modify_at +
                '}';
    }
}
    