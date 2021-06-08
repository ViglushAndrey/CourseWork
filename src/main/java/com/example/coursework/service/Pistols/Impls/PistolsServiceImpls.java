package com.example.coursework.service.Pistols.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Automats;
import com.example.coursework.model.Officers;
import com.example.coursework.model.Pistols;
import com.example.coursework.repository.Pistols.PistolsRepository;
import com.example.coursework.service.Pistols.Interfaces.PistolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
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
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        pistols.setId(id);
        pistols.setCreated_at(LocalDateTime.now());
        return repository.save(pistols);
    }

    @Override
    public Pistols update(Pistols pistols) {
        Pistols pistols1 = repository.findById(pistols.getId()).get();

        pistols.setId(pistols.getId());
        pistols.setCreated_at(pistols1.getCreated_at());
        pistols.setModify_at(LocalDateTime.now());
        return repository.save(pistols);
    }

    public Pistols getByName(String name){
        return repository.findAll().stream()
                .filter(item -> item.getModel().equals(name))
                .findFirst()
                .orElse(null);
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
