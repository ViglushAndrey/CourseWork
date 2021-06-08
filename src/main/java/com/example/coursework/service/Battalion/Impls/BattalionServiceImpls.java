package com.example.coursework.service.Battalion.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Battalion;
import com.example.coursework.model.Brigade;
import com.example.coursework.repository.Battalion.BattalionRepository;
import com.example.coursework.repository.Brigade.BrigadeRepository;
import com.example.coursework.service.Battalion.Interfaces.BattalionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BattalionServiceImpls implements BattalionService {

    @Autowired
    BattalionRepository repository;

    @Autowired
    FakeData data;

    private List<Battalion> battalions = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        battalions = data.getBattalions();
        repository.saveAll(battalions);
    }

    @Override
    public Battalion getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Battalion create(Battalion battalion) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        battalion.setId(id);
        battalion.setCreated_at(LocalDateTime.now());

        return repository.save(battalion);
    }

    public Battalion getByName(String name){
        return repository.findAll().stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Battalion update(Battalion battalion) {
        Battalion battalion1 = repository.findById(battalion.getId()).get();

        battalion.setId(battalion.getId());
        battalion.setCreated_at(battalion1.getCreated_at());
        battalion.setModify_at(LocalDateTime.now());
        return repository.save(battalion);
    }

    @Override
    public Battalion delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Battalion> getAll() {
        return repository.findAll();
    }
}
