package com.example.coursework.service.Automats.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Automats;
import com.example.coursework.model.Ordinarys;
import com.example.coursework.model.Pistols;
import com.example.coursework.repository.Automats.AutomatsRepository;
import com.example.coursework.service.Automats.Interfaces.AutomatsService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
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
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        automats.setId(id);
        automats.setCreated_at(LocalDateTime.now());
        return repository.save(automats);
    }

    @Override
    public Automats update(Automats automats) {
        Automats automats1 = repository.findById(automats.getId()).get();

        automats.setId(automats.getId());
        automats.setCreated_at(automats1.getCreated_at());
        automats.setModify_at(LocalDateTime.now());
        return repository.save(automats);
    }

    public Automats getByName(String name){
        return repository.findAll().stream()
                .filter(item -> item.getModel().equals(name))
                .findFirst()
                .orElse(null);
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
