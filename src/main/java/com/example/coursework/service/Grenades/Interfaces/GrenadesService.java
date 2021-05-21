package com.example.coursework.service.Grenades.Interfaces;

import com.example.coursework.model.Generals;
import com.example.coursework.model.Grenades;

import java.util.List;

public interface GrenadesService {
    Grenades getById(String id);
    Grenades create(Grenades grenades);
    Grenades update(Grenades grenades);
    Grenades delete(String id);
    List<Grenades> getAll();
}
