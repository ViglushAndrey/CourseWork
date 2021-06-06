package com.example.coursework.service.BTR.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.BTR;
import com.example.coursework.model.Officers;
import com.example.coursework.repository.BTR.BTRRepository;
import com.example.coursework.repository.Officers.OfficersRepository;
import com.example.coursework.service.BTR.Interfaces.BTRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BTRServiceImpls implements BTRService {

    @Autowired
    BTRRepository repository;

    @Autowired
    FakeData data;

    private List<BTR> btrs = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        btrs = data.getBtr();
        repository.saveAll(btrs);
    }


    @Override
    public BTR getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public BTR create(BTR btr) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        btr.setId(id);
        btr.setCreated_at(LocalDateTime.now());

        return repository.save(btr);
    }

    @Override
    public BTR update(BTR btr) {
        BTR btr1 = repository.findById(btr.getId()).get();

        btr.setId(btr.getId());
        btr.setCreated_at(btr1.getCreated_at());
        btr.setModify_at(LocalDateTime.now());
        return repository.save(btr);
    }

    @Override
    public BTR delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<BTR> getAll() {
        return repository.findAll();
    }
}
