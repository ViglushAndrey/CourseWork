package com.example.coursework.service.SniperRifles.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Automats;
import com.example.coursework.model.SniperRifles;
import com.example.coursework.repository.SniperRifles.SniperRiflesRepository;
import com.example.coursework.service.SniperRifles.Interfaces.SniperRiflesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
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
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        sniperRifles.setId(id);
        sniperRifles.setCreated_at(LocalDateTime.now());
        return repository.save(sniperRifles);
    }

    public SniperRifles getByName(String name){
        return repository.findAll().stream()
                .filter(item -> item.getModel().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public SniperRifles update(SniperRifles sniperRifles) {
        SniperRifles sniperRifles1 = repository.findById(sniperRifles.getId()).get();

        sniperRifles.setId(sniperRifles.getId());
        sniperRifles.setCreated_at(sniperRifles1.getCreated_at());
        sniperRifles.setModify_at(LocalDateTime.now());
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
