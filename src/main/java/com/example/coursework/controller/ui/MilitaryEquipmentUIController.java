package com.example.coursework.controller.ui;


import com.example.coursework.forms.MilitaryEquipmentForm;
import com.example.coursework.forms.TransportEquipmentForm;
import com.example.coursework.model.*;
import com.example.coursework.repository.BMP.BMPRepository;
import com.example.coursework.repository.BTR.BTRRepository;
import com.example.coursework.repository.FreightCar.FreightCarRepository;
import com.example.coursework.repository.MilitaryEquipment.MilitaryEquipmentRepository;
import com.example.coursework.repository.Tanks.TanksRepository;
import com.example.coursework.repository.Tractor.TractorRepository;
import com.example.coursework.repository.TransportEquipment.TransportEquipmentRepository;
import com.example.coursework.service.BMP.Impls.BMPServiceImpls;
import com.example.coursework.service.BTR.Impls.BTRServiceImpls;
import com.example.coursework.service.FreightCar.Impls.FreightCarServiceImpls;
import com.example.coursework.service.MilitaryEquipment.Impls.MilitaryEquipmentServiceImpls;
import com.example.coursework.service.Tanks.Impls.TanksServiceImpls;
import com.example.coursework.service.Tractor.Impls.TractorServiceImpls;
import com.example.coursework.service.TransportEquipment.Impls.TransportEquipmentServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/ui/MilitaryEquipment")
@Controller
public class MilitaryEquipmentUIController {

    @Autowired
    MilitaryEquipmentServiceImpls service;

    @Autowired
    TanksServiceImpls tanksServiceImpls;

    @Autowired
    BMPServiceImpls bmpServiceImpls;

    @Autowired
    BTRServiceImpls btrServiceImpls;

    @Autowired
    MilitaryEquipmentRepository repository;

    @Autowired
    TanksRepository tanksRepository;

    @Autowired
    BMPRepository bmpRepository;

    @Autowired
    BTRRepository btrRepository;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<MilitaryEquipment> militaryEquipments = service.getAll();
        model.addAttribute("militaryEquipments", militaryEquipments);
        //  model.addAttribute("items", service.getAll());
        return "militaryEquipments/militaryEquipments-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/MilitaryEquipment/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){

        MilitaryEquipmentForm form = new MilitaryEquipmentForm();
        form.setTanks("");
        form.setNumberOfTanks("");
        form.setBmp("");
        form.setNumberOfBmp("");
        form.setBtr("");
        form.setNumberOfBtr("");
        form.setTotalMilitaryEquipment("");

        model.addAttribute("form", form);

        List<String> tanks = tanksRepository.findAll()
                .stream()
                .map(Tanks::getName)
                .collect(Collectors.toList());

        model.addAttribute("tanks", tanks);


        List<String> bmp = bmpRepository.findAll()
                .stream()
                .map(BMP::getName)
                .collect(Collectors.toList());

        model.addAttribute("bmp", bmp);

        List<String> btr = btrRepository.findAll()
                .stream()
                .map(BTR::getName)
                .collect(Collectors.toList());
        model.addAttribute("btr",btr);



        return "militaryEquipments/militaryEquipments-create";
    }
    @PostMapping(value = "create")
    public String create(Model model,
                         @ModelAttribute("form") MilitaryEquipmentForm form){

        MilitaryEquipment equipment = new MilitaryEquipment();

        String tankname = form.getTanks();
        Tanks tanks = tanksServiceImpls.getByName(form.getTanks());
        equipment.setTanks(tanks);

        equipment.setNumberOfTanks(Integer.parseInt(form.getNumberOfTanks()));

        String btrname = form.getBtr();
        BTR btr = btrServiceImpls.getByName(form.getBtr());
        equipment.setBtr(btr);

        equipment.setNumberOfBtr(Integer.parseInt(form.getNumberOfBtr()));

        String bmpname = form.getBmp();
        BMP bmp = bmpServiceImpls.getByName(form.getBmp());
        equipment.setBmp(bmp);

        equipment.setNumberOfBmp(Integer.parseInt(form.getNumberOfBmp()));
        equipment.setTotalMilitaryEquipment(form.getTotalMilitaryEquipment());

        service.create(equipment);

        return "redirect:/ui/MilitaryEquipment/get/all";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){

        MilitaryEquipmentForm forms = new MilitaryEquipmentForm();
        forms.setId(id);

        String tanksname = repository.findById(id)
                .get().getTanks().getName();

        forms.setNumberOfTanks(String.valueOf(repository.findById(id).get().getNumberOfTanks()));

        String btrname = repository.findById(id)
                .get().getBtr().getName();

        String bmpname = repository.findById(id)
                .get().getBmp().getName();

        forms.setBtr(btrname);
        forms.setTanks(tanksname);
        forms.setBmp(bmpname);

        forms.setNumberOfBmp(String.valueOf(repository.findById(id).get().getNumberOfBmp()));
        forms.setNumberOfBtr(String.valueOf(repository.findById(id).get().getNumberOfBtr()));
        forms.setTotalMilitaryEquipment(String.valueOf(repository.findById(id).get().getTotalMilitaryEquipment()));
        model.addAttribute("forms", forms);

        List<String> tanks = tanksRepository.findAll()
                .stream()
                .map(Tanks::getName)
                .collect(Collectors.toList());

        model.addAttribute("tanks", tanks);

        List<String> btr = btrRepository.findAll()
                .stream()
                .map(BTR::getName)
                .collect(Collectors.toList());
        model.addAttribute("btr", btr);

        List<String> bmp = bmpRepository.findAll()
                .stream()
                .map(BMP::getName)
                .collect(Collectors.toList());
        model.addAttribute("bmp", bmp);


        return "militaryEquipments/militaryEquipments-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") MilitaryEquipmentForm form,
                              @PathVariable("id") String id){

        MilitaryEquipment equipment = new MilitaryEquipment();
        equipment.setId(form.getId());

        String tankname = form.getTanks();
        Tanks tanks = tanksServiceImpls.getByName(form.getTanks());
        equipment.setTanks(tanks);

        equipment.setNumberOfTanks(Integer.parseInt(form.getNumberOfTanks()));

        String btrname = form.getBtr();
        BTR btr = btrServiceImpls.getByName(form.getBtr());
        equipment.setBtr(btr);

        equipment.setNumberOfBtr(Integer.parseInt(form.getNumberOfBtr()));


        String bmpname = form.getBmp();
        BMP bmp = bmpServiceImpls.getByName(form.getBmp());
        equipment.setBmp(bmp);

        equipment.setNumberOfBmp(Integer.parseInt(form.getNumberOfBmp()));
        equipment.setTotalMilitaryEquipment(form.getTotalMilitaryEquipment());




        service.update(equipment);
        return "redirect:/ui/MilitaryEquipment/get/all";
    }

}
