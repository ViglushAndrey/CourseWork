package com.example.coursework.controller.ui;


import com.example.coursework.forms.DepartamentForm;
import com.example.coursework.forms.ObjForm;
import com.example.coursework.model.*;
import com.example.coursework.repository.Departament.DepartamentRepository;
import com.example.coursework.repository.MilitaryEquipment.MilitaryEquipmentRepository;
import com.example.coursework.repository.Obj.ObjRepository;
import com.example.coursework.repository.Ordinarys.OrdinarysRepository;
import com.example.coursework.repository.PermamentDislocation.PermamentDislocationRepository;
import com.example.coursework.repository.TemproraryDislocation.TemproraryDislocationRepository;
import com.example.coursework.repository.TransportEquipment.TransportEquipmentRepository;
import com.example.coursework.service.Departament.Impls.DepartamentServiceImpls;
import com.example.coursework.service.MilitaryEquipment.Impls.MilitaryEquipmentServiceImpls;
import com.example.coursework.service.Obj.Impls.ObjServiceImpls;
import com.example.coursework.service.Ordinarys.Impls.OrdinarysServiceImpls;
import com.example.coursework.service.PermamentDislocation.Impls.PermamentDislocationServiceImpls;
import com.example.coursework.service.TemproraryDislocation.Impls.TemproraryDislocationServiceImpls;
import com.example.coursework.service.TransportEquipment.Impls.TransportEquipmentServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/ui/Departament")
@Controller
public class DepartamentUIController {

    @Autowired
    DepartamentServiceImpls service;

    @Autowired
    OrdinarysServiceImpls ordinarysService;

    @Autowired
    ObjServiceImpls objService;

    @Autowired
    PermamentDislocationServiceImpls permamentDislocationService;

    @Autowired
    TemproraryDislocationServiceImpls temproraryDislocationService;

    @Autowired
    TransportEquipmentServiceImpls transportEquipmentService;

    @Autowired
    MilitaryEquipmentServiceImpls militaryEquipmentService;


    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<Department> departments = service.getAll();
        model.addAttribute("departments", departments);
        //  model.addAttribute("items", service.getAll());
        return "department/department-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/Departament/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        DepartamentForm form = new DepartamentForm();

        form.setName("");
        form.setPersonnel("");
        form.setOrdinarys("");
        form.setObj("");
        form.setPermanentDislocation("");
        form.setTemporaryDislocation("");
        form.setTransportEquipment("");
        form.setMilitaryEquipment("");

        model.addAttribute("form", form);

        List<String> ordinarys = ordinarysService.getAll()
                .stream()
                .map(Ordinarys::getName)
                .collect(Collectors.toList());
        model.addAttribute("ordinarys",ordinarys);

        List<String> obj = objService.getAll()
                .stream()
                .map(Obj::getTypesOfBuildings)
                .collect(Collectors.toList());
        model.addAttribute("obj",obj);

        List<String> permdisloc = permamentDislocationService.getAll()
                .stream()
                .map(PermanentDislocation::getPermanentDislocation)
                .collect(Collectors.toList());
        model.addAttribute("permdisloc",permdisloc);

        List<String> tempdisloc = temproraryDislocationService.getAll()
                .stream()
                .map(TemporaryDislocation::getTemporaryDislocation)
                .collect(Collectors.toList());
        model.addAttribute("tempdisloc",tempdisloc);

        List<String> transportEq = transportEquipmentService.getAll()
                .stream()
                .map(TransportEquipment::getTotalTransportEquipment)
                .collect(Collectors.toList());
        model.addAttribute("transportEq",transportEq);

        List<String> militaryEq = militaryEquipmentService.getAll()
                .stream()
                .map(MilitaryEquipment::getTotalMilitaryEquipment)
                .collect(Collectors.toList());
        model.addAttribute("militaryEq",militaryEq);


        return "department/department-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("form") DepartamentForm form){

        Department department = new Department();
        department.setId(form.getId());
        department.setPersonnel(Integer.parseInt(form.getPersonnel()));

        String ordinarysName = form.getOrdinarys();
        Ordinarys ordinarys = ordinarysService.getByName(form.getOrdinarys());
        department.setOrdinarys(ordinarys);

        String objName = form.getObj();
        Obj obj = objService.getByTypes(form.getObj());
        department.setObj(obj);

        String permDis = form.getPermanentDislocation();
        PermanentDislocation permanentDislocation = permamentDislocationService.getByPermDisloc(form.getPermanentDislocation());
        department.setPermanentDislocation(permanentDislocation);

        String tempDis = form.getTemporaryDislocation();
        TemporaryDislocation temporaryDislocation = temproraryDislocationService.getTempDisloc(form.getTemporaryDislocation());
        department.setTemporaryDislocation(temporaryDislocation);

        String transEq = form.getTransportEquipment();
        TransportEquipment transportEquipment = transportEquipmentService.getTransEq(form.getTransportEquipment());
        department.setTransportEquipment(transportEquipment);

