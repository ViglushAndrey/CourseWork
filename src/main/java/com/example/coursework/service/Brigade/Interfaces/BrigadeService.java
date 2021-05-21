package com.example.coursework.service.Brigade.Interfaces;

import com.example.coursework.model.BMP;
import com.example.coursework.model.Brigade;

import java.util.List;

public interface BrigadeService {
    Brigade getById(String id);
    Brigade create(Brigade brigade);
    Brigade update(Brigade brigade);
    Brigade delete(String id);
    List<Brigade> getAll();
}
