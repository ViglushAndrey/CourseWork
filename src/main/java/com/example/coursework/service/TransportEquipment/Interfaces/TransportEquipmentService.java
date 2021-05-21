package com.example.coursework.service.TransportEquipment.Interfaces;

import com.example.coursework.model.Tractor;
import com.example.coursework.model.TransportEquipment;

import java.util.List;

public interface TransportEquipmentService {
    TransportEquipment getById(String id);
    TransportEquipment create(TransportEquipment transportEquipment);
    TransportEquipment update(TransportEquipment transportEquipment);
    TransportEquipment delete(String id);
    List<TransportEquipment> getAll();
}
