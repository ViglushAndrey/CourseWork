package com.example.coursework.service.Viddilenia.Interfaces;

import com.example.coursework.model.TransportEquipment;
import com.example.coursework.model.Viddilenia;

import java.util.List;

public interface ViddileniaService {
    Viddilenia getById(String id);
    Viddilenia create(Viddilenia viddilenia);
    Viddilenia update(Viddilenia viddilenia);
    Viddilenia delete(String id);
    List<Viddilenia> getAll();
}
