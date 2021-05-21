package com.example.coursework.service.Army.Interfaces;

import com.example.coursework.model.Armament;
import com.example.coursework.model.Army;

import java.util.List;

public interface ArmyService {
    Army getById(String id);
    Army create(Army army);
    Army update(Army army);
    Army delete(String id);
    List<Army> getAll();
}
