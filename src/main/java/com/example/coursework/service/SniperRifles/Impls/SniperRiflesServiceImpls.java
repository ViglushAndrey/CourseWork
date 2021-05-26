package com.example.coursework.service.SniperRifles.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.SniperRifles;
import com.example.coursework.repository.SniperRifles.SniperRiflesRepository;
import com.example.coursework.service.SniperRifles.Interfaces.SniperRiflesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class SniperRiflesServiceImpls implements SniperRiflesService {

    @Autowired
    SniperRiflesRepository repository;

    @Autowired
    FakeData data;

    private List<SniperRifles> sniperRifles = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        sniperRifles = data.getSniperRifles();
        repository.saveAll(sniperRifles);
    }

    @Override
    public SniperRifles getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public SniperRifles create(SniperRifles sniperRifles) {
        return repository.save(sniperRifles);
    }

    @Override
    public SniperRifles update(SniperRifles sniperRifles) {
        return repository.save(sniperRifles);
    }

    @Override
    public SniperRifles delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<SniperRifles> getAll() {
        return repository.findAll();
    }
}
