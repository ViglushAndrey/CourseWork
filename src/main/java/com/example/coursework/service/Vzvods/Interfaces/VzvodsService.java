package com.example.coursework.service.Vzvods.Interfaces;

import com.example.coursework.model.Vzvods;

import java.util.List;

public interface VzvodsService {
    Vzvods getById(String id);
    Vzvods create(Vzvods vzvods);
    Vzvods update(Vzvods vzvods);
    Vzvods delete(String id);
    List<Vzvods> getAll();
}
