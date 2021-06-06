package com.example.coursework.service.MachinesGuns.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.MachinesGuns;
import com.example.coursework.repository.MachinesGuns.MachinesGunsRepository;
import com.example.coursework.service.MachinesGuns.Interfaces.MachinesGunsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.Access;
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
        return repository.save(machinesGuns);
    }

    @Override
    public MachinesGuns update(MachinesGuns machinesGuns) {
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
