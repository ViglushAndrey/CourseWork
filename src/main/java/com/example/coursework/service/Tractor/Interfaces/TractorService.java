package com.example.coursework.service.Tractor.Interfaces;

import com.example.coursework.model.TemporaryDislocation;
import com.example.coursework.model.Tractor;

import java.util.List;

public interface TractorService {
    Tractor getById(String id);
    Tractor create(Tractor tractor);
    Tractor update(Tractor tractor);
    Tractor delete(String id);
    List<Tractor> getAll();
}
