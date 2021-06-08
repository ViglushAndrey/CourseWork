package com.example.coursework.service.FreightCar.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.FreightCar;
import com.example.coursework.model.Tractor;
import com.example.coursework.repository.FreightCar.FreightCarRepository;
import com.example.coursework.repository.Tractor.TractorRepository;
import com.example.coursework.service.FreightCar.Interfaces.FreightCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FreightCarServiceImpls implements FreightCarService {

    @Autowired
    FreightCarRepository repository;

    @Autowired
    FakeData data;

    private List<FreightCar> freightCars = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        freightCars = data.getFreightCars();
        repository.saveAll(freightCars);
    }

    @Override
    public FreightCar getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public FreightCar create(FreightCar freightCar) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        freightCar.setId(id);
        freightCar.setCreated_at(LocalDateTime.now());

        return repository.save(freightCar);
    }

    public FreightCar getByName(String name){
        return repository.findAll().stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public FreightCar update(FreightCar freightCar) {
        FreightCar freightCar1 = repository.findById(freightCar.getId()).get();

        freightCar.setId(freightCar.getId());
        freightCar.setCreated_at(freightCar1.getCreated_at());
        freightCar.setModify_at(LocalDateTime.now());
        return repository.save(freightCar);
    }

    @Override
    public FreightCar delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<FreightCar> getAll() {
        return repository.findAll();
    }
}
