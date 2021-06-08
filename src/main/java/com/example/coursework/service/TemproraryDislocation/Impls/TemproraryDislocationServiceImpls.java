package com.example.coursework.service.TemproraryDislocation.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Tanks;
import com.example.coursework.model.TemporaryDislocation;
import com.example.coursework.model.Tractor;
import com.example.coursework.repository.Tanks.TanksRepository;
import com.example.coursework.repository.TemproraryDislocation.TemproraryDislocationRepository;
import com.example.coursework.service.TemproraryDislocation.Interfaces.TemproraryDislocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TemproraryDislocationServiceImpls implements TemproraryDislocationService {

    @Autowired
    TemproraryDislocationRepository repository;

    @Autowired
    FakeData data;

    private List<TemporaryDislocation> temporaryDislocations = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        temporaryDislocations = data.getTemporaryDislocations();
        repository.saveAll(temporaryDislocations);
    }

    @Override
    public TemporaryDislocation getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public TemporaryDislocation create(TemporaryDislocation temporaryDislocation) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        temporaryDislocation.setId(id);
        temporaryDislocation.setCreated_at(LocalDateTime.now());
        return repository.save(temporaryDislocation);
    }

    public TemporaryDislocation getTempDisloc(String tempDisloc){
        return repository.findAll().stream()
                .filter(item -> item.getTemporaryDislocation().equals(tempDisloc))
                .findFirst()
                .orElse(null);
    }

    @Override
    public TemporaryDislocation update(TemporaryDislocation temporaryDislocation) {
        TemporaryDislocation temporaryDislocation1 = repository.findById(temporaryDislocation.getId()).get();

        temporaryDislocation.setId(temporaryDislocation.getId());
        temporaryDislocation.setCreated_at(temporaryDislocation1.getCreated_at());
        temporaryDislocation.setModify_at(LocalDateTime.now());
        return repository.save(temporaryDislocation);
    }

    @Override
    public TemporaryDislocation delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<TemporaryDislocation> getAll() {
        return repository.findAll();
    }
}
