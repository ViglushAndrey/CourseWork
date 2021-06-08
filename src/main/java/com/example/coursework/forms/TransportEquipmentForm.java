package com.example.coursework.forms;

import com.example.coursework.model.FreightCar;
import com.example.coursework.model.Tractor;

import java.time.LocalDateTime;

public class TransportEquipmentForm {

    private String id;

    private String freightCar;
    private String numberOfFreightCar;
    private String tractor;
    private String numberOfTractor;
    private String totalTransportEquipment;

    public TransportEquipmentForm() {
    }

    public TransportEquipmentForm(String id, String freightCar, String numberOfFreightCar, String tractor, String numberOfTractor, String totalTransportEquipment) {
        this.id = id;
        this.freightCar = freightCar;
        this.numberOfFreightCar = numberOfFreightCar;
        this.tractor = tractor;
        this.numberOfTractor = numberOfTractor;
        this.totalTransportEquipment = totalTransportEquipment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFreightCar() {
        return freightCar;
    }

    public void setFreightCar(String freightCar) {
        this.freightCar = freightCar;
    }

    public String getNumberOfFreightCar() {
        return numberOfFreightCar;
    }

    public void setNumberOfFreightCar(String numberOfFreightCar) {
        this.numberOfFreightCar = numberOfFreightCar;
    }

    public String getTractor() {
        return tractor;
    }

    public void setTractor(String tractor) {
        this.tractor = tractor;
    }

    public String getNumberOfTractor() {
        return numberOfTractor;
    }

    public void setNumberOfTractor(String numberOfTractor) {
        this.numberOfTractor = numberOfTractor;
    }

    public String getTotalTransportEquipment() {
        return totalTransportEquipment;
    }

    public void setTotalTransportEquipment(String totalTransportEquipment) {
        this.totalTransportEquipment = totalTransportEquipment;
    }
}
