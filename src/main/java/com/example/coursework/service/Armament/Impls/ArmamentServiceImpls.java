package com.example.coursework.service.Armament.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Armament;
import com.example.coursework.model.Department;
import com.example.coursework.repository.Armament.ArmamentRepository;
import com.example.coursework.service.Armament.Interfaces.ArmamentService;
import com.example.coursework.service.Officers.Interfaces.OfficersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArmamentServiceImpls implements ArmamentService {

    @Autowired
    ArmamentRepository repository;

    @Autowired
    FakeData data;

    private List<Armament> armaments = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        armaments = data.getArmament();
        repository.saveAll(armaments);
    }

    @Override
    public Armament getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Armament create(Armament armament) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        armament.setId(id);
        armament.setCreated_at(LocalDateTime.now());
        return repository.save(armament);
    }

    @Override
    public Armament update(Armament armament) {
        Armament armament1 = repository.findById(armament.getId()).get();

        armament.setId(armament.getId());
        armament.setCreated_at(armament1.getCreated_at());
        armament.setModify_at(LocalDateTime.now());
        return repository.save(armament);
    }

    public Armament getId(String id){
        return repository.findAll().stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Armament delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Armament> getAll() {
        return repository.findAll();
    }
}
