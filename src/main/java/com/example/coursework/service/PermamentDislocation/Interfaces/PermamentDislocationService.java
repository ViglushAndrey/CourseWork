package com.example.coursework.service.PermamentDislocation.Interfaces;

import com.example.coursework.model.Ordinarys;
import com.example.coursework.model.PermanentDislocation;

import java.util.List;

public interface PermamentDislocationService {
    PermanentDislocation getById(String id);
    PermanentDislocation create(PermanentDislocation permanentDislocation);
    PermanentDislocation update(PermanentDislocation permanentDislocation);
    PermanentDislocation delete(String id);
    List<PermanentDislocation> getAll();
}
