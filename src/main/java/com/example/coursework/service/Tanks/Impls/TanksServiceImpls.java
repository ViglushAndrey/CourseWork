package com.example.coursework.service.Tanks.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.BMP;
import com.example.coursework.model.Tanks;
import com.example.coursework.repository.BMP.BMPRepository;
import com.example.coursework.repository.Tanks.TanksRepository;
import com.example.coursework.service.Tanks.Interfaces.TanksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TanksServiceImpls implements TanksService {

    @Autowired
    TanksRepository repository;

    @Autowired
    FakeData data;

    private List<Tanks> tanks = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        tanks = data.getTanks();
        repository.saveAll(tanks);
    }

    @Override
    public Tanks getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Tanks create(Tanks tanks) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        tanks.setId(id);
        tanks.setCreated_at(LocalDateTime.now());
        return repository.save(tanks);
    }

    @Override
    public Tanks update(Tanks tanks) {
        Tanks tanks1 = repository.findById(tanks.getId()).get();

        tanks.setId(tanks.getId());
        tanks.setCreated_at(tanks1.getCreated_at());
        tanks.setModify_at(LocalDateTime.now());
        return repository.save(tanks);
    }

    @Override
    public Tanks delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Tanks> getAll() {
        return repository.findAll();
    }
}
