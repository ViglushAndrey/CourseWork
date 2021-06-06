package com.example.coursework.controller.ui;

import com.example.coursework.forms.BMPForm;
import com.example.coursework.model.BMP;
import com.example.coursework.service.BMP.Impls.BMPServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/BMP")
@Controller
public class BMPUIController {

    @Autowired
    BMPServiceImpls service;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<BMP> bmp = service.getAll();
        model.addAttribute("bmp", bmp);
        //  model.addAttribute("items", service.getAll());
        return "bmp/bmp-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/BMP/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        BMPForm bmpForm = new BMPForm();
        model.addAttribute("form", bmpForm);
        return "bmp/bmp-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("bmpForm") BMPForm bmpForm){
        BMP bmp = new BMP();
        bmp.setName(bmpForm.getName());
        bmp.setPersonnel(bmpForm.getPersonnel());
        bmp.setArmament(bmpForm.getArmament());
        bmp.setCombatWeight(bmpForm.getCombatWeight());
        service.create(bmp);
        return "redirect:/ui/BMP/get/all";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        BMP bmp = service.getById(id);
        BMPForm bmpForm = new BMPForm();
        bmpForm.setId(id);
        bmpForm.setName(bmp.getName());
        bmpForm.setPersonnel(bmp.getPersonnel());
        bmpForm.setArmament(bmp.getArmament());
        bmpForm.setCombatWeight(bmp.getCombatWeight());
        //officerForm.setbDay(officers.getbDay());

        model.addAttribute("form", bmpForm);
        return "bmp/bmp-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") BMPForm bmpForm,
                              @PathVariable("id") String id){
        BMP bmp = new BMP();
        bmp.setId(bmpForm.getId());
        bmp.setName(bmpForm.getName());
        bmp.setPersonnel(bmpForm.getPersonnel());
        bmp.setArmament(bmpForm.getArmament());
        bmp.setCombatWeight(bmpForm.getCombatWeight());
        service.update(bmp);
        return "redirect:/ui/BMP/get/all";
    }
}
