package com.example.coursework.service.Ordinarys.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Officers;
import com.example.coursework.model.Ordinarys;
import com.example.coursework.repository.Officers.OfficersRepository;
import com.example.coursework.repository.Ordinarys.OrdinarysRepository;
import com.example.coursework.service.Ordinarys.Interfaces.OrdinarysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.Access;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class OrdinarysServiceImpls implements OrdinarysService {

    @Autowired
    OrdinarysRepository repository;

    @Autowired
    FakeData data;

    private List<Ordinarys> ordinarys = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        ordinarys = data.getOrdinarys();
        repository.saveAll(ordinarys);
    }

    @Override
    public Ordinarys getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Ordinarys create(Ordinarys ordinarys) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        ordinarys.setId(id);
        ordinarys.setCreated_at(LocalDateTime.now());

        return repository.save(ordinarys);
    }

    @Override
    public Ordinarys update(Ordinarys ordinarys) {
        Ordinarys ordinarys1 = repository.findById(ordinarys.getId()).get();

        ordinarys.setId(ordinarys.getId());
        ordinarys.setCreated_at(ordinarys1.getCreated_at());
        ordinarys.setModify_at(LocalDateTime.now());
        return repository.save(ordinarys);
    }

    @Override
    public Ordinarys delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Ordinarys> getAll() {
         return repository.findAll();
    }
}
