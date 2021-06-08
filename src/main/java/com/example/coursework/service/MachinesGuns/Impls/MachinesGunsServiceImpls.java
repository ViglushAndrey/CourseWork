package com.example.coursework.service.MachinesGuns.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Automats;
import com.example.coursework.model.MachinesGuns;
import com.example.coursework.repository.MachinesGuns.MachinesGunsRepository;
import com.example.coursework.service.MachinesGuns.Interfaces.MachinesGunsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.Access;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class MachinesGunsServiceImpls implements MachinesGunsService {

    @Autowired
    MachinesGunsRepository repository;

    @Autowired
    FakeData data;

    private  List<MachinesGuns> machinesGuns = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        machinesGuns = data.getMachinesGuns();
        repository.saveAll(machinesGuns);
    }

    @Override
    public MachinesGuns getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public MachinesGuns create(MachinesGuns machinesGuns) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        machinesGuns.setId(id);
        machinesGuns.setCreated_at(LocalDateTime.now());
        return repository.save(machinesGuns);
    }

    public MachinesGuns getByName(String name){
        return repository.findAll().stream()
                .filter(item -> item.getModel().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public MachinesGuns update(MachinesGuns machinesGuns) {
        MachinesGuns machinesGuns1 = repository.findById(machinesGuns.getId()).get();

        machinesGuns.setId(machinesGuns.getId());
        machinesGuns.setCreated_at(machinesGuns1.getCreated_at());
        machinesGuns.setModify_at(LocalDateTime.now());
        return repository.save(machinesGuns);
    }

    @Override
    public MachinesGuns delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<MachinesGuns> getAll() {
        return repository.findAll();
    }
}
