package com.example.coursework.service.TransportEquipment.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Officers;
import com.example.coursework.model.SniperRifles;
import com.example.coursework.model.Tractor;
import com.example.coursework.model.TransportEquipment;
import com.example.coursework.repository.SniperRifles.SniperRiflesRepository;
import com.example.coursework.repository.TransportEquipment.TransportEquipmentRepository;
import com.example.coursework.service.TransportEquipment.Interfaces.TransportEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
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
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        transportEquipment.setId(id);
        transportEquipment.setCreated_at(LocalDateTime.now());
        return repository.save(transportEquipment);
    }

    public TransportEquipment getTransEq(String transEq){
        return repository.findAll().stream()
                .filter(item -> String.valueOf(item.getTotalTransportEquipment()).equals(transEq))
                .findFirst()
                .orElse(null);
    }

    @Override
    public TransportEquipment update(TransportEquipment transportEquipment) {
        TransportEquipment transportEquipment1 = repository.findById(transportEquipment.getId()).get();

        transportEquipment.setId(transportEquipment.getId());
        transportEquipment.setCreated_at(transportEquipment1.getCreated_at());
        transportEquipment.setModify_at(LocalDateTime.now());
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
