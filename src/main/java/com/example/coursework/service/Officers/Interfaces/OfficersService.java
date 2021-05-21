package com.example.coursework.service.Officers.Interfaces;

import com.example.coursework.model.Obj;
import com.example.coursework.model.Officers;

import java.util.List;

public interface OfficersService {
    Officers getById(String id);
    Officers create(Officers officers);
    Officers update(Officers officers);
    Officers delete(String id);
    List<Officers> getAll();
}
