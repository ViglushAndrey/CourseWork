package com.example.coursework.service.Army.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Armament;
import com.example.coursework.model.Army;
import com.example.coursework.repository.Army.ArmyRepository;
import com.example.coursework.service.Army.Interfaces.ArmyService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArmyServiceImpls implements ArmyService {
    @Autowired
    ArmyRepository repository;

    @Autowired
    FakeData data;

    @Override
    public Army getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Army create(Army army) {
        return repository.save(army);
    }

    @Override
    public Army update(Army army) {
        return repository.save(army);
    }

    @Override
    public Army delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Army> getAll() {

        return repository.findAll();
    }
/*
    private List<Army> armies = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        repository.saveAll(armaments);
    }
    */



}
