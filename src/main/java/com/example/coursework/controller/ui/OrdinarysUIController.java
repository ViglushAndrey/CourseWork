package com.example.coursework.controller.ui;

import com.example.coursework.forms.OfficerForm;
import com.example.coursework.forms.OrdinaryForm;
import com.example.coursework.model.Officers;
import com.example.coursework.model.OfficersRanks;
import com.example.coursework.model.OrdinaryRanks;
import com.example.coursework.model.Ordinarys;
import com.example.coursework.service.Ordinarys.Impls.OrdinarysServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping(value = "/ui/Ordinarys")
@Controller
public class OrdinarysUIController {

    @Autowired
    OrdinarysServiceImpls service;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<Ordinarys> ordinarys = service.getAll();
        model.addAttribute("ordinarys", ordinarys);
        //  model.addAttribute("items", service.getAll());
        return "ordinarys/ordinarys-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/Ordinarys/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        OrdinaryForm ordinaryForm = new OrdinaryForm();
        model.addAttribute("form", ordinaryForm);
        List<String> ordinaryRanks  = new ArrayList(
                Arrays.asList(OrdinaryRanks.values())
        );
        model.addAttribute("ordinaryRanks", ordinaryRanks);
        return "ordinarys/ordinarys-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("ordinaryForm") OrdinaryForm ordinaryForm){
        Ordinarys ordinarys = new Ordinarys();
        ordinarys.setName(ordinaryForm.getName());
        ordinarys.setbDay(ordinaryForm.getbDay());
        ordinarys.setSpeciality(ordinaryForm.getSpeciality());
        ordinarys.setDateOfAssignmentOfAnOfficerRank(ordinaryForm.getDateOfAssignmentOfAnOfficerRank());
        ordinarys.setAwards(ordinaryForm.getAwards());
        ordinarys.setOrdinaryRanks(ordinaryForm.getOrdinaryRanks());
        service.create(ordinarys);
        return "redirect:/ui/Ordinarys/get/all";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        Ordinarys ordinarys = service.getById(id);
        OrdinaryForm ordinaryForm = new OrdinaryForm();
        ordinaryForm.setId(id);
        ordinaryForm.setName(ordinarys.getName());
        //officerForm.setbDay(officers.getbDay());
        ordinaryForm.setbDay(ordinarys.getbDay());
        ordinaryForm.setSpeciality(ordinarys.getSpeciality());
        ordinaryForm.setDateOfAssignmentOfAnOfficerRank(ordinarys.getDateOfAssignmentOfAnOfficerRank());
        ordinaryForm.setAwards(ordinarys.getAwards());
        ordinaryForm.setOrdinaryRanks(ordinarys.getOrdinaryRanks());
        model.addAttribute("form", ordinaryForm);
        List<String> ordinaryRanks  = new ArrayList(
                Arrays.asList(OrdinaryRanks.values())
        );
        model.addAttribute("ordinaryRanks", ordinaryRanks);
        return "ordinarys/ordinary-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") OrdinaryForm ordinaryForm,
                              @PathVariable("id") String id){
        Ordinarys ordinarys = new Ordinarys();
        ordinarys.setId(ordinaryForm.getId());
        ordinarys.setName(ordinaryForm.getName());
        ordinarys.setbDay(ordinaryForm.getbDay());
        ordinarys.setSpeciality(ordinaryForm.getSpeciality());
        ordinarys.setDateOfAssignmentOfAnOfficerRank(ordinaryForm.getDateOfAssignmentOfAnOfficerRank());
        ordinarys.setAwards(ordinaryForm.getAwards());
        ordinarys.setOrdinaryRanks(ordinaryForm.getOrdinaryRanks());
        service.update(ordinarys);
        return "redirect:/ui/Ordinarys/get/all";
    }
}
