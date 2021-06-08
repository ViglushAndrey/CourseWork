package com.example.coursework.controller.ui;

import com.example.coursework.forms.BattalionForm;
import com.example.coursework.forms.BrigadeForm;
import com.example.coursework.model.*;
import com.example.coursework.repository.Armament.ArmamentRepository;
import com.example.coursework.repository.Battalion.BattalionRepository;
import com.example.coursework.repository.Brigade.BrigadeRepository;
import com.example.coursework.repository.Generals.GeneralsRepository;
import com.example.coursework.repository.Obj.ObjRepository;
import com.example.coursework.repository.Officers.OfficersRepository;
import com.example.coursework.repository.PermamentDislocation.PermamentDislocationRepository;
import com.example.coursework.repository.Rota.RotaRepository;
import com.example.coursework.repository.TemproraryDislocation.TemproraryDislocationRepository;
import com.example.coursework.service.Armament.Impls.ArmamentServiceImpls;
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

@RequestMapping(value = "/ui/Battalion")
@Controller
public class BattalionUIController {

    @Autowired
    BattalionServiceImpls service;

    @Autowired
    BrigadeServiceImpls brigadeService;

    @Autowired
    ArmamentServiceImpls armamentService;

    @Autowired
    GeneralsServiceImpls generalsService;

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
        List<Battalion> battalions = service.getAll();
        model.addAttribute("battalions", battalions);
        //  model.addAttribute("items", service.getAll());
        return "battalions/battalions-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/Battalion/get/all";
    }

    @GetMapping(value = "create")
    public String create(Model model){
        BattalionForm form = new BattalionForm();

        form.setName("");
        form.setPersonnel("");
        form.setBrigade("");
        form.setArmament("");
        form.setGenerals("");
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

        List<String> brigade = brigadeService.getAll()
                .stream()
                .map(Brigade::getName)
                .collect(Collectors.toList());
        model.addAttribute("brigade",brigade);


        return "battalions/battalions-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("form") BattalionForm form){

        Battalion battalion = new Battalion();
        battalion.setId(form.getId());
        battalion.setName(form.getName());
        battalion.setPersonnel(Integer.parseInt(form.getPersonnel()));

        String officersName = form.getOfficers();
        Officers officers = officersService.getByName(form.getOfficers());
        battalion.setOfficers(officers);

        String generalsName = form.getGenerals();
        Generals generals = generalsService.getByName(form.getGenerals());
        battalion.setGenerals(generals);

        String objName = form.getObj();
        Obj obj = objService.getByTypes(form.getObj());
        battalion.setObj(obj);

        String permDis = form.getPermanentDislocation();
        PermanentDislocation permanentDislocation = permamentDislocationService.getByPermDisloc(form.getPermanentDislocation());
        battalion.setPermanentDislocation(permanentDislocation);

        String tempDis = form.getTemporaryDislocation();
        TemporaryDislocation temporaryDislocation = temproraryDislocationService.getTempDisloc(form.getTemporaryDislocation());
        battalion.setTemporaryDislocation(temporaryDislocation);

        String armament = form.getArmament();
        Armament armamentName = armamentService.getId(form.getArmament());
        battalion.setArmament(armamentName);

        String brigade = form.getBrigade();
        Brigade brigade1 = brigadeService.getByName(form.getBrigade());
        battalion.setBrigade(brigade1);




        service.create(battalion);

        return "redirect:/ui/Battalion/get/all";
    }

    @Autowired
    BrigadeRepository brigadeRepository;

    @Autowired
    BattalionRepository repository;

    @Autowired
    OfficersRepository officersRepository;

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

        BattalionForm form = new BattalionForm();
        form.setId(id);
        form.setName(repository.findById(id).get().getName());
        form.setPersonnel(String.valueOf(repository.findById(id).get().getPersonnel()));

        String officers = repository.findById(id)
                .get().getOfficers().getName();

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

        String brigade = String.valueOf(repository.findById(id)
                .get().getBrigade().getName());

        form.setOfficers(officers);
        form.setGenerals(generals);
        form.setObj(obj);
        form.setPermanentDislocation(perDis);
        form.setTemporaryDislocation(tempDis);
        form.setArmament(armament);
        form.setBrigade(brigade);

        model.addAttribute("formUpd", form);

        List<String> officer = officersService.getAll()
                .stream()
                .map(Officers::getName)
                .collect(Collectors.toList());
        model.addAttribute("officer",officer);

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

        List<String> brigades = brigadeService.getAll()
                .stream()
                .map(Brigade::getName)
                .collect(Collectors.toList());
        model.addAttribute("brigades",brigades);

        return "battalions/battalions-appdate";
    }


    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") BattalionForm form,
                              @PathVariable("id") String id){

        Battalion battalion = new Battalion();
        battalion.setId(form.getId());
        battalion.setName(form.getName());
        battalion.setPersonnel(Integer.parseInt(form.getPersonnel()));

        String officersName = form.getOfficers();
        Officers officers = officersService.getByName(form.getOfficers());
        battalion.setOfficers(officers);

        String generalsName = form.getGenerals();
        Generals generals = generalsService.getByName(form.getGenerals());
        battalion.setGenerals(generals);

        String objName = form.getObj();
        Obj obj = objService.getByTypes(form.getObj());
        battalion.setObj(obj);

        String permDis = form.getPermanentDislocation();
        PermanentDislocation permanentDislocation = permamentDislocationService.getByPermDisloc(form.getPermanentDislocation());
        battalion.setPermanentDislocation(permanentDislocation);

        String tempDis = form.getTemporaryDislocation();
        TemporaryDislocation temporaryDislocation = temproraryDislocationService.getTempDisloc(form.getTemporaryDislocation());
        battalion.setTemporaryDislocation(temporaryDislocation);

        String armament = form.getArmament();
        Armament armamentName = armamentService.getId(form.getArmament());
        battalion.setArmament(armamentName);

        String brigade = form.getBrigade();
        Brigade brigade1 = brigadeService.getByName(form.getBrigade());
        battalion.setBrigade(brigade1);


        service.update(battalion);

        return "redirect:/ui/Battalion/get/all";
    }

}
