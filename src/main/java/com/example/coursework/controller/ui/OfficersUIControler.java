package com.example.coursework.controller.ui;

import com.example.coursework.forms.OfficerForm;
import com.example.coursework.model.Officers;
import com.example.coursework.model.OfficersRanks;
import com.example.coursework.service.Officers.Impls.OfficersServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by IntelliJ IDEA.
 * course.StudentUIControler
 *
 * @Autor: Andrey
 * @DateTime: 06.03.2021|17:15
 * @Version: StudentUIControler: 1.0
 */
@RequestMapping(value = "/ui/Officers")
@Controller
public class OfficersUIControler {
    @Autowired
    OfficersServiceImpls service;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<Officers> officers = service.getAll();
        model.addAttribute("officers", officers);
        //  model.addAttribute("items", service.getAll());
        return "officer/officers-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/Officers/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        OfficerForm officerForm = new OfficerForm();
        model.addAttribute("form", officerForm);
        List<String> officersRanks  = new ArrayList(
                Arrays.asList(OfficersRanks.values())
        );
        model.addAttribute("officersRanks", officersRanks);
        return "officer/officer-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("officerForm") OfficerForm officerForm){
        Officers officer = new Officers();
        officer.setName(officerForm.getName());
        officer.setbDay(officerForm.getbDay());
        officer.setSpeciality(officerForm.getSpeciality());
        officer.setDateOfAssignmentOfAnOfficerRank(officerForm.getDateOfAssignmentOfAnOfficerRank());
        officer.setAwards(officerForm.getAwards());
        officer.setOfficersRanks(officerForm.getOfficersRanks());
        service.create(officer);
        return "redirect:/ui/Officers/get/all";
    }
    /*
    @GetMapping(value = "appdate")
    public String appdate(Model model){
        OfficerForm officerForm = new OfficerForm();
        model.addAttribute("form", officerForm);
        List<String> officersRanks  = new ArrayList(
                Arrays.asList(OfficersRanks.values())
        );
        model.addAttribute("officersRanks", officersRanks);
        return "officer/officer-appdate";
    }
    @PostMapping(value = "appdate")
    public String appdate( @ModelAttribute("officerForm") OfficerForm officerForm){
        Officers officer = new Officers();
        officer.setName(officerForm.getName());
        officer.setbDay(LocalDate.parse(officerForm.getbDay()));
        officer.setSpeciality(officerForm.getSpeciality());
        officer.setDateOfAssignmentOfAnOfficerRank(LocalDate.parse(officerForm.getDateOfAssignmentOfAnOfficerRank()));
        officer.setAwards(officerForm.getAwards());
        officer.setOfficersRanks(OfficersRanks.valueOf(officerForm.getOfficersRanks()));
        service.create(officer);
        return "redirect:/ui/Officers/get/all";
    }
     */
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        Officers officers = service.getById(id);
        OfficerForm officerForm = new OfficerForm();
        officerForm.setId(id);
        officerForm.setName(officers.getName());
        //officerForm.setbDay(officers.getbDay());
        officerForm.setbDay(officers.getbDay());
        officerForm.setSpeciality(officers.getSpeciality());
        officerForm.setDateOfAssignmentOfAnOfficerRank(officers.getDateOfAssignmentOfAnOfficerRank());
        officerForm.setAwards(officers.getAwards());
        officerForm.setOfficersRanks(officers.getOfficersRanks());
        model.addAttribute("form", officerForm);
        List<String> officersRanks  = new ArrayList(
                Arrays.asList(OfficersRanks.values())
        );
        model.addAttribute("officersRanks", officersRanks);
        return "officer/officer-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") OfficerForm officerForm,
                              @PathVariable("id") String id){
        Officers officer = new Officers();
        officer.setId(officerForm.getId());
        officer.setName(officerForm.getName());
        officer.setbDay(officerForm.getbDay());
        officer.setSpeciality(officerForm.getSpeciality());
        officer.setDateOfAssignmentOfAnOfficerRank(officerForm.getDateOfAssignmentOfAnOfficerRank());
        officer.setAwards(officerForm.getAwards());
        officer.setOfficersRanks(officerForm.getOfficersRanks());
        service.update(officer);
        return "redirect:/ui/Officers/get/all";
    }
}
