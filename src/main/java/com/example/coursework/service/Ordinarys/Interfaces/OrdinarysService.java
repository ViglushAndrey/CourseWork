package com.example.coursework.service.Ordinarys.Interfaces;

import com.example.coursework.model.Officers;
import com.example.coursework.model.Ordinarys;

import java.util.List;

public interface OrdinarysService {
    Ordinarys getById(String id);
    Ordinarys create(Ordinarys ordinarys);
    Ordinarys update(Ordinarys ordinarys);
    Ordinarys delete(String id);
    List<Ordinarys> getAll();
}
