package com.example.coursework.controller.ui;

import com.example.coursework.forms.RotaForm;
import com.example.coursework.forms.VzvodsForm;
import com.example.coursework.model.*;
import com.example.coursework.repository.Armament.ArmamentRepository;
import com.example.coursework.repository.Departament.DepartamentRepository;
import com.example.coursework.repository.Obj.ObjRepository;
import com.example.coursework.repository.Officers.OfficersRepository;
import com.example.coursework.repository.PermamentDislocation.PermamentDislocationRepository;
import com.example.coursework.repository.Rota.RotaRepository;
import com.example.coursework.repository.Serguants.SerguantsRepository;
import com.example.coursework.repository.TemproraryDislocation.TemproraryDislocationRepository;
import com.example.coursework.repository.Vzvods.VzvodsRepository;
import com.example.coursework.service.Armament.Impls.ArmamentServiceImpls;
import com.example.coursework.service.Departament.Impls.DepartamentServiceImpls;
import com.example.coursework.service.Obj.Impls.ObjServiceImpls;
import com.example.coursework.service.Officers.Impls.OfficersServiceImpls;
import com.example.coursework.service.PermamentDislocation.Impls.PermamentDislocationServiceImpls;
import com.example.coursework.service.Rota.Impls.RotaServiceImpls;
import com.example.coursework.service.Serguants.Impls.SerguantsServiceImpls;
import com.example.coursework.service.TemproraryDislocation.Impls.TemproraryDislocationServiceImpls;
import com.example.coursework.service.Vzvods.Impls.VzvodsServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/ui/Rota")
@Controller
public class RotaUIController {

    @Autowired
    RotaServiceImpls service;

    @Autowired
    VzvodsServiceImpls vzvodsService;

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
        List<Rota> rotas = service.getAll();
        model.addAttribute("rotas", rotas);
        //  model.addAttribute("items", service.getAll());
        return "rota/rota-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/Rota/get/all";
    }

    @GetMapping(value = "create")
    public String create(Model model){
        RotaForm form = new RotaForm();

        form.setName("");
        form.setPersonnel("");
        form.setVzvods("");
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

        List<String> vzvods = vzvodsService.getAll()
                .stream()
                .map(Vzvods::getName)
                .collect(Collectors.toList());
        model.addAttribute("vzvods",vzvods);


        return "rota/rota-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("form") RotaForm form){

        Rota rota = new Rota();
        rota.setId(form.getId());
        rota.setName(form.getName());
        rota.setPersonnel(Integer.parseInt(form.getPersonnel()));

        String officersName = form.getOfficers();
        Officers officers = officersService.getByName(form.getOfficers());
        rota.setOfficers(officers);

        String objName = form.getObj();
        Obj obj = objService.getByTypes(form.getObj());
        rota.setObj(obj);

        String permDis = form.getPermanentDislocation();
        PermanentDislocation permanentDislocation = permamentDislocationService.getByPermDisloc(form.getPermanentDislocation());
        rota.setPermanentDislocation(permanentDislocation);

        String tempDis = form.getTemporaryDislocation();
        TemporaryDislocation temporaryDislocation = temproraryDislocationService.getTempDisloc(form.getTemporaryDislocation());
        rota.setTemporaryDislocation(temporaryDislocation);

        String armament = form.getArmament();
        Armament armamentName = armamentService.getId(form.getArmament());
        rota.setArmament(armamentName);

        String vzvods = form.getVzvods();
        Vzvods vzvods1 = vzvodsService.getByName(form.getVzvods());
        rota.setVzvods(vzvods1);




        service.create(rota);

        return "redirect:/ui/Rota/get/all";
    }

    @Autowired
    VzvodsRepository vzvodsRepository;

    @Autowired
    RotaRepository repository;

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

        RotaForm form = new RotaForm();
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

        String vzvods = String.valueOf(repository.findById(id)
                .get().getVzvods().getName());

        form.setOfficers(officers);
        form.setObj(obj);
        form.setPermanentDislocation(perDis);
        form.setTemporaryDislocation(tempDis);
        form.setArmament(armament);
        form.setVzvods(vzvods);

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

        List<String> vzvod = vzvodsService.getAll()
                .stream()
                .map(Vzvods::getName)
                .collect(Collectors.toList());
        model.addAttribute("vzvod",vzvod);

        return "rota/rota-appdate";
    }


    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") RotaForm form,
                              @PathVariable("id") String id){

        Rota rota = new Rota();
        rota.setId(form.getId());
        rota.setName(form.getName());
        rota.setPersonnel(Integer.parseInt(form.getPersonnel()));

        String officersName = form.getOfficers();
        Officers officers = officersService.getByName(form.getOfficers());
        rota.setOfficers(officers);

        String objName = form.getObj();
        Obj obj = objService.getByTypes(form.getObj());
        rota.setObj(obj);

        String permDis = form.getPermanentDislocation();
        PermanentDislocation permanentDislocation = permamentDislocationService.getByPermDisloc(form.getPermanentDislocation());
        rota.setPermanentDislocation(permanentDislocation);

        String tempDis = form.getTemporaryDislocation();
        TemporaryDislocation temporaryDislocation = temproraryDislocationService.getTempDisloc(form.getTemporaryDislocation());
        rota.setTemporaryDislocation(temporaryDislocation);

        String armament = form.getArmament();
        Armament armamentName = armamentService.getId(form.getArmament());
        rota.setArmament(armamentName);

        String vzvods = form.getVzvods();
        Vzvods vzvods1 = vzvodsService.getByName(form.getVzvods());
        rota.setVzvods(vzvods1);

        service.update(rota);

        return "redirect:/ui/Rota/get/all";
    }

}
