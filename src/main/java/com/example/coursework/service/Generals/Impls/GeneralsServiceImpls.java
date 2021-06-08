package com.example.coursework.service.Generals.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Generals;
import com.example.coursework.model.Officers;
import com.example.coursework.repository.Generals.GeneralsRepository;
import com.example.coursework.repository.Officers.OfficersRepository;
import com.example.coursework.service.Generals.Interfaces.GeneralsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeneralsServiceImpls implements GeneralsService {

    @Autowired
    GeneralsRepository repository;

    @Autowired
    FakeData data;

    private List<Generals> generals = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        generals = data.getGenerals();
        repository.saveAll(generals);
    }

    @Override
    public Generals getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Generals create(Generals generals) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        generals.setId(id);
        generals.setCreated_at(LocalDateTime.now());

        return repository.save(generals);
    }

    public Generals getByName(String name){
        return repository.findAll().stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Generals update(Generals generals) {

        Generals generals1 = repository.findById(generals.getId()).get();

        generals.setId(generals.getId());
        generals.setCreated_at(generals1.getCreated_at());
        generals.setModify_at(LocalDateTime.now());
        return repository.save(generals);
    }

    @Override
    public Generals delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Generals> getAll() {
        return repository.findAll();
    }
}
