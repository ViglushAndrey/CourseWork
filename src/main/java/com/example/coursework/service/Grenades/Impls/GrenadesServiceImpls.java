package com.example.coursework.service.Grenades.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Grenades;
import com.example.coursework.repository.Grenades.GrenadesRepository;
import com.example.coursework.service.Grenades.Interfaces.GrenadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class GrenadesServiceImpls implements GrenadesService {

    @Autowired
    GrenadesRepository repository;

    @Autowired
    FakeData data;

    static List<Grenades> grenades = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        grenades = data.getGrenades();
        repository.saveAll(grenades);
    }

    @Override
    public Grenades getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Grenades create(Grenades grenades) {
        return repository.save(grenades);
    }

    @Override
    public Grenades update(Grenades grenades) {
        return repository.save(grenades);
    }

    @Override
    public Grenades delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Grenades> getAll() {
        return repository.findAll();
    }
}
