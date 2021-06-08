package com.example.coursework.controller.rest;

import com.example.coursework.model.Armament;
import com.example.coursework.model.Battalion;
import com.example.coursework.service.Armament.Impls.ArmamentServiceImpls;
import com.example.coursework.service.Battalion.Impls.BattalionServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/Battalion")
public class BattalionRestController {

    @Autowired
    BattalionServiceImpls service;

    @RequestMapping(value = "/get/all")
    public List<Battalion> getArmy() {
        return service.getAll();
    }

    @GetMapping(value = "/get/{id}")
    public Battalion getById(@PathVariable("id") String id){
        return service.getById(id);
    }

    @GetMapping(value = "/delete/{id}")
    public Battalion deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping(value = "/create/")
    public Battalion create(@RequestBody Battalion armament){
        return service.create(armament);
    }

    @PostMapping(value = "/update/")
    public Battalion update(@RequestBody Battalion armament){
        return service.update(armament);
    }

}
