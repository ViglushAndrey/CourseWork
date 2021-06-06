package com.example.coursework.controller.ui;

import com.example.coursework.forms.GeneralsForm;
import com.example.coursework.forms.OfficerForm;
import com.example.coursework.model.Generals;
import com.example.coursework.model.GeneralsRanks;
import com.example.coursework.model.Officers;
import com.example.coursework.model.OfficersRanks;
import com.example.coursework.service.Generals.Impls.GeneralsServiceImpls;
import com.example.coursework.service.Officers.Impls.OfficersServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping(value = "/ui/Generals")
@Controller
public class GeneralsUIController {

    @Autowired
    GeneralsServiceImpls service;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<Generals> generals = service.getAll();
        model.addAttribute("generals", generals);
        //  model.addAttribute("items", service.getAll());
        return "general/general-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/Generals/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        GeneralsForm generalsForm = new GeneralsForm();
        model.addAttribute("form", generalsForm);
        List<String> generalsRanks  = new ArrayList(
                Arrays.asList(GeneralsRanks.values())
        );
        model.addAttribute("generalsRanks", generalsRanks);
        return "general/general-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("generalsForm") GeneralsForm generalsForm){
        Generals generals = new Generals();
        generals.setName(generalsForm.getName());
        generals.setbDay(generalsForm.getbDay());
        generals.setSpeciality(generalsForm.getSpeciality());
        generals.setDateOfAssignmentOfAnOfficerRank(generalsForm.getDateOfAssignmentOfAnOfficerRank());
        generals.setAwards(generalsForm.getAwards());
        generals.setGeneralsRanks(generalsForm.getGeneralsRanks());
        service.create(generals);
        return "redirect:/ui/Generals/get/all";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        Generals generals = service.getById(id);
        GeneralsForm generalsForm = new GeneralsForm();
        generalsForm.setId(id);
        generalsForm.setName(generals.getName());
        //officerForm.setbDay(officers.getbDay());
        generalsForm.setbDay(generals.getbDay());
        generalsForm.setSpeciality(generals.getSpeciality());
        generalsForm.setDateOfAssignmentOfAnOfficerRank(generals.getDateOfAssignmentOfAnOfficerRank());
        generalsForm.setAwards(generals.getAwards());
        generalsForm.setGeneralsRanks(generals.getGeneralsRanks());
        model.addAttribute("form", generalsForm);
        List<String> generalsRanks  = new ArrayList(
                Arrays.asList(GeneralsRanks.values())
        );
        model.addAttribute("generalsRanks", generalsRanks);
        return "general/general-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") GeneralsForm generalsForm,
                              @PathVariable("id") String id){
        Generals generals = new Generals();
        generals.setId(generalsForm.getId());
        generals.setName(generalsForm.getName());
        generals.setbDay(generalsForm.getbDay());
        generals.setSpeciality(generalsForm.getSpeciality());
        generals.setDateOfAssignmentOfAnOfficerRank(generalsForm.getDateOfAssignmentOfAnOfficerRank());
        generals.setAwards(generalsForm.getAwards());
        generals.setGeneralsRanks(generalsForm.getGeneralsRanks());
        service.update(generals);
        return "redirect:/ui/Generals/get/all";
    }
}
