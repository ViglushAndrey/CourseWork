package com.example.coursework.service.Obj.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Obj;
import com.example.coursework.model.Officers;
import com.example.coursework.model.Tractor;
import com.example.coursework.repository.Obj.ObjRepository;
import com.example.coursework.repository.Officers.OfficersRepository;
import com.example.coursework.service.Obj.Interfaces.ObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ObjServiceImpls implements ObjService {

    @Autowired
    ObjRepository repository;

    @Autowired
    FakeData data;

    private List<Obj> objs = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        objs = data.getObj();
        repository.saveAll(objs);
    }

    @Override
    public Obj getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Obj create(Obj obj) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        obj.setId(id);
        obj.setCreated_at(LocalDateTime.now());

        return repository.save(obj);
    }

    public Obj getByTypes(String types){
        return repository.findAll().stream()
                .filter(item -> item.getTypesOfBuildings().equals(types))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Obj update(Obj obj) {
        Obj obj1 = repository.findById(obj.getId()).get();

        obj.setId(obj.getId());
        obj.setCreated_at(obj1.getCreated_at());
        obj.setModify_at(LocalDateTime.now());
        return repository.save(obj);
    }

    @Override
    public Obj delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Obj> getAll() {
        return repository.findAll();
    }
}
