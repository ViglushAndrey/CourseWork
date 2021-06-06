package com.example.coursework.controller.ui;

import com.example.coursework.forms.OfficerForm;
import com.example.coursework.forms.TractorForm;
import com.example.coursework.model.Officers;
import com.example.coursework.model.OfficersRanks;
import com.example.coursework.model.Tractor;
import com.example.coursework.service.Officers.Impls.OfficersServiceImpls;
import com.example.coursework.service.Tractor.Impls.TractorServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping(value = "/ui/Tractor")
@Controller
public class TractorUIController {

    @Autowired
    TractorServiceImpls service;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<Tractor> tractors = service.getAll();
        model.addAttribute("tractors", tractors);
        //  model.addAttribute("items", service.getAll());
        return "tractors/tractors-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/Tractor/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        TractorForm tractorForm = new TractorForm();
        model.addAttribute("form", tractorForm);
        return "tractors/tractors-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("tractorForm") TractorForm tractorForm){
        Tractor tractor = new Tractor();
        tractor.setName(tractorForm.getName());
        tractor.setWeight(tractorForm.getWeight());
        tractor.setMaximumSpeed(tractorForm.getMaximumSpeed());
        tractor.setLiftingCapacity(tractorForm.getLiftingCapacity());
        tractor.setBodyType(tractorForm.getBodyType());
        service.create(tractor);
        return "redirect:/ui/Tractor/get/all";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        Tractor tractor = service.getById(id);
        TractorForm tractorForm = new TractorForm();
        tractorForm.setId(id);
        tractorForm.setName(tractor.getName());
        tractorForm.setWeight(tractor.getWeight());
        tractorForm.setMaximumSpeed(tractor.getMaximumSpeed());
        tractorForm.setLiftingCapacity(tractor.getLiftingCapacity());
        tractorForm.setBodyType(tractor.getBodyType());
        model.addAttribute("form", tractorForm);
        return "tractors/tractors-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") TractorForm tractorForm,
                              @PathVariable("id") String id){
        Tractor tractor = new Tractor();
        tractor.setId(tractorForm.getId());
        tractor.setName(tractorForm.getName());
        tractor.setWeight(tractorForm.getWeight());
        tractor.setMaximumSpeed(tractorForm.getMaximumSpeed());
        tractor.setLiftingCapacity(tractorForm.getLiftingCapacity());
        tractor.setBodyType(tractorForm.getBodyType());
        service.update(tractor);
        return "redirect:/ui/Tractor/get/all";
    }
}
