package com.example.coursework.controller.ui;

import com.example.coursework.forms.ArmyForm;
import com.example.coursework.forms.BrigadeForm;
import com.example.coursework.model.*;
import com.example.coursework.repository.Armament.ArmamentRepository;
import com.example.coursework.repository.Army.ArmyRepository;
import com.example.coursework.repository.Brigade.BrigadeRepository;
import com.example.coursework.repository.Generals.GeneralsRepository;
import com.example.coursework.repository.Obj.ObjRepository;
import com.example.coursework.repository.Officers.OfficersRepository;
import com.example.coursework.repository.PermamentDislocation.PermamentDislocationRepository;
import com.example.coursework.repository.Rota.RotaRepository;
import com.example.coursework.repository.TemproraryDislocation.TemproraryDislocationRepository;
import com.example.coursework.service.Armament.Impls.ArmamentServiceImpls;
import com.example.coursework.service.Army.Impls.ArmyServiceImpls;
import com.example.coursework.service.Battalion.Impls.BattalionServiceImpls;
import com.example.coursework.service.Brigade.Impls.BrigadeServiceImpls;
import com.example.coursework.service.Generals.Impls.GeneralsServiceImpls;
import com.example.coursework.service.Obj.Impls.ObjServiceImpls;
import com.example.coursework.service.Officers.Impls.OfficersServiceImpls;
import com.example.coursework.service.PermamentDislocation.Impls.PermamentDislocationServiceImpls;
import com.example.coursework.service.Rota.Impls.RotaServiceImpls;
import com.example.coursework.service.TemproraryDislocation.Impls.TemproraryDislocationServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/ui/Army")
@Controller
public class ArmyUIController {

    @Autowired
    ArmyServiceImpls service;

    @Autowired
    BattalionServiceImpls battalionService;

    @Autowired
    ArmamentServiceImpls armamentService;

    @Autowired
    GeneralsServiceImpls generalsService;

    @Autowired
    ObjServiceImpls objService;

    @Autowired
    PermamentDislocationServiceImpls permamentDislocationService;

    @Autowired
    TemproraryDislocationServiceImpls temproraryDislocationService;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<Army> armies = service.getAll();
        model.addAttribute("armies", armies);
        //  model.addAttribute("items", service.getAll());
        return "armies/armies-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/Army/get/all";
    }

    @GetMapping(value = "create")
    public String create(Model model){
        ArmyForm form = new ArmyForm();

        form.setName("");
        form.setPersonnel("");
        form.setBattalion("");
        form.setArmament("");
        form.setGenerals("");
        form.setObj("");
        form.setPermanentDislocation("");
        form.setTemporaryDislocation("");


        model.addAttribute("form", form);

        List<String> generals = generalsService.getAll()
                .stream()
                .map(Generals::getName)
                .collect(Collectors.toList());
        model.addAttribute("generals",generals);

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

        List<String> battalion = battalionService.getAll()
                .stream()
                .map(Battalion::getName)
                .collect(Collectors.toList());
        model.addAttribute("battalion",battalion);


        return "armies/armies-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("form") ArmyForm form){

        Army army = new Army();
        army.setId(form.getId());
        army.setName(form.getName());
        army.setPersonnel(Integer.parseInt(form.getPersonnel()));

        String generalsName = form.getGenerals();
        Generals generals = generalsService.getByName(form.getGenerals());
        army.setGenerals(generals);

        String objName = form.getObj();
        Obj obj = objService.getByTypes(form.getObj());
        army.setObj(obj);

        String permDis = form.getPermanentDislocation();
        PermanentDislocation permanentDislocation = permamentDislocationService.getByPermDisloc(form.getPermanentDislocation());
        army.setPermanentDislocation(permanentDislocation);

        String tempDis = form.getTemporaryDislocation();
        TemporaryDislocation temporaryDislocation = temproraryDislocationService.getTempDisloc(form.getTemporaryDislocation());
        army.setTemporaryDislocation(temporaryDislocation);

        String armament = form.getArmament();
        Armament armamentName = armamentService.getId(form.getArmament());
        army.setArmament(armamentName);

        String battalion = form.getBattalion();
        Battalion battalion1 = battalionService.getByName(form.getBattalion());
        army.setBattalion(battalion1);




        service.create(army);

        return "redirect:/ui/Army/get/all";
    }

    @Autowired
    BrigadeRepository brigadeRepository;

    @Autowired
    ArmyRepository repository;

    @Autowired
    GeneralsRepository generalsRepository;

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

        ArmyForm form = new ArmyForm();
        form.setId(id);
        form.setName(repository.findById(id).get().getName());
        form.setPersonnel(String.valueOf(repository.findById(id).get().getPersonnel()));

        String generals = repository.findById(id)
                .get().getGenerals().getName();

        String obj = repository.findById(id)
                .get().getObj().getTypesOfBuildings();

        String perDis = repository.findById(id)
                .get().getPermanentDislocation().getPermanentDislocation();

        String tempDis = repository.findById(id)
                .get().getTemporaryDislocation().getTemporaryDislocation();

        String armament = repository.findById(id)
                .get().getArmament().getId();

        String battalion = String.valueOf(repository.findById(id)
                .get().getBattalion().getName());

        form.setGenerals(generals);
        form.setObj(obj);
        form.setPermanentDislocation(perDis);
        form.setTemporaryDislocation(tempDis);
        form.setArmament(armament);
        form.setBattalion(battalion);

        model.addAttribute("formUpd", form);

        List<String> general = generalsService.getAll()
                .stream()
                .map(Generals::getName)
                .collect(Collectors.toList());
        model.addAttribute("general",general);

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

        List<String> battalions = battalionService.getAll()
                .stream()
                .map(Battalion::getName)
                .collect(Collectors.toList());
        model.addAttribute("battalions",battalions);

        return "armies/armies-appdate";
    }


    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") ArmyForm form,
                              @PathVariable("id") String id){

        Army army = new Army();
        army.setId(form.getId());
        army.setName(form.getName());
        army.setPersonnel(Integer.parseInt(form.getPersonnel()));

        String generalsName = form.getGenerals();
        Generals generals = generalsService.getByName(form.getGenerals());
        army.setGenerals(generals);

        String objName = form.getObj();
        Obj obj = objService.getByTypes(form.getObj());
        army.setObj(obj);

        String permDis = form.getPermanentDislocation();
        PermanentDislocation permanentDislocation = permamentDislocationService.getByPermDisloc(form.getPermanentDislocation());
        army.setPermanentDislocation(permanentDislocation);

        String tempDis = form.getTemporaryDislocation();
        TemporaryDislocation temporaryDislocation = temproraryDislocationService.getTempDisloc(form.getTemporaryDislocation());
        army.setTemporaryDislocation(temporaryDislocation);

        String armament = form.getArmament();
        Armament armamentName = armamentService.getId(form.getArmament());
        army.setArmament(armamentName);

        String battalion = form.getBattalion();
        Battalion battalion1 = battalionService.getByName(form.getBattalion());
        army.setBattalion(battalion1);

        service.update(army);

        return "redirect:/ui/Army/get/all";
    }

}
