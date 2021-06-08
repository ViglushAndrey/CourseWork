package com.example.coursework.service.PermamentDislocation.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.PermanentDislocation;
import com.example.coursework.model.TemporaryDislocation;
import com.example.coursework.model.Tractor;
import com.example.coursework.repository.PermamentDislocation.PermamentDislocationRepository;
import com.example.coursework.repository.TemproraryDislocation.TemproraryDislocationRepository;
import com.example.coursework.service.PermamentDislocation.Interfaces.PermamentDislocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PermamentDislocationServiceImpls implements PermamentDislocationService {

    @Autowired
    PermamentDislocationRepository repository;

    @Autowired
    FakeData data;

    private List<PermanentDislocation> dislocations = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        dislocations = data.getPermanentDislocations();
        repository.saveAll(dislocations);
    }

    @Override
    public PermanentDislocation getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public PermanentDislocation create(PermanentDislocation permanentDislocation) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        permanentDislocation.setId(id);
        permanentDislocation.setCreated_at(LocalDateTime.now());
        return repository.save(permanentDislocation);
    }

    public PermanentDislocation getByPermDisloc(String permDisloc){
        return repository.findAll().stream()
                .filter(item -> item.getPermanentDislocation().equals(permDisloc))
                .findFirst()
                .orElse(null);
    }

    @Override
    public PermanentDislocation update(PermanentDislocation permanentDislocation) {
        PermanentDislocation dislocation = repository.findById(permanentDislocation.getId()).get();

        permanentDislocation.setId(permanentDislocation.getId());
        permanentDislocation.setCreated_at(dislocation.getCreated_at());
        permanentDislocation.setModify_at(LocalDateTime.now());
        return repository.save(permanentDislocation);
    }

    @Override
    public PermanentDislocation delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<PermanentDislocation> getAll() {
        return repository.findAll();
    }
}
