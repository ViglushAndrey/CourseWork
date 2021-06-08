package com.example.coursework.service.Rota.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Rota;
import com.example.coursework.model.Vzvods;
import com.example.coursework.repository.Rota.RotaRepository;
import com.example.coursework.repository.Vzvods.VzvodsRepository;
import com.example.coursework.service.Rota.Interfaces.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RotaServiceImpls implements RotaService {

    @Autowired
    RotaRepository repository;

    @Autowired
    FakeData data;

    private List<Rota> rotas = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        rotas = data.getRota();
        repository.saveAll(rotas);
    }

    @Override
    public Rota getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Rota create(Rota rota) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        rota.setId(id);
        rota.setCreated_at(LocalDateTime.now());

        return repository.save(rota);
    }

    public Rota getByName(String name){
        return repository.findAll().stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Rota update(Rota rota) {
        Rota rota1 = repository.findById(rota.getId()).get();

        rota.setId(rota.getId());
        rota.setCreated_at(rota1.getCreated_at());
        rota.setModify_at(LocalDateTime.now());
        return repository.save(rota);
    }

    @Override
    public Rota delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Rota> getAll() {
        return repository.findAll();
    }
}
