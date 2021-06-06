package com.example.coursework.controller.ui;

import com.example.coursework.forms.BMPForm;
import com.example.coursework.forms.BTRForm;
import com.example.coursework.forms.OfficerForm;
import com.example.coursework.model.BMP;
import com.example.coursework.model.BTR;
import com.example.coursework.model.Officers;
import com.example.coursework.model.OfficersRanks;
import com.example.coursework.service.BTR.Impls.BTRServiceImpls;
import com.example.coursework.service.Officers.Impls.OfficersServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping(value = "/ui/BTR")
@Controller
public class BTRUIController {
    @Autowired
    BTRServiceImpls service;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<BTR> btr = service.getAll();
        model.addAttribute("btr", btr);
        //  model.addAttribute("items", service.getAll());
        return "btr/btr-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/BTR/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        BTRForm btrForm = new BTRForm();
        model.addAttribute("form", btrForm);
        return "btr/btr-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("officerForm") BTRForm btrForm){
        BTR btr = new BTR();
        btr.setName(btrForm.getName());
        btr.setPersonnel(btrForm.getPersonnel());
        btr.setArmament(btrForm.getArmament());
        btr.setCombatWeight(btrForm.getCombatWeight());
        service.create(btr);
        return "redirect:/ui/BTR/get/all";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        BTR btr = service.getById(id);
        BTRForm btrForm = new BTRForm();
        btrForm.setId(id);
        btrForm.setName(btr.getName());
        btrForm.setPersonnel(btr.getPersonnel());
        btrForm.setArmament(btr.getArmament());
        btrForm.setCombatWeight(btr.getCombatWeight());
        //officerForm.setbDay(officers.getbDay());

        model.addAttribute("form", btrForm);
        return "btr/btr-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") BTRForm btrForm,
                              @PathVariable("id") String id){
        BTR btr = new BTR();
        btr.setId(btrForm.getId());
        btr.setName(btrForm.getName());
        btr.setPersonnel(btrForm.getPersonnel());
        btr.setArmament(btrForm.getArmament());
        btr.setCombatWeight(btrForm.getCombatWeight());
        service.update(btr);
        return "redirect:/ui/BTR/get/all";
    }
}
