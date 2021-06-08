package com.example.coursework.controller.ui;

import com.example.coursework.forms.MachinesGunsForm;
import com.example.coursework.forms.ObjForm;
import com.example.coursework.forms.TransportEquipmentForm;
import com.example.coursework.model.FreightCar;
import com.example.coursework.model.Obj;
import com.example.coursework.model.Tractor;
import com.example.coursework.model.TransportEquipment;
import com.example.coursework.repository.FreightCar.FreightCarRepository;
import com.example.coursework.repository.Tractor.TractorRepository;
import com.example.coursework.repository.TransportEquipment.TransportEquipmentRepository;
import com.example.coursework.service.FreightCar.Impls.FreightCarServiceImpls;
import com.example.coursework.service.FreightCar.Interfaces.FreightCarService;
import com.example.coursework.service.Obj.Impls.ObjServiceImpls;
import com.example.coursework.service.Tractor.Impls.TractorServiceImpls;
import com.example.coursework.service.TransportEquipment.Impls.TransportEquipmentServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping(value = "/ui/TransportEquip")
@Controller
public class TransportEquipmentUIController {

    @Autowired
    TransportEquipmentServiceImpls service;

    @Autowired
    FreightCarServiceImpls freightCarServiceImpls;

    @Autowired
    TractorServiceImpls tractorServiceImpls;

    @Autowired
    TransportEquipmentRepository repository;

    @Autowired
    FreightCarRepository carRepository;

    @Autowired
    TractorRepository tractorRepository;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<TransportEquipment> transportEquipments = service.getAll();
        model.addAttribute("transportEquipments", transportEquipments);
        //  model.addAttribute("items", service.getAll());
        return "transportEquipments/transportEquipments-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/TransportEquip/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){

        TransportEquipmentForm form = new TransportEquipmentForm();
        form.setFreightCar("");
        form.setNumberOfFreightCar("");
        form.setTractor("");
        form.setNumberOfTractor("");
        form.setTotalTransportEquipment("");

        model.addAttribute("form", form);

        List<String> freightCar = carRepository.findAll()
                .stream()
                .map(FreightCar::getName)
                .collect(Collectors.toList());

        model.addAttribute("freightCar", freightCar);

        List<String> tractor = tractorRepository.findAll()
                .stream()
                .map(Tractor::getName)
                .collect(Collectors.toList());
        model.addAttribute("tractor",tractor);



        return "transportEquipments/transportEquipments-create";
    }
    @PostMapping(value = "create")
    public String create(Model model,
                         @ModelAttribute("form") TransportEquipmentForm form){

        TransportEquipment equipment = new TransportEquipment();

        String fcname = form.getFreightCar();
        FreightCar freightCar = freightCarServiceImpls.getByName(form.getFreightCar());
        equipment.setFreightCar(freightCar);

        equipment.setNumberOfFreightCar(Integer.parseInt(form.getNumberOfFreightCar()));

        String tractorname = form.getTractor();
        Tractor tractor = tractorServiceImpls.getByName(form.getTractor());
        equipment.setTractor(tractor);

        equipment.setNumberOfTractor(Integer.parseInt(form.getNumberOfTractor()));
        equipment.setTotalTransportEquipment(form.getTotalTransportEquipment());

        service.create(equipment);

        return "redirect:/ui/TransportEquip/get/all";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){

        TransportEquipmentForm forms = new TransportEquipmentForm();
        forms.setId(id);

        String freightCars = repository.findById(id)
                .get().getFreightCar().getName();

        forms.setNumberOfFreightCar(String.valueOf(repository.findById(id).get().getNumberOfFreightCar()));

        String tractors = repository.findById(id)
                .get().getTractor().getName();

        forms.setFreightCar(freightCars);
        forms.setTractor(tractors);

        forms.setNumberOfTractor(String.valueOf(repository.findById(id).get().getNumberOfTractor()));
        forms.setTotalTransportEquipment(String.valueOf(repository.findById(id).get().getTotalTransportEquipment()));
        model.addAttribute("forms", forms);

        List<String> freightCar = carRepository.findAll()
                .stream()
                .map(FreightCar::getName)
                .collect(Collectors.toList());

        model.addAttribute("freightCar", freightCar);

        List<String> tractor = tractorRepository.findAll()
                .stream()
                .map(Tractor::getName)
                .collect(Collectors.toList());
        model.addAttribute("tractor", tractor);


        return "transportEquipments/transportEquipments-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") TransportEquipmentForm form,
                              @PathVariable("id") String id){

        TransportEquipment equipment = new TransportEquipment();
        equipment.setId(form.getId());

        String fcname = form.getFreightCar();
        FreightCar freightCar = freightCarServiceImpls.getByName(form.getFreightCar());
        equipment.setFreightCar(freightCar);

        equipment.setNumberOfFreightCar(Integer.parseInt(form.getNumberOfFreightCar()));

        String tractorname = form.getTractor();
        Tractor tractor = tractorServiceImpls.getByName(form.getTractor());
        equipment.setTractor(tractor);

        equipment.setNumberOfTractor(Integer.parseInt(form.getNumberOfTractor()));
        equipment.setTotalTransportEquipment(form.getTotalTransportEquipment());




        service.update(equipment);
        return "redirect:/ui/TransportEquip/get/all";
    }

}
