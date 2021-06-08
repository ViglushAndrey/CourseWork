package com.example.coursework.controller.ui;


import com.example.coursework.forms.AutomatsForm;
import com.example.coursework.forms.MachinesGunsForm;
import com.example.coursework.model.Automats;
import com.example.coursework.model.MachinesGuns;
import com.example.coursework.service.Automats.Impls.AutomatsServiceImpls;
import com.example.coursework.service.MachinesGuns.Impls.MachinesGunsServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/MachinesGuns")
@Controller
public class MachinesGunsUIController {

    @Autowired
    MachinesGunsServiceImpls service;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<MachinesGuns> machinesGuns = service.getAll();
        model.addAttribute("machinesGuns", machinesGuns);
        //  model.addAttribute("items", service.getAll());
        return "machinesGuns/machinesGuns-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/MachinesGuns/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        MachinesGunsForm form = new MachinesGunsForm();
        model.addAttribute("form", form);
        return "machinesGuns/machinesGuns-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("form") MachinesGunsForm form){
        MachinesGuns machinesGuns = new MachinesGuns();
        machinesGuns.setModel(form.getModel());
        machinesGuns.setCaliber(form.getCaliber());
        machinesGuns.setNumberOfCartridgesInMagazine(form.getNumberOfCartridgesInMagazine());
        service.create(machinesGuns);
        return "redirect:/ui/MachinesGuns/get/all";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        MachinesGuns machinesGuns = service.getById(id);
        MachinesGunsForm form = new MachinesGunsForm();
        form.setId(id);
        form.setModel(machinesGuns.getModel());
        form.setCaliber(machinesGuns.getCaliber());
        form.setNumberOfCartridgesInMagazine(machinesGuns.getNumberOfCartridgesInMagazine());

        model.addAttribute("form", form);
        return "machinesGuns/machinesGuns-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") MachinesGunsForm form,
                              @PathVariable("id") String id){
        MachinesGuns machinesGuns = new MachinesGuns();
        machinesGuns.setId(form.getId());
        machinesGuns.setModel(form.getModel());
        machinesGuns.setCaliber(form.getCaliber());
        machinesGuns.setNumberOfCartridgesInMagazine(form.getNumberOfCartridgesInMagazine());
        service.update(machinesGuns);
        return "redirect:/ui/MachinesGuns/get/all";
    }

}
