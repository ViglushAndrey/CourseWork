package com.example.coursework.service.Tractor.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.FreightCar;
import com.example.coursework.model.Officers;
import com.example.coursework.model.Tanks;
import com.example.coursework.model.Tractor;
import com.example.coursework.repository.Officers.OfficersRepository;
import com.example.coursework.repository.Tractor.TractorRepository;
import com.example.coursework.service.Tanks.Interfaces.TanksService;
import com.example.coursework.service.Tractor.Interfaces.TractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TractorServiceImpls implements TractorService {

    @Autowired
    TractorRepository repository;

    @Autowired
    FakeData data;

    private List<Tractor> tractors = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        tractors = data.getTractors();
        repository.saveAll(tractors);
    }

    @Override
    public Tractor getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Tractor create(Tractor tractor) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        tractor.setId(id);
        tractor.setCreated_at(LocalDateTime.now());

        return repository.save(tractor);
    }

    public Tractor getByName(String name){
        return repository.findAll().stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Tractor update(Tractor tractor) {
        Tractor tractor1 = repository.findById(tractor.getId()).get();

        tractor.setId(tractor.getId());
        tractor.setCreated_at(tractor1.getCreated_at());
        tractor.setModify_at(LocalDateTime.now());
        return repository.save(tractor);
    }

    @Override
    public Tractor delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Tractor> getAll() {
        return repository.findAll();
    }
}
