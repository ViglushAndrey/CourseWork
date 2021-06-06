package com.example.coursework.controller.ui;

import com.example.coursework.forms.OfficerForm;
import com.example.coursework.forms.SerguantsForm;
import com.example.coursework.model.Officers;
import com.example.coursework.model.OfficersRanks;
import com.example.coursework.model.Serguants;
import com.example.coursework.model.SerguantsRanks;
import com.example.coursework.service.Serguants.Impls.SerguantsServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping(value = "/ui/Serguants")
@Controller
public class SerguantsUIController {
    @Autowired
    SerguantsServiceImpls service;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<Serguants> serguants = service.getAll();
        model.addAttribute("serguants", serguants);
        //  model.addAttribute("items", service.getAll());
        return "serguant/serguants-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/Serguants/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        SerguantsForm serguantsForm = new SerguantsForm();
        model.addAttribute("form", serguantsForm);
        List<String> serguantsRanks  = new ArrayList(
                Arrays.asList(SerguantsRanks.values())
        );
        model.addAttribute("serguantsRanks", serguantsRanks);
        return "serguant/serguant-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("serguantForm") SerguantsForm serguantForm){
        Serguants serguants = new Serguants();
        serguants.setName(serguantForm.getName());
        serguants.setbDay(serguantForm.getbDay());
        serguants.setSpeciality(serguantForm.getSpeciality());
        serguants.setDateOfAssignmentOfAnOfficerRank(serguantForm.getDateOfAssignmentOfAnOfficerRank());
        serguants.setAwards(serguantForm.getAwards());
        serguants.setSerguantsRanks(serguantForm.getSerguantsRanks());
        service.create(serguants);
        return "redirect:/ui/Serguants/get/all";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        Serguants serguants = service.getById(id);
        SerguantsForm serguantForm = new SerguantsForm();
        serguantForm.setId(id);
        serguantForm.setName(serguants.getName());
        //officerForm.setbDay(officers.getbDay());
        serguantForm.setbDay(serguants.getbDay());
        serguantForm.setSpeciality(serguants.getSpeciality());
        serguantForm.setDateOfAssignmentOfAnOfficerRank(serguants.getDateOfAssignmentOfAnOfficerRank());
        serguantForm.setAwards(serguants.getAwards());
        serguantForm.setSerguantsRanks(serguants.getSerguantsRanks());
        model.addAttribute("form", serguantForm);
        List<String> serguantsRanks  = new ArrayList(
                Arrays.asList(SerguantsRanks.values())
        );
        model.addAttribute("serguantsRanks", serguantsRanks);
        return "serguant/serguant-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") SerguantsForm serguantForm,
                              @PathVariable("id") String id){
        Serguants serguants = new Serguants();
        serguants.setId(serguantForm.getId());
        serguants.setName(serguantForm.getName());
        serguants.setbDay(serguantForm.getbDay());
        serguants.setSpeciality(serguantForm.getSpeciality());
        serguants.setDateOfAssignmentOfAnOfficerRank(serguantForm.getDateOfAssignmentOfAnOfficerRank());
        serguants.setAwards(serguantForm.getAwards());
        serguants.setSerguantsRanks(serguantForm.getSerguantsRanks());
        service.update(serguants);
        return "redirect:/ui/Serguants/get/all";
    }
}
