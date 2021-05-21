package com.example.coursework.service.Generals.Interfaces;

import com.example.coursework.model.FreightCar;
import com.example.coursework.model.Generals;

import java.util.List;

public interface GeneralsService {
    Generals getById(String id);
    Generals create(Generals generals);
    Generals update(Generals generals);
    Generals delete(String id);
    List<Generals> getAll();
}
