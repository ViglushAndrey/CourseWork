package com.example.coursework.service.TransportEquipment.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.SniperRifles;
import com.example.coursework.model.TransportEquipment;
import com.example.coursework.repository.SniperRifles.SniperRiflesRepository;
import com.example.coursework.repository.TransportEquipment.TransportEquipmentRepository;
import com.example.coursework.service.TransportEquipment.Interfaces.TransportEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class TransportEquipmentServiceImpls implements TransportEquipmentService {

    @Autowired
    TransportEquipmentRepository repository;

    @Autowired
    FakeData data;

    private List<TransportEquipment> transportEquipments = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        transportEquipments = data.getTransportEquipments();
        repository.saveAll(transportEquipments);
    }

    @Override
    public TransportEquipment getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public TransportEquipment create(TransportEquipment transportEquipment) {
        return repository.save(transportEquipment);
    }

    @Override
    public TransportEquipment update(TransportEquipment transportEquipment) {
        return repository.save(transportEquipment);
    }

    @Override
    public TransportEquipment delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<TransportEquipment> getAll() {
        return repository.findAll();
    }
}
