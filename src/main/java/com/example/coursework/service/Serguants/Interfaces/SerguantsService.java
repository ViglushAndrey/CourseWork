package com.example.coursework.service.Serguants.Interfaces;

import com.example.coursework.model.Rota;
import com.example.coursework.model.Serguants;

import java.util.List;

public interface SerguantsService {
    Serguants getById(String id);
    Serguants create(Serguants serguants);
    Serguants update(Serguants serguants);
    Serguants delete(String id);
    List<Serguants> getAll();
}