        String milEq = form.getMilitaryEquipment();
        MilitaryEquipment militaryEquipment = militaryEquipmentService.getMilitEq(form.getMilitaryEquipment());
        department.setMilitaryEquipment(militaryEquipment);




        service.create(department);

        return "redirect:/ui/Departament/get/all";
    }


    @Autowired
    DepartamentRepository repository;

    @Autowired
    OrdinarysRepository ordinarysRepository;

    @Autowired
    ObjRepository objRepository;

    @Autowired
    PermamentDislocationRepository permamentDislocationRepository;

    @Autowired
    TemproraryDislocationRepository temproraryDislocationRepository;

    @Autowired
    TransportEquipmentRepository transportEquipmentRepository;

    @Autowired
    MilitaryEquipmentRepository militaryEquipmentRepository;



    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){

        DepartamentForm form = new DepartamentForm();
        form.setId(id);
        form.setName(repository.findById(id).get().getName());
        form.setPersonnel(String.valueOf(repository.findById(id).get().getPersonnel()));

        String ordinary = repository.findById(id)
                .get().getOrdinarys().getName();

        String obj = repository.findById(id)
                .get().getObj().getTypesOfBuildings();

        String perDis = repository.findById(id)
                .get().getPermanentDislocation().getPermanentDislocation();

        String tempDis = repository.findById(id)
                .get().getTemporaryDislocation().getTemporaryDislocation();

        String transEq = repository.findById(id)
                .get().getTransportEquipment().getTotalTransportEquipment();

        String  militaryEq = repository.findById(id)
                .get().getMilitaryEquipment().getTotalMilitaryEquipment();

        form.setOrdinarys(ordinary);
        form.setObj(obj);
        form.setPermanentDislocation(perDis);
        form.setTemporaryDislocation(tempDis);
        form.setTransportEquipment(String.valueOf(transEq));
        form.setMilitaryEquipment(String.valueOf(militaryEq));

        model.addAttribute("formUpd", form);

        List<String> ordinarys = ordinarysService.getAll()
                .stream()
                .map(Ordinarys::getName)
                .collect(Collectors.toList());
        model.addAttribute("ordinarys",ordinarys);

        List<String> objs = objService.getAll()
                .stream()
                .map(Obj::getTypesOfBuildings)
                .collect(Collectors.toList());
        model.addAttribute("objs",objs);

        List<String> permdislocs = permamentDislocationService.getAll()
                .stream()
                .map(PermanentDislocation::getPermanentDislocation)
                .collect(Collectors.toList());
        model.addAttribute("permdislocs",permdislocs);

        List<String> tempdislocs = temproraryDislocationService.getAll()
                .stream()
                .map(TemporaryDislocation::getTemporaryDislocation)
                .collect(Collectors.toList());
        model.addAttribute("tempdislocs",tempdislocs);

        List<String> transportEqp = transportEquipmentService.getAll()
                .stream()
                .map(TransportEquipment::getTotalTransportEquipment)
                .collect(Collectors.toList());
        model.addAttribute("transportEqp",transportEqp);

        List<String> militaryEqp = militaryEquipmentService.getAll()
                .stream()
                .map(MilitaryEquipment::getTotalMilitaryEquipment)
                .collect(Collectors.toList());
        model.addAttribute("militaryEq",militaryEqp);

        return "department/department-appdate";
    }


    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") DepartamentForm form,
                              @PathVariable("id") String id){

        Department department = new Department();
        department.setId(form.getId());
        department.setPersonnel(Integer.parseInt(form.getPersonnel()));

        String ordinarysName = form.getOrdinarys();
        Ordinarys ordinarys = ordinarysService.getByName(form.getOrdinarys());
        department.setOrdinarys(ordinarys);

        String objName = form.getObj();
        Obj obj = objService.getByTypes(form.getObj());
        department.setObj(obj);

        String permDis = form.getPermanentDislocation();
        PermanentDislocation permanentDislocation = permamentDislocationService.getByPermDisloc(form.getPermanentDislocation());
        department.setPermanentDislocation(permanentDislocation);

        String tempDis = form.getTemporaryDislocation();
        TemporaryDislocation temporaryDislocation = temproraryDislocationService.getTempDisloc(form.getTemporaryDislocation());
        department.setTemporaryDislocation(temporaryDislocation);

        String transEq = form.getTransportEquipment();
        TransportEquipment transportEquipment = transportEquipmentService.getTransEq(form.getTransportEquipment());
        department.setTransportEquipment(transportEquipment);

        String milEq = form.getMilitaryEquipment();
        MilitaryEquipment militaryEquipment = militaryEquipmentService.getMilitEq(form.getMilitaryEquipment());
        department.setMilitaryEquipment(militaryEquipment);

        service.update(department);

        return "redirect:/ui/Departament/get/all";
    }

}
