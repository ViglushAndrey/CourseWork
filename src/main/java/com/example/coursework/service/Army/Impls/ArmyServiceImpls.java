package com.example.coursework.service.Army.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Armament;
import com.example.coursework.model.Army;
import com.example.coursework.model.Brigade;
import com.example.coursework.repository.Army.ArmyRepository;
import com.example.coursework.service.Army.Interfaces.ArmyService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArmyServiceImpls implements ArmyService {
    @Autowired
    ArmyRepository repository;

    @Autowired
    FakeData data;

    private List<Army> armies = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        armies = data.getArmies();
        repository.saveAll(armies);
    }

    @Override
    public Army getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Army create(Army army) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        army.setId(id);
        army.setCreated_at(LocalDateTime.now());
        return repository.save(army);
    }

    public Army getByName(String name){
        return repository.findAll().stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Army update(Army army) {
        Army army1 = repository.findById(army.getId()).get();

        army.setId(army.getId());
        army.setCreated_at(army1.getCreated_at());
        army.setModify_at(LocalDateTime.now());
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
