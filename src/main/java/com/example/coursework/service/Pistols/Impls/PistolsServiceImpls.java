package com.example.coursework.service.Pistols.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Pistols;
import com.example.coursework.repository.Pistols.PistolsRepository;
import com.example.coursework.service.Pistols.Interfaces.PistolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PistolsServiceImpls implements PistolsService {

    @Autowired
    PistolsRepository repository;

    @Autowired
    FakeData data;

    private List<Pistols> pistols = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        pistols = data.getPistols();
        repository.saveAll(pistols);
    }

    @Override
    public Pistols getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Pistols create(Pistols pistols) {
        return repository.save(pistols);
    }

    @Override
    public Pistols update(Pistols pistols) {
        return repository.save(pistols);
    }

    @Override
    public Pistols delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Pistols> getAll() {
        return repository.findAll();
    }
}
