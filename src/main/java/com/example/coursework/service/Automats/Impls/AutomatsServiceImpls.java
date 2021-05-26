package com.example.coursework.service.Automats.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Automats;
import com.example.coursework.repository.Automats.AutomatsRepository;
import com.example.coursework.service.Automats.Interfaces.AutomatsService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class AutomatsServiceImpls implements  AutomatsService{

    @Autowired
    AutomatsRepository repository;

    @Autowired
    FakeData data;

    private List<Automats> automats = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        automats = data.getAutomats();
        repository.saveAll(automats);
    }

    @Override
    public Automats getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Automats create(Automats automats) {
        return repository.save(automats);
    }

    @Override
    public Automats update(Automats automats) {
        return repository.save(automats);
    }

    @Override
    public Automats delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Automats> getAll() {
        return repository.findAll();
    }
}
