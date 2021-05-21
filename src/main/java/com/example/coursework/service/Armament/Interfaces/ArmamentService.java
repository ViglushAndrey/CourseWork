package com.example.coursework.service.Armament.Interfaces;

import com.example.coursework.model.Armament;


import java.util.List;

public interface ArmamentService {
    Armament getById(String id);
    Armament create(Armament armament);
    Armament update(Armament armament);
    Armament delete(String id);
    List<Armament> getAll();
}
