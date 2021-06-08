package com.example.coursework.service.Departament.Interfaces;

import com.example.coursework.model.Department;

import java.util.List;

public interface DepartamentService {
    Department getById(String id);
    Department create(Department department);
    Department update(Department department);
    Department delete(String id);
    List<Department> getAll();
}
