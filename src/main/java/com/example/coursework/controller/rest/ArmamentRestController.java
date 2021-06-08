package com.example.coursework.controller.rest;

import com.example.coursework.model.Armament;
import com.example.coursework.model.Army;
import com.example.coursework.service.Armament.Impls.ArmamentServiceImpls;
import com.example.coursework.service.Army.Impls.ArmyServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/Armament")
public class ArmamentRestController {

    @Autowired
    ArmamentServiceImpls service;

    @RequestMapping(value = "/get/all")
    public List<Armament> getArmy() {
        return service.getAll();
    }

    @GetMapping(value = "/get/{id}")
    public Armament getById(@PathVariable("id") String id){
        return service.getById(id);
    }

    @GetMapping(value = "/delete/{id}")
    public Armament deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping(value = "/create/")
    public Armament create(@RequestBody Armament armament){
        return service.create(armament);
    }

    @PostMapping(value = "/update/")
    public Armament update(@RequestBody Armament armament){
        return service.update(armament);
    }

}
