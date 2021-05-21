package com.example.coursework.service.FreightCar.Interfaces;

import com.example.coursework.model.BTR;
import com.example.coursework.model.FreightCar;

import java.util.List;

public interface FreightCarService {
    FreightCar getById(String id);
    FreightCar create(FreightCar freightCar);
    FreightCar update(FreightCar freightCar);
    FreightCar delete(String id);
    List<FreightCar> getAll();
}
