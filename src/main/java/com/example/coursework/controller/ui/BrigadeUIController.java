package com.example.coursework.controller.ui;


import com.example.coursework.forms.BrigadeForm;
import com.example.coursework.forms.RotaForm;
import com.example.coursework.model.*;
import com.example.coursework.repository.Armament.ArmamentRepository;
import com.example.coursework.repository.Brigade.BrigadeRepository;
import com.example.coursework.repository.Obj.ObjRepository;
import com.example.coursework.repository.Officers.OfficersRepository;
import com.example.coursework.repository.PermamentDislocation.PermamentDislocationRepository;
import com.example.coursework.repository.Rota.RotaRepository;
import com.example.coursework.repository.TemproraryDislocation.TemproraryDislocationRepository;
import com.example.coursework.repository.Vzvods.VzvodsRepository;
import com.example.coursework.service.Armament.Impls.ArmamentServiceImpls;
import com.example.coursework.service.Brigade.Impls.BrigadeServiceImpls;
import com.example.coursework.service.Obj.Impls.ObjServiceImpls;
import com.example.coursework.service.Officers.Impls.OfficersServiceImpls;
import com.example.coursework.service.PermamentDislocation.Impls.PermamentDislocationServiceImpls;
import com.example.coursework.service.Rota.Impls.RotaServiceImpls;
import com.example.coursework.service.TemproraryDislocation.Impls.TemproraryDislocationServiceImpls;
import com.example.coursework.service.Vzvods.Impls.VzvodsServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/ui/Brigade")
@Controller
public class BrigadeUIController {

    @Autowired
    BrigadeServiceImpls service;

    @Autowired
    RotaServiceImpls rotaService;

    @Autowired
    ArmamentServiceImpls armamentService;

    @Autowired
    OfficersServiceImpls officersService;

    @Autowired
    ObjServiceImpls objService;

    @Autowired
    PermamentDislocationServiceImpls permamentDislocationService;

    @Autowired
    TemproraryDislocationServiceImpls temproraryDislocationService;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<Brigade> brigades = service.getAll();
        model.addAttribute("brigades", brigades);
        //  model.addAttribute("items", service.getAll());
        return "brigades/brigades-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/Brigade/get/all";
    }

    @GetMapping(value = "create")
    public String create(Model model){
        BrigadeForm form = new BrigadeForm();

        form.setName("");
        form.setPersonnel("");
        form.setRota("");
        form.setArmament("");
        form.setOfficers("");
        form.setObj("");
        form.setPermanentDislocation("");
        form.setTemporaryDislocation("");


        model.addAttribute("form", form);

        List<String> officers = officersService.getAll()
                .stream()
                .map(Officers::getName)
                .collect(Collectors.toList());
        model.addAttribute("officers",officers);

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

        List<String> rota = rotaService.getAll()
                .stream()
                .map(Rota::getName)
                .collect(Collectors.toList());
        model.addAttribute("rota",rota);


        return "brigades/brigades-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("form") BrigadeForm form){

        Brigade brigade = new Brigade();
        brigade.setId(form.getId());
        brigade.setName(form.getName());
        brigade.setPersonnel(Integer.parseInt(form.getPersonnel()));

        String officersName = form.getOfficers();
        Officers officers = officersService.getByName(form.getOfficers());
        brigade.setOfficers(officers);

        String objName = form.getObj();
        Obj obj = objService.getByTypes(form.getObj());
        brigade.setObj(obj);

        String permDis = form.getPermanentDislocation();
        PermanentDislocation permanentDislocation = permamentDislocationService.getByPermDisloc(form.getPermanentDislocation());
        brigade.setPermanentDislocation(permanentDislocation);

        String tempDis = form.getTemporaryDislocation();
        TemporaryDislocation temporaryDislocation = temproraryDislocationService.getTempDisloc(form.getTemporaryDislocation());
        brigade.setTemporaryDislocation(temporaryDislocation);

        String armament = form.getArmament();
        Armament armamentName = armamentService.getId(form.getArmament());
        brigade.setArmament(armamentName);

        String rota = form.getRota();
        Rota rota1 = rotaService.getByName(form.getRota());
        brigade.setRota(rota1);




        service.create(brigade);

        return "redirect:/ui/Brigade/get/all";
    }

    @Autowired
    BrigadeRepository repository;

    @Autowired
    RotaRepository rotaRepository;

    @Autowired
    OfficersRepository officersRepository;

    @Autowired
    ObjRepository objRepository;

    @Autowired
    PermamentDislocationRepository permamentDislocationRepository;

    @Autowired
    TemproraryDislocationRepository temproraryDislocationRepository;

    @Autowired
    ArmamentRepository armamentRepository;

    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){

        BrigadeForm form = new BrigadeForm();
        form.setId(id);
        form.setName(repository.findById(id).get().getName());
        form.setPersonnel(String.valueOf(repository.findById(id).get().getPersonnel()));

        String officers = repository.findById(id)
                .get().getOfficers().getName();

        String obj = repository.findById(id)
                .get().getObj().getTypesOfBuildings();

        String perDis = repository.findById(id)
                .get().getPermanentDislocation().getPermanentDislocation();

        String tempDis = repository.findById(id)
                .get().getTemporaryDislocation().getTemporaryDislocation();

        String armament = repository.findById(id)
                .get().getArmament().getId();

        String rota = String.valueOf(repository.findById(id)
                .get().getRota().getName());

        form.setOfficers(officers);
        form.setObj(obj);
        form.setPermanentDislocation(perDis);
        form.setTemporaryDislocation(tempDis);
        form.setArmament(armament);
        form.setRota(rota);

        model.addAttribute("formUpd", form);

        List<String> officer = officersService.getAll()
                .stream()
                .map(Officers::getName)
                .collect(Collectors.toList());
        model.addAttribute("officer",officer);

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

        List<String> rotas = rotaService.getAll()
                .stream()
                .map(Rota::getName)
                .collect(Collectors.toList());
        model.addAttribute("rotas",rotas);

        return "brigades/brigades-appdate";
    }


    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") BrigadeForm form,
                              @PathVariable("id") String id){

        Brigade brigade = new Brigade();
        brigade.setId(form.getId());
        brigade.setName(form.getName());
        brigade.setPersonnel(Integer.parseInt(form.getPersonnel()));

        String officersName = form.getOfficers();
        Officers officers = officersService.getByName(form.getOfficers());
        brigade.setOfficers(officers);

        String objName = form.getObj();
        Obj obj = objService.getByTypes(form.getObj());
        brigade.setObj(obj);

        String permDis = form.getPermanentDislocation();
        PermanentDislocation permanentDislocation = permamentDislocationService.getByPermDisloc(form.getPermanentDislocation());
        brigade.setPermanentDislocation(permanentDislocation);

        String tempDis = form.getTemporaryDislocation();
        TemporaryDislocation temporaryDislocation = temproraryDislocationService.getTempDisloc(form.getTemporaryDislocation());
        brigade.setTemporaryDislocation(temporaryDislocation);

        String armament = form.getArmament();
        Armament armamentName = armamentService.getId(form.getArmament());
        brigade.setArmament(armamentName);

        String rota = form.getRota();
        Rota rota1 = rotaService.getByName(form.getRota());
        brigade.setRota(rota1);

        service.update(brigade);

        return "redirect:/ui/Brigade/get/all";
    }

}
