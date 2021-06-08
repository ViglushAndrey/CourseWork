package com.example.coursework.controller.ui;

import com.example.coursework.forms.AutomatsForm;
import com.example.coursework.forms.PistolsForm;
import com.example.coursework.model.Automats;
import com.example.coursework.model.Pistols;
import com.example.coursework.service.Automats.Impls.AutomatsServiceImpls;
import com.example.coursework.service.Pistols.Impls.PistolsServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/Automats")
@Controller
public class AutomatsUIController {

    @Autowired
    AutomatsServiceImpls service;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<Automats> automats = service.getAll();
        model.addAttribute("automats", automats);
        //  model.addAttribute("items", service.getAll());
        return "automats/automats-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/Automats/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        AutomatsForm form = new AutomatsForm();
        model.addAttribute("form", form);
        return "automats/automats-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("form") AutomatsForm form){
        Automats automats = new Automats();
        automats.setModel(form.getModel());
        automats.setCaliber(form.getCaliber());
        automats.setNumberOfCartridgesInMagazine(form.getNumberOfCartridgesInMagazine());
        service.create(automats);
        return "redirect:/ui/Automats/get/all";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        Automats automats = service.getById(id);
        AutomatsForm form = new AutomatsForm();
        form.setId(id);
        form.setModel(automats.getModel());
        form.setCaliber(automats.getCaliber());
        form.setNumberOfCartridgesInMagazine(automats.getNumberOfCartridgesInMagazine());

        model.addAttribute("form", form);
        return "automats/automats-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") AutomatsForm form,
                              @PathVariable("id") String id){
        Automats automats = new Automats();
        automats.setId(form.getId());
        automats.setModel(form.getModel());
        automats.setCaliber(form.getCaliber());
        automats.setNumberOfCartridgesInMagazine(form.getNumberOfCartridgesInMagazine());
        service.update(automats);
        return "redirect:/ui/Automats/get/all";
    }

}
