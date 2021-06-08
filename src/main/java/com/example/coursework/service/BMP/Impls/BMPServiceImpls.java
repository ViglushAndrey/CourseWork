package com.example.coursework.service.BMP.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.BMP;
import com.example.coursework.model.FreightCar;
import com.example.coursework.model.Officers;
import com.example.coursework.repository.BMP.BMPRepository;
import com.example.coursework.repository.Officers.OfficersRepository;
import com.example.coursework.service.BMP.Interfaces.BMPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BMPServiceImpls implements BMPService {

    @Autowired
    BMPRepository repository;

    @Autowired
    FakeData data;

    private List<BMP> bmps = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        bmps = data.getBmp();
        repository.saveAll(bmps);
    }

    @Override
    public BMP getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public BMP create(BMP bmp) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        bmp.setId(id);
        bmp.setCreated_at(LocalDateTime.now());
        return repository.save(bmp);
    }

    public BMP getByName(String name){
        return repository.findAll().stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public BMP update(BMP bmp) {
        BMP bmp1 = repository.findById(bmp.getId()).get();

        bmp.setId(bmp.getId());
        bmp.setCreated_at(bmp1.getCreated_at());
        bmp.setModify_at(LocalDateTime.now());
        return repository.save(bmp);
    }

    @Override
    public BMP delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<BMP> getAll() {
        return repository.findAll();
    }
}
