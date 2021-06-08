package com.example.coursework.controller.ui;

import com.example.coursework.forms.DepartamentForm;
import com.example.coursework.forms.VzvodsForm;
import com.example.coursework.model.*;
import com.example.coursework.repository.Armament.ArmamentRepository;
import com.example.coursework.repository.Departament.DepartamentRepository;
import com.example.coursework.repository.MilitaryEquipment.MilitaryEquipmentRepository;
import com.example.coursework.repository.Obj.ObjRepository;
import com.example.coursework.repository.Ordinarys.OrdinarysRepository;
import com.example.coursework.repository.PermamentDislocation.PermamentDislocationRepository;
import com.example.coursework.repository.Serguants.SerguantsRepository;
import com.example.coursework.repository.TemproraryDislocation.TemproraryDislocationRepository;
import com.example.coursework.repository.TransportEquipment.TransportEquipmentRepository;
import com.example.coursework.repository.Vzvods.VzvodsRepository;
import com.example.coursework.service.Armament.Impls.ArmamentServiceImpls;
import com.example.coursework.service.Departament.Impls.DepartamentServiceImpls;
import com.example.coursework.service.MilitaryEquipment.Impls.MilitaryEquipmentServiceImpls;
import com.example.coursework.service.Obj.Impls.ObjServiceImpls;
import com.example.coursework.service.PermamentDislocation.Impls.PermamentDislocationServiceImpls;
import com.example.coursework.service.Serguants.Impls.SerguantsServiceImpls;
import com.example.coursework.service.TemproraryDislocation.Impls.TemproraryDislocationServiceImpls;
import com.example.coursework.service.Tractor.Impls.TractorServiceImpls;
import com.example.coursework.service.TransportEquipment.Impls.TransportEquipmentServiceImpls;
import com.example.coursework.service.Vzvods.Impls.VzvodsServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/ui/Vzvods")
@Controller
public class VzvodsUIController {

    @Autowired
    VzvodsServiceImpls service;

    @Autowired
    DepartamentServiceImpls departamentService;

    @Autowired
    ArmamentServiceImpls armamentService;

    @Autowired
    SerguantsServiceImpls serguantsService;

    @Autowired
    ObjServiceImpls objService;

    @Autowired
    PermamentDislocationServiceImpls permamentDislocationService;

