package com.example.coursework.service.Obj.Interfaces;

import com.example.coursework.model.MilitaryEquipment;
import com.example.coursework.model.Obj;

import java.util.List;

public interface ObjService {
    Obj getById(String id);
    Obj create(Obj obj);
    Obj update(Obj obj);
    Obj delete(String id);
    List<Obj> getAll();
}
