package com.example.coursework.controller.ui;

import com.example.coursework.forms.ArmamentForm;
import com.example.coursework.forms.OfficerForm;
import com.example.coursework.model.*;
import com.example.coursework.service.Armament.Impls.ArmamentServiceImpls;
import com.example.coursework.service.Automats.Impls.AutomatsServiceImpls;
import com.example.coursework.service.Grenades.Impls.GrenadesServiceImpls;
import com.example.coursework.service.MachinesGuns.Impls.MachinesGunsServiceImpls;
import com.example.coursework.service.MilitaryEquipment.Impls.MilitaryEquipmentServiceImpls;
import com.example.coursework.service.Pistols.Impls.PistolsServiceImpls;
import com.example.coursework.service.SniperRifles.Impls.SniperRiflesServiceImpls;
import com.example.coursework.service.TransportEquipment.Impls.TransportEquipmentServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
@RequestMapping(value = "/ui/Armament")
@Controller
public class ArmamentUIController {

    @Autowired
    ArmamentServiceImpls service;

    @Autowired
    AutomatsServiceImpls automatsService;

    @Autowired
    GrenadesServiceImpls grenadesService;

    @Autowired
    PistolsServiceImpls pistolsService;

    @Autowired
    SniperRiflesServiceImpls sniperRiflesService;

    @Autowired
    MachinesGunsServiceImpls machinesGunsService;

    @Autowired
    MilitaryEquipmentServiceImpls militaryEquipmentService;

    @Autowired
    TransportEquipmentServiceImpls transportEquipmentService;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<Armament> armaments = service.getAll();
        model.addAttribute("armaments", armaments);
        //  model.addAttribute("items", service.getAll());
        return "armament/armament-page";
    }
   @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/Armament/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        ArmamentForm armamentForm = new ArmamentForm();

        Map<String,String> mavsG = grenadesService.getAll().stream()
                .collect(Collectors.toMap(Grenades::getId, Grenades::getModel));
        model.addAttribute("mavsG", mavsG);

        Map<String,String> mavsP = pistolsService.getAll().stream()
                .collect(Collectors.toMap(Pistols::getId, Pistols::getModel));
        model.addAttribute("mavsP", mavsP);

        Map<String,String> mavsSR = sniperRiflesService

        Map<String, String> mavs = automatsService.getAll().stream()
                .collect(Collectors.toMap(Automats::getId, Automats::getModel));
        model.addAttribute("mavs", mavs);

        model.addAttribute("form", armamentForm);
        return "armament/armament-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("officerForm") OfficerForm officerForm){
        Armament armament = new Armament();
        armament.setGrenades();
        service.create(officer);
        return "redirect:/ui/Armament/get/all";
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
/*
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
        return "armament/armament-appdate";
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
}*/
