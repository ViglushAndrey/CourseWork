package com.example.coursework.service.Departament.Impls;

import com.example.coursework.data.FakeData;
import com.example.coursework.model.Department;
import com.example.coursework.model.Officers;
import com.example.coursework.model.Ordinarys;
import com.example.coursework.repository.Departament.DepartamentRepository;
import com.example.coursework.repository.Officers.OfficersRepository;
import com.example.coursework.service.Departament.Interfaces.DepartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartamentServiceImpls implements DepartamentService {

    @Autowired
    DepartamentRepository repository;

    @Autowired
    FakeData data;

    private List<Department> departments = new ArrayList<>();

    @PostConstruct
    void init(){
        repository.deleteAll();
        departments = data.getViddilenias();
        repository.saveAll(departments);
    }

    @Override
    public Department getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Department create(Department department) {
        String id = String.valueOf(repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        department.setId(id);
        department.setCreated_at(LocalDateTime.now());

        return repository.save(department);
    }

    public Department getByName(String name){
        return repository.findAll().stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Department update(Department department) {
        Department department1 = repository.findById(department.getId()).get();

        department.setId(department.getId());
        department.setCreated_at(department1.getCreated_at());
        department.setModify_at(LocalDateTime.now());
        return repository.save(department);
    }

    @Override
    public Department delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Department> getAll() {
        return repository.findAll();
    }
}
