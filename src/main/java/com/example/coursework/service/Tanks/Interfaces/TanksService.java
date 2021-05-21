package com.example.coursework.service.Tanks.Interfaces;

import com.example.coursework.model.SniperRifles;
import com.example.coursework.model.Tanks;

import java.util.List;

public interface TanksService {
    Tanks getById(String id);
    Tanks create(Tanks tanks);
    Tanks update(Tanks tanks);
    Tanks delete(String id);
    List<Tanks> getAll();
}
