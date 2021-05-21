package com.example.coursework.service.TemproraryDislocation.Interfaces;

import com.example.coursework.model.Tanks;
import com.example.coursework.model.TemporaryDislocation;

import java.util.List;

public interface TemproraryDislocationService {
    TemporaryDislocation getById(String id);
    TemporaryDislocation create(TemporaryDislocation temporaryDislocation);
    TemporaryDislocation update(TemporaryDislocation temporaryDislocation);
    TemporaryDislocation delete(String id);
    List<TemporaryDislocation> getAll();
}
