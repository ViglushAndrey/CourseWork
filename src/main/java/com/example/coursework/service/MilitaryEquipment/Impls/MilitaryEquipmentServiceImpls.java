package com.example.coursework.service.MilitaryEquipment.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Automats;
import com.example.coursework.model.MilitaryEquipment;
import com.example.coursework.model.TransportEquipment;
import com.example.coursework.repository.MilitaryEquipment.MilitaryEquipmentRepository;
import com.example.coursework.service.MilitaryEquipment.Interfaces.MilitaryEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.jsf.FacesContextUtils;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
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

    public MilitaryEquipment getMilitEq(String militEq){
        return repository.findAll().stream()
                .filter(item -> String.valueOf(item.getTotalMilitaryEquipment()).equals(militEq))
                .findFirst()
                .orElse(null);
    }


    @Override
    public MilitaryEquipment create(MilitaryEquipment militaryEquipment) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        militaryEquipment.setId(id);
        militaryEquipment.setCreated_at(LocalDateTime.now());
        return repository.save(militaryEquipment);
    }

    @Override
    public MilitaryEquipment update(MilitaryEquipment militaryEquipment) {
        MilitaryEquipment militaryEquipment1 = repository.findById(militaryEquipment.getId()).get();

        militaryEquipment.setId(militaryEquipment.getId());
        militaryEquipment.setCreated_at(militaryEquipment1.getCreated_at());
        militaryEquipment.setModify_at(LocalDateTime.now());
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
