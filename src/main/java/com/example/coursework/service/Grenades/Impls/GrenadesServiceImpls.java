package com.example.coursework.service.Grenades.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Automats;
import com.example.coursework.model.Grenades;
import com.example.coursework.model.Officers;
import com.example.coursework.repository.Grenades.GrenadesRepository;
import com.example.coursework.service.Grenades.Interfaces.GrenadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GrenadesServiceImpls implements GrenadesService {

    @Autowired
    GrenadesRepository repository;

    @Autowired
    FakeData data;

    static List<Grenades> grenadess = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        grenadess = data.getGrenades();
        repository.saveAll(grenadess);
    }

    @Override
    public Grenades getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Grenades create(Grenades grenades) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        grenades.setId(id);
        grenades.setCreated_at(LocalDateTime.now());
        return repository.save(grenades);
    }

    @Override
    public Grenades update(Grenades grenades) {

        Grenades grenades1 = repository.findById(grenades.getId()).get();

        grenades.setId(grenades.getId());
        grenades.setCreated_at(grenades1.getCreated_at());
        grenades.setModify_at(LocalDateTime.now());
        return repository.save(grenades);

    }

    public Grenades getByName(String name){
        return repository.findAll().stream()
                .filter(item -> item.getModel().equals(name))
                .findFirst()
                .orElse(null);
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
