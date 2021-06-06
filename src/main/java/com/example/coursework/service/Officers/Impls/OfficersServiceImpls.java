package com.example.coursework.service.Officers.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Officers;
import com.example.coursework.repository.Officers.OfficersRepository;
import com.example.coursework.service.Officers.Interfaces.OfficersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OfficersServiceImpls implements OfficersService {

//    @Autowired
//    OfficerDAOImpl dao;

    @Autowired
    OfficersRepository repository;

    @Autowired
    FakeData data;

    private List<Officers> officers = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        officers = data.getOfficers();
        repository.saveAll(officers);
    }

    @Override
    public Officers getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Officers create(Officers officers) {

        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        officers.setId(id);
        officers.setCreated_at(LocalDateTime.now());

        return repository.save(officers);
    }

    @Override
    public Officers update(Officers officers) {

        Officers officers1 = repository.findById(officers.getId()).get();

        officers.setId(officers.getId());
        officers.setCreated_at(officers1.getCreated_at());
        officers.setModify_at(LocalDateTime.now());
        return repository.save(officers);
    }

    @Override
    public Officers delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Officers> getAll() { return repository.findAll(); }
}
