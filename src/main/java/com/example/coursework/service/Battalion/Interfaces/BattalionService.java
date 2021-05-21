package com.example.coursework.service.Battalion.Interfaces;

import com.example.coursework.model.Automats;
import com.example.coursework.model.Battalion;

import java.util.List;

public interface BattalionService {
    Battalion getById(String id);
    Battalion create(Battalion battalion);
    Battalion update(Battalion battalion);
    Battalion delete(String id);
    List<Battalion> getAll();

}
