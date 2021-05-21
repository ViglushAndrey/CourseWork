package com.example.coursework.service.Automats.Interfaces;

import com.example.coursework.model.Army;
import com.example.coursework.model.Automats;

import java.util.List;

public interface AutomatsService {
    Automats getById(String id);
    Automats create(Automats automats);
    Automats update(Automats automats);
    Automats delete(String id);
    List<Automats> getAll();
}
