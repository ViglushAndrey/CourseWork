package com.example.coursework.controller.ui;

import com.example.coursework.forms.ArmamentForm;
import com.example.coursework.forms.OfficerForm;
import com.example.coursework.model.*;
import com.example.coursework.repository.Armament.ArmamentRepository;
import com.example.coursework.repository.Automats.AutomatsRepository;
import com.example.coursework.repository.Grenades.GrenadesRepository;
import com.example.coursework.repository.MachinesGuns.MachinesGunsRepository;
import com.example.coursework.repository.MilitaryEquipment.MilitaryEquipmentRepository;
import com.example.coursework.repository.Pistols.PistolsRepository;
import com.example.coursework.repository.SniperRifles.SniperRiflesRepository;
import com.example.coursework.repository.TransportEquipment.TransportEquipmentRepository;
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
        ArmamentForm form = new ArmamentForm();

        form.setGrenades("");
        form.setPistols("");
        form.setSniperRifles("");
        form.setMachinesGuns("");
        form.setAutomats("");
        form.setMilitaryEquipment("");
        form.setTransportEquipment("");

        model.addAttribute("form", form);

        List<String> grenades = grenadesService.getAll()
                .stream()
                .map(Grenades::getModel)
                .collect(Collectors.toList());
        model.addAttribute("grenades",grenades);

        List<String> pistols = pistolsService.getAll()
                .stream()
                .map(Pistols::getModel)
                .collect(Collectors.toList());
        model.addAttribute("pistols",pistols);

        List<String> sniperRifles = sniperRiflesService.getAll()
                .stream()
                .map(SniperRifles::getModel)
                .collect(Collectors.toList());
        model.addAttribute("sniperRifles",sniperRifles);

        List<String> machinesGuns = machinesGunsService.getAll()
                .stream()
                .map(MachinesGuns::getModel)
                .collect(Collectors.toList());
        model.addAttribute("machinesGuns",machinesGuns);

        List<String> automats = automatsService.getAll()
                .stream()
                .map(Automats::getModel)
                .collect(Collectors.toList());
        model.addAttribute("automats",automats);

        List<String> militaryEquipment = militaryEquipmentService.getAll()
                .stream()
                .map(MilitaryEquipment::getTotalMilitaryEquipment)
                .collect(Collectors.toList());
        model.addAttribute("militaryEquipment",militaryEquipment);

        List<String> transportEquipment = transportEquipmentService.getAll()
                .stream()
                .map(TransportEquipment::getTotalTransportEquipment)
                .collect(Collectors.toList());
        model.addAttribute("transportEquipment",transportEquipment);

        return "armament/armament-create";
    }
    @PostMapping(value = "create")
    public String create(Model model, @ModelAttribute("form") ArmamentForm form){

        Armament armament =new Armament();
        armament.setId(form.getId());

        String grenadesname = form.getGrenades();
        Grenades grenades = grenadesService.getByName(form.getGrenades());
        armament.setGrenades(grenades);

        String pistolsName = form.getPistols();
        Pistols pistols = pistolsService.getByName(form.getPistols());
        armament.setPistols(pistols);

        String sniperRiflesName = form.getSniperRifles();
        SniperRifles sniperRifles = sniperRiflesService.getByName(form.getSniperRifles());
        armament.setSniperRifles(sniperRifles);

        String machinesGunsname = form.getMachinesGuns();
        MachinesGuns machinesGuns = machinesGunsService.getByName(form.getMachinesGuns());
        armament.setMachinesGuns(machinesGuns);

        String automatsname = form.getMilitaryEquipment();
        Automats automats = automatsService.getByName(form.getAutomats());
        armament.setAutomats(automats);

        String milEq = form.getMilitaryEquipment();
        MilitaryEquipment militaryEquipment = militaryEquipmentService.getMilitEq(form.getMilitaryEquipment());
        armament.setMilitaryEquipment(militaryEquipment);

        String transEq = form.getTransportEquipment();
        TransportEquipment transportEquipment = transportEquipmentService.getTransEq(form.getTransportEquipment());
        armament.setTransportEquipment(transportEquipment);

               service.create(armament);
        model.addAttribute("armament", service.getAll());
        return "redirect:/ui/Armament/get/all";
    }


    @Autowired
    ArmamentRepository repository;

    @Autowired
    AutomatsRepository automatsRepository;

    @Autowired
    GrenadesRepository grenadesRepository;

    @Autowired
    PistolsRepository pistolsRepository;

    @Autowired
    SniperRiflesRepository riflesRepository;

    @Autowired
    MachinesGunsRepository machinesGunsRepository;

    @Autowired
    TransportEquipmentRepository transportEquipmentRepository;

    @Autowired
    MilitaryEquipmentRepository militaryEquipmentRepository;


   @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){

        ArmamentForm form = new ArmamentForm();
        form.setId(id);

       String grenades = repository.findById(id)
               .get().getGrenades().getModel();

       String pistols = repository.findById(id)
               .get().getPistols().getModel();

       String sniperRifles = repository.findById(id)
               .get().getSniperRifles().getModel();

       String machinesGuns = repository.findById(id)
               .get().getMachinesGuns().getModel();

       String  automats = repository.findById(id)
               .get().getAutomats().getModel();

       String  militaryEq = repository.findById(id)
               .get().getMilitaryEquipment().getTotalMilitaryEquipment();

       String transEq = repository.findById(id)
               .get().getTransportEquipment().getTotalTransportEquipment();

       form.setGrenades(grenades);
       form.setPistols(pistols);
       form.setSniperRifles(sniperRifles);
       form.setMachinesGuns(machinesGuns);
       form.setAutomats(automats);
       form.setMilitaryEquipment(String.valueOf(militaryEq));
       form.setTransportEquipment(String.valueOf(transEq));

       model.addAttribute("formUpd", form);

       List<String> grenade = grenadesService.getAll()
               .stream()
               .map(Grenades::getModel)
               .collect(Collectors.toList());
       model.addAttribute("grenade",grenade);

       List<String> pistol = pistolsService.getAll()
               .stream()
               .map(Pistols::getModel)
               .collect(Collectors.toList());
       model.addAttribute("pistol",pistol);

       List<String> sniperRifle = sniperRiflesService.getAll()
               .stream()
               .map(SniperRifles::getModel)
               .collect(Collectors.toList());
       model.addAttribute("sniperRifle",sniperRifle);

       List<String> machinesGun = machinesGunsService.getAll()
               .stream()
               .map(MachinesGuns::getModel)
               .collect(Collectors.toList());
       model.addAttribute("machinesGun",machinesGun);

       List<String> automat = automatsService.getAll()
               .stream()
               .map(Automats::getModel)
               .collect(Collectors.toList());
       model.addAttribute("automat",automat);

       List<String> militaryEquipment = militaryEquipmentService.getAll()
               .stream()
               .map(MilitaryEquipment::getTotalMilitaryEquipment)
               .collect(Collectors.toList());
       model.addAttribute("militaryEquipment",militaryEquipment);

       List<String> transportEquipment = transportEquipmentService.getAll()
               .stream()
               .map(TransportEquipment::getTotalTransportEquipment)
               .collect(Collectors.toList());
       model.addAttribute("transportEquipment",transportEquipment);

        return "armament/armament-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") ArmamentForm form,
                              @PathVariable("id") String id){

        Armament armament =new Armament();
        armament.setId(form.getId());

        String grenadesname = form.getGrenades();
        Grenades grenades = grenadesService.getByName(form.getGrenades());
        armament.setGrenades(grenades);

        String pistolsName = form.getPistols();
        Pistols pistols = pistolsService.getByName(form.getPistols());
        armament.setPistols(pistols);

        String sniperRiflesName = form.getSniperRifles();
        SniperRifles sniperRifles = sniperRiflesService.getByName(form.getSniperRifles());
        armament.setSniperRifles(sniperRifles);

        String machinesGunsname = form.getMachinesGuns();
        MachinesGuns machinesGuns = machinesGunsService.getByName(form.getMachinesGuns());
        armament.setMachinesGuns(machinesGuns);

        String automatsname = form.getMilitaryEquipment();
        Automats automats = automatsService.getByName(form.getAutomats());
        armament.setAutomats(automats);

        String milEq = form.getMilitaryEquipment();
        MilitaryEquipment militaryEquipment = militaryEquipmentService.getMilitEq(form.getMilitaryEquipment());
        armament.setMilitaryEquipment(militaryEquipment);

        String transEq = form.getTransportEquipment();
        TransportEquipment transportEquipment = transportEquipmentService.getTransEq(form.getTransportEquipment());
        armament.setTransportEquipment(transportEquipment);

        service.update(armament);
        return "redirect:/ui/Armament/get/all";
    }
}
