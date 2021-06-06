package com.example.coursework.service.MilitaryEquipment.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.MilitaryEquipment;
import com.example.coursework.repository.MilitaryEquipment.MilitaryEquipmentRepository;
import com.example.coursework.service.MilitaryEquipment.Interfaces.MilitaryEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class MilitaryEquipmentServiceImpls implements MilitaryEquipmentService {

    @Autowired
    MilitaryEquipmentRepository repository;

    @Autowired
    FakeData data;

    private List<MilitaryEquipment> militaryEquipments = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        militaryEquipments = data.getMilitaryEquipments();
        repository.saveAll(militaryEquipments);
    }

    @Override
    public MilitaryEquipment getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public MilitaryEquipment create(MilitaryEquipment militaryEquipment) {
        return repository.save(militaryEquipment);
    }

    @Override
    public MilitaryEquipment update(MilitaryEquipment militaryEquipment) {
        return repository.save(militaryEquipment);
    }

    @Override
    public MilitaryEquipment delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<MilitaryEquipment> getAll() {
        return repository.findAll();
    }
}
