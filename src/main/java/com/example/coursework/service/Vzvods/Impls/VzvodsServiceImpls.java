package com.example.coursework.service.Vzvods.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Department;
import com.example.coursework.model.Vzvods;
import com.example.coursework.repository.Departament.DepartamentRepository;
import com.example.coursework.repository.Vzvods.VzvodsRepository;
import com.example.coursework.service.Vzvods.Interfaces.VzvodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VzvodsServiceImpls implements VzvodsService {

    @Autowired
    VzvodsRepository repository;

    @Autowired
    FakeData data;

    private List<Vzvods> vzvods = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        vzvods = data.getVzvods();
        repository.saveAll(vzvods);
    }

    @Override
    public Vzvods getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Vzvods create(Vzvods vzvods) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        vzvods.setId(id);
        vzvods.setCreated_at(LocalDateTime.now());

        return repository.save(vzvods);
    }

    public Vzvods getByName(String name){
        return repository.findAll().stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Vzvods update(Vzvods vzvods) {
        Vzvods vzvods1 = repository.findById(vzvods.getId()).get();

        vzvods.setId(vzvods.getId());
        vzvods.setCreated_at(vzvods1.getCreated_at());
        vzvods.setModify_at(LocalDateTime.now());
        return repository.save(vzvods);
    }

    @Override
    public Vzvods delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Vzvods> getAll() {
        return repository.findAll();
    }
}
