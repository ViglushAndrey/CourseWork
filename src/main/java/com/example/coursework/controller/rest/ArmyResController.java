package com.example.coursework.controller.rest;

import com.example.coursework.model.Army;
import com.example.coursework.model.Officers;
import com.example.coursework.service.Army.Impls.ArmyServiceImpls;
import com.example.coursework.service.Officers.Impls.OfficersServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/Army")
public class ArmyResController {

    @Autowired
    ArmyServiceImpls service;

    @RequestMapping(value = "/get/all")
    public List<Army> getArmy() {
        return service.getAll();
    }

    @GetMapping(value = "/get/{id}")
    public Army getById(@PathVariable("id") String id){
        return service.getById(id);
    }

    @GetMapping(value = "/delete/{id}")
    public Army deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping(value = "/create/")
    public Army create(@RequestBody Army army){
        return service.create(army);
    }

    @PostMapping(value = "/update/")
    public Army update(@RequestBody Army army){
        return service.update(army);
    }

}
