package com.example.coursework.controller.ui;

import com.example.coursework.forms.BMPForm;
import com.example.coursework.forms.TanksForm;
import com.example.coursework.model.BMP;
import com.example.coursework.model.Tanks;
import com.example.coursework.service.BMP.Impls.BMPServiceImpls;
import com.example.coursework.service.Tanks.Impls.TanksServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/Tanks")
@Controller
public class TanksUIController {


    @Autowired
    TanksServiceImpls service;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<Tanks> tanks = service.getAll();
        model.addAttribute("tanks", tanks);
        //  model.addAttribute("items", service.getAll());
        return "tanks/tanks-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/Tanks/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        TanksForm tanksForm = new TanksForm();
        model.addAttribute("form", tanksForm);
        return "tanks/tanks-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("tanksForm") TanksForm tanksForm){
        Tanks tanks = new Tanks();
        tanks.setName(tanksForm.getName());
        tanks.setPersonnel(tanksForm.getPersonnel());
        tanks.setCombatWeight(tanksForm.getCombatWeight());
        tanks.setEnginePower(tanksForm.getEnginePower());
        tanks.setEngineType(tanksForm.getEngineType());
        tanks.setGunModel(tanksForm.getGunModel());
        tanks.setCaliberOfGun(tanksForm.getCaliberOfGun());
        service.create(tanks);
        return "redirect:/ui/Tanks/get/all";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        Tanks tanks = service.getById(id);
        TanksForm tanksForm = new TanksForm();
        tanksForm.setId(id);
        tanksForm.setName(tanks.getName());
        tanksForm.setPersonnel(tanks.getPersonnel());
        tanksForm.setCombatWeight(tanks.getCombatWeight());
        tanksForm.setEnginePower(tanks.getEnginePower());
        tanksForm.setEngineType(tanks.getEngineType());
        tanksForm.setGunModel(tanks.getGunModel());
        tanksForm.setCaliberOfGun(tanks.getCaliberOfGun());
        //officerForm.setbDay(officers.getbDay());

        model.addAttribute("form", tanksForm);
        return "tanks/tanks-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") TanksForm tanksForm,
                              @PathVariable("id") String id){
        Tanks tanks = new Tanks();
        tanks.setId(tanksForm.getId());
        tanks.setName(tanksForm.getName());
        tanks.setPersonnel(tanksForm.getPersonnel());
        tanks.setCombatWeight(tanksForm.getCombatWeight());
        tanks.setEnginePower(tanksForm.getEnginePower());
        tanks.setEngineType(tanksForm.getEngineType());
        tanks.setGunModel(tanksForm.getGunModel());
        tanks.setCaliberOfGun(tanksForm.getCaliberOfGun());
        service.update(tanks);
        return "redirect:/ui/Tanks/get/all";
    }

}
