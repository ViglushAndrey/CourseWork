package com.example.coursework.service.Serguants.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Officers;
import com.example.coursework.model.Ordinarys;
import com.example.coursework.model.Serguants;
import com.example.coursework.repository.Officers.OfficersRepository;
import com.example.coursework.repository.Serguants.SerguantsRepository;
import com.example.coursework.service.Serguants.Interfaces.SerguantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SerguantsServiceImpls implements SerguantsService {

    @Autowired
    SerguantsRepository repository;

    @Autowired
    FakeData data;

    private List<Serguants> serguants = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        serguants = data.getSerguants();
        repository.saveAll(serguants);
    }

    @Override
    public Serguants getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Serguants create(Serguants serguants) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        serguants.setId(id);
        serguants.setCreated_at(LocalDateTime.now());

        return repository.save(serguants);
    }

    public Serguants getByName(String name){
        return repository.findAll().stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Serguants update(Serguants serguants) {
        Serguants serguants1 = repository.findById(serguants.getId()).get();

        serguants.setId(serguants.getId());
        serguants.setCreated_at(serguants1.getCreated_at());
        serguants.setModify_at(LocalDateTime.now());
        return repository.save(serguants);
    }

    @Override
    public Serguants delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Serguants> getAll() {
        return repository.findAll();
    }
}
