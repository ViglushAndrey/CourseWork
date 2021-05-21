package com.example.coursework.service.Rota.Interfaces;

import com.example.coursework.model.Pistols;
import com.example.coursework.model.Rota;

import java.util.List;

public interface RotaService {
    Rota getById(String id);
    Rota create(Rota rota);
    Rota update(Rota rota);
    Rota delete(String id);
    List<Rota> getAll();
}
