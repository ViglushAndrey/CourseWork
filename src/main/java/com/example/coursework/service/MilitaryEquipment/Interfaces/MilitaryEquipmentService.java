package com.example.coursework.service.MilitaryEquipment.Interfaces;

import com.example.coursework.model.MachinesGuns;
import com.example.coursework.model.MilitaryEquipment;

import java.util.List;

public interface MilitaryEquipmentService {
    MilitaryEquipment getById(String id);
    MilitaryEquipment create(MilitaryEquipment militaryEquipment);
    MilitaryEquipment update(MilitaryEquipment militaryEquipment);
    MilitaryEquipment delete(String id);
    List<MilitaryEquipment> getAll();
}
