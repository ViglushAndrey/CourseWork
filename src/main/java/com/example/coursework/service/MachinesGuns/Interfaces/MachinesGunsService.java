package com.example.coursework.service.MachinesGuns.Interfaces;

import com.example.coursework.model.Grenades;
import com.example.coursework.model.MachinesGuns;

import java.util.List;

public interface MachinesGunsService {
    MachinesGuns getById(String id);
    MachinesGuns create(MachinesGuns machinesGuns);
    MachinesGuns update(MachinesGuns machinesGuns);
    MachinesGuns delete(String id);
    List<MachinesGuns> getAll();
}
