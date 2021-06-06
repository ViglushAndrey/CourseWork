package com.example.coursework.controller.ui;

import com.example.coursework.forms.OfficerForm;
import com.example.coursework.forms.PistolsForm;
import com.example.coursework.model.Officers;
import com.example.coursework.model.OfficersRanks;
import com.example.coursework.model.Pistols;
import com.example.coursework.service.Officers.Impls.OfficersServiceImpls;
import com.example.coursework.service.Pistols.Impls.PistolsServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping(value = "/ui/Pistols")
@Controller
public class PistolsUIController {
    @Autowired
    PistolsServiceImpls service;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<Pistols> pistols = service.getAll();
        model.addAttribute("pistols", pistols);
        //  model.addAttribute("items", service.getAll());
        return "pistols/pistols-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/Pistols/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        PistolsForm pistolsForm = new PistolsForm();
        model.addAttribute("form", pistolsForm);
        return "pistols/pistols-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("pistolsForm") PistolsForm pistolsForm){
        Pistols pistols = new Pistols();
        pistols.setModel(pistolsForm.getModel());
        pistols.setCaliber(pistolsForm.getCaliber());
        pistols.setNumberOfCartridgesInMagazine(pistolsForm.getNumberOfCartridgesInMagazine());
        service.create(pistols);
        return "redirect:/ui/Pistols/get/all";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        Pistols pistols = service.getById(id);
        PistolsForm pistolsForm = new PistolsForm();
        pistolsForm.setId(id);
        pistolsForm.setModel(pistols.getModel());
        pistolsForm.setCaliber(pistols.getCaliber());
        pistolsForm.setNumberOfCartridgesInMagazine(pistols.getNumberOfCartridgesInMagazine());

        model.addAttribute("form", pistolsForm);
        return "pistols/pistols-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") PistolsForm pistolsForm,
                              @PathVariable("id") String id){
        Pistols pistols = new Pistols();
        pistols.setId(pistolsForm.getId());
        pistols.setModel(pistolsForm.getModel());
        pistols.setCaliber(pistolsForm.getCaliber());
        pistols.setNumberOfCartridgesInMagazine(pistolsForm.getNumberOfCartridgesInMagazine());
        service.update(pistols);
        return "redirect:/ui/Pistols/get/all";
    }
}
