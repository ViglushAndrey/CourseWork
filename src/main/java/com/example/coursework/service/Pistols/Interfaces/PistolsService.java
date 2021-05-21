package com.example.coursework.service.Pistols.Interfaces;

import com.example.coursework.model.PermanentDislocation;
import com.example.coursework.model.Pistols;

import java.util.List;

public interface PistolsService {
    Pistols getById(String id);
    Pistols create(Pistols pistols);
    Pistols update(Pistols pistols);
    Pistols delete(String id);
    List<Pistols> getAll();
}
