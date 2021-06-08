package com.example.coursework.service.Brigade.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Brigade;
import com.example.coursework.model.Rota;
import com.example.coursework.repository.Brigade.BrigadeRepository;
import com.example.coursework.repository.Rota.RotaRepository;
import com.example.coursework.service.Brigade.Interfaces.BrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrigadeServiceImpls implements BrigadeService {

    @Autowired
    BrigadeRepository repository;

    @Autowired
    FakeData data;

    private List<Brigade> brigades = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        brigades = data.getBrigade();
        repository.saveAll(brigades);
    }

    @Override
    public Brigade getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Brigade create(Brigade brigade) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        brigade.setId(id);
        brigade.setCreated_at(LocalDateTime.now());

        return repository.save(brigade);
    }

    public Brigade getByName(String name){
        return repository.findAll().stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Brigade update(Brigade brigade) {
        Brigade brigade1 = repository.findById(brigade.getId()).get();

        brigade.setId(brigade.getId());
        brigade.setCreated_at(brigade1.getCreated_at());
        brigade.setModify_at(LocalDateTime.now());
        return repository.save(brigade);
    }

    @Override
    public Brigade delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Brigade> getAll() {
        return repository.findAll();
    }
}