    @Autowired
    TemproraryDislocationServiceImpls temproraryDislocationService;


    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<Vzvods> vzvod = service.getAll();
        model.addAttribute("vzvod", vzvod);
        //  model.addAttribute("items", service.getAll());
        return "vzvods/vzvods-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/Vzvods/get/all";
    }

    @GetMapping(value = "create")
    public String create(Model model){
        VzvodsForm form = new VzvodsForm();

        form.setName("");
        form.setPersonnel("");
        form.setDepartment("");
        form.setArmament("");
        form.setSerguants("");
        form.setObj("");
        form.setPermanentDislocation("");
        form.setTemporaryDislocation("");


        model.addAttribute("form", form);

        List<String> serguants = serguantsService.getAll()
                .stream()
                .map(Serguants::getName)
                .collect(Collectors.toList());
        model.addAttribute("serguants",serguants);

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

        List<String> armament = armamentService.getAll()
                .stream()
                .map(Armament::getId)
                .collect(Collectors.toList());
        model.addAttribute("armament",armament);

        List<String> department = departamentService.getAll()
                .stream()
                .map(Department::getName)
                .collect(Collectors.toList());
        model.addAttribute("department",department);


        return "vzvods/vzvods-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("form") VzvodsForm form){

        Vzvods vzvods = new Vzvods();
        vzvods.setId(form.getId());
        vzvods.setName(form.getName());
        vzvods.setPersonnel(Integer.parseInt(form.getPersonnel()));

        String serguantsName = form.getSerguants();
        Serguants serguants = serguantsService.getByName(form.getSerguants());
        vzvods.setSerguants(serguants);

        String objName = form.getObj();
        Obj obj = objService.getByTypes(form.getObj());
        vzvods.setObj(obj);

        String permDis = form.getPermanentDislocation();
        PermanentDislocation permanentDislocation = permamentDislocationService.getByPermDisloc(form.getPermanentDislocation());
        vzvods.setPermanentDislocation(permanentDislocation);

        String tempDis = form.getTemporaryDislocation();
        TemporaryDislocation temporaryDislocation = temproraryDislocationService.getTempDisloc(form.getTemporaryDislocation());
        vzvods.setTemporaryDislocation(temporaryDislocation);

        String armament = form.getArmament();
        Armament armamentName = armamentService.getId(form.getArmament());
        vzvods.setArmament(armamentName);

        String department = form.getDepartment();
        Department departmentName = departamentService.getByName(form.getDepartment());
        vzvods.setDepartment(departmentName);




        service.create(vzvods);

        return "redirect:/ui/Vzvods/get/all";
    }

    @Autowired
    VzvodsRepository repository;

    @Autowired
    SerguantsRepository serguantsRepository;

    @Autowired
    ObjRepository objRepository;

    @Autowired
    PermamentDislocationRepository permamentDislocationRepository;

    @Autowired
    TemproraryDislocationRepository temproraryDislocationRepository;

    @Autowired
    ArmamentRepository armamentRepository;

    @Autowired
    DepartamentRepository departamentRepository;

    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){

        VzvodsForm form = new VzvodsForm();
        form.setId(id);
        form.setName(repository.findById(id).get().getName());
        form.setPersonnel(String.valueOf(repository.findById(id).get().getPersonnel()));

        String serguants = repository.findById(id)
                .get().getSerguants().getName();

        String obj = repository.findById(id)
                .get().getObj().getTypesOfBuildings();

        String perDis = repository.findById(id)
                .get().getPermanentDislocation().getPermanentDislocation();

        String tempDis = repository.findById(id)
                .get().getTemporaryDislocation().getTemporaryDislocation();

        String armament = repository.findById(id)
                .get().getArmament().getId();

        String department = String.valueOf(repository.findById(id)
                .get().getDepartment());

        form.setSerguants(serguants);
        form.setObj(obj);
        form.setPermanentDislocation(perDis);
        form.setTemporaryDislocation(tempDis);
        form.setArmament(armament);
        form.setDepartment(department);

        model.addAttribute("formUpd", form);

        List<String> serguant = serguantsService.getAll()
                .stream()
                .map(Serguants::getName)
                .collect(Collectors.toList());
        model.addAttribute("serguant",serguant);

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

        List<String> armaments = armamentService.getAll()
                .stream()
                .map(Armament::getId)
                .collect(Collectors.toList());
        model.addAttribute("armaments",armaments);

        List<String> departments = departamentService.getAll()
                .stream()
                .map(Department::getName)
                .collect(Collectors.toList());
        model.addAttribute("departments",departments);

        return "vzvods/vzvods-appdate";
    }


    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") VzvodsForm form,
                              @PathVariable("id") String id){

        Vzvods vzvods = new Vzvods();
        vzvods.setId(form.getId());
        vzvods.setName(form.getName());
        vzvods.setPersonnel(Integer.parseInt(form.getPersonnel()));

        String serguantsName = form.getSerguants();
        Serguants serguants = serguantsService.getByName(form.getSerguants());
        vzvods.setSerguants(serguants);

        String objName = form.getObj();
        Obj obj = objService.getByTypes(form.getObj());
        vzvods.setObj(obj);

        String permDis = form.getPermanentDislocation();
        PermanentDislocation permanentDislocation = permamentDislocationService.getByPermDisloc(form.getPermanentDislocation());
        vzvods.setPermanentDislocation(permanentDislocation);

        String tempDis = form.getTemporaryDislocation();
        TemporaryDislocation temporaryDislocation = temproraryDislocationService.getTempDisloc(form.getTemporaryDislocation());
        vzvods.setTemporaryDislocation(temporaryDislocation);

        String armament = form.getArmament();
        Armament armamentName = armamentService.getId(form.getArmament());
        vzvods.setArmament(armamentName);

        String department = form.getDepartment();
        Department departmentName = departamentService.getByName(form.getDepartment());
        vzvods.setDepartment(departmentName);

        return "redirect:/ui/Vzvods/get/all";
    }

}
