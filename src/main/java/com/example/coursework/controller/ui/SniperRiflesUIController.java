package com.example.coursework.controller.ui;

import com.example.coursework.forms.AutomatsForm;
import com.example.coursework.forms.SniperRiflesForm;
import com.example.coursework.model.Automats;
import com.example.coursework.model.SniperRifles;
import com.example.coursework.service.Automats.Impls.AutomatsServiceImpls;
import com.example.coursework.service.SniperRifles.Impls.SniperRiflesServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/SniperRifles")
@Controller
public class SniperRiflesUIController {

    @Autowired
    SniperRiflesServiceImpls service;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<SniperRifles> sniperRifles = service.getAll();
        model.addAttribute("sniperRifles", sniperRifles);
        //  model.addAttribute("items", service.getAll());
        return "sniperRifles/sniperRifles-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/SniperRifles/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        SniperRiflesForm form = new SniperRiflesForm();
        model.addAttribute("form", form);
        return "sniperRifles/sniperRifles-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("form") SniperRiflesForm form){
        SniperRifles sniperRifles = new SniperRifles();
        sniperRifles.setModel(form.getModel());
        sniperRifles.setCaliber(form.getCaliber());
        sniperRifles.setNumberOfCartridgesInMagazine(form.getNumberOfCartridgesInMagazine());
        service.create(sniperRifles);
        return "redirect:/ui/SniperRifles/get/all";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        SniperRifles sniperRifles = service.getById(id);
        SniperRiflesForm form = new SniperRiflesForm();
        form.setId(id);
        form.setModel(sniperRifles.getModel());
        form.setCaliber(sniperRifles.getCaliber());
        form.setNumberOfCartridgesInMagazine(sniperRifles.getNumberOfCartridgesInMagazine());

        model.addAttribute("form", form);
        return "sniperRifles/sniperRifles-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") SniperRiflesForm form,
                              @PathVariable("id") String id){
        SniperRifles sniperRifles = new SniperRifles();
        sniperRifles.setId(form.getId());
        sniperRifles.setModel(form.getModel());
        sniperRifles.setCaliber(form.getCaliber());
        sniperRifles.setNumberOfCartridgesInMagazine(form.getNumberOfCartridgesInMagazine());
        service.update(sniperRifles);
        return "redirect:/ui/SniperRifles/get/all";
    }

}
