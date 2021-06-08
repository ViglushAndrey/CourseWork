package com.example.coursework.controller.rest;

import com.example.coursework.model.Armament;
import com.example.coursework.model.Automats;
import com.example.coursework.service.Armament.Impls.ArmamentServiceImpls;
import com.example.coursework.service.Automats.Impls.AutomatsServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/Automats")
public class AutomatsRestController {

    @Autowired
    AutomatsServiceImpls service;

    @RequestMapping(value = "/get/all")
    public List<Automats> getArmy() {
        return service.getAll();
    }

    @GetMapping(value = "/get/{id}")
    public Automats getById(@PathVariable("id") String id){
        return service.getById(id);
    }

    @GetMapping(value = "/delete/{id}")
    public Automats deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping(value = "/create/")
    public Automats create(@RequestBody Automats armament){
        return service.create(armament);
    }

    @PostMapping(value = "/update/")
    public Automats update(@RequestBody Automats armament){
        return service.update(armament);
    }

}
