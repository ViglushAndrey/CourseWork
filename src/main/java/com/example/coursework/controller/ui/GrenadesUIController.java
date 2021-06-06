package com.example.coursework.controller.ui;

import com.example.coursework.forms.GrenadesForm;
import com.example.coursework.forms.OfficerForm;
import com.example.coursework.model.Grenades;
import com.example.coursework.model.Officers;
import com.example.coursework.model.OfficersRanks;
import com.example.coursework.service.Grenades.Impls.GrenadesServiceImpls;
import com.example.coursework.service.Officers.Impls.OfficersServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping(value = "/ui/Grenades")
@Controller
public class GrenadesUIController {

    @Autowired
    GrenadesServiceImpls service;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<Grenades> grenades = service.getAll();
        model.addAttribute("grenades", grenades);
        //  model.addAttribute("items", service.getAll());
        return "grenades/grenades-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/Grenades/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        GrenadesForm grenadesForm = new GrenadesForm();
        model.addAttribute("form", grenadesForm);
        return "grenades/grenades-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("grenadesForm") GrenadesForm grenadesForm){
        Grenades grenades = new Grenades();
        grenades.setModel(grenadesForm.getModel());
        grenades.setType(grenadesForm.getType());
        grenades.setTheRadiusOfTheScatteringOfFragments(grenadesForm.getTheRadiusOfTheScatteringOfFragments());
        service.create(grenades);
        return "redirect:/ui/Grenades/get/all";


    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        Grenades grenades = service.getById(id);
        GrenadesForm grenadesForm = new GrenadesForm();
        grenadesForm.setId(id);
        grenadesForm.setModel(grenades.getModel());
        grenadesForm.setType(grenades.getType());
        grenadesForm.setTheRadiusOfTheScatteringOfFragments(grenades.getTheRadiusOfTheScatteringOfFragments());
        model.addAttribute("form", grenadesForm);
        return "grenades/grenades-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") GrenadesForm grenadesForm,
                              @PathVariable("id") String id){
        Grenades grenades = new Grenades();
        grenades.setId(grenadesForm.getId());
        grenades.setModel(grenadesForm.getModel());
        grenades.setType(grenadesForm.getType());
        grenades.setTheRadiusOfTheScatteringOfFragments(grenadesForm.getTheRadiusOfTheScatteringOfFragments());
        service.update(grenades);
        return "redirect:/ui/Grenades/get/all";
    }

}
