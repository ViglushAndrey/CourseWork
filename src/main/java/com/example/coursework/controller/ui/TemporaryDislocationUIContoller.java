package com.example.coursework.controller.ui;

import com.example.coursework.forms.TanksForm;
import com.example.coursework.forms.TemporaryDisForm;
import com.example.coursework.model.Tanks;
import com.example.coursework.model.TemporaryDislocation;
import com.example.coursework.service.Tanks.Impls.TanksServiceImpls;
import com.example.coursework.service.TemproraryDislocation.Impls.TemproraryDislocationServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/TemporaryDis")
@Controller
public class TemporaryDislocationUIContoller {

    @Autowired
    TemproraryDislocationServiceImpls service;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<TemporaryDislocation> temporaryDislocations = service.getAll();
        model.addAttribute("temporaryDislocations", temporaryDislocations);
        //  model.addAttribute("items", service.getAll());
        return "temporaryDislocations/temporaryDislocations-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/TemporaryDis/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        TemporaryDisForm temporaryDisForm = new TemporaryDisForm();
        model.addAttribute("form", temporaryDisForm);
        return "temporaryDislocations/temporaryDislocations-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("temporaryDisForm") TemporaryDisForm temporaryDisForm){
        TemporaryDislocation dislocation = new TemporaryDislocation();
        dislocation.setTemporaryDislocation(temporaryDisForm.getTemporaryDislocation());
        dislocation.setCity(temporaryDisForm.getCity());
        dislocation.setAddress(temporaryDisForm.getAddress());
        service.create(dislocation);
        return "redirect:/ui/TemporaryDis/get/all";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        TemporaryDislocation dislocation = service.getById(id);
        TemporaryDisForm form = new TemporaryDisForm();
        form.setId(dislocation.getId());
        form.setTemporaryDislocation(dislocation.getTemporaryDislocation());
        form.setCity(dislocation.getCity());
        form.setAddress(dislocation.getAddress());
        //officerForm.setbDay(officers.getbDay());

        model.addAttribute("form", form);
        return "temporaryDislocations/temporaryDislocations-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") TemporaryDisForm temporaryDisForm,
                              @PathVariable("id") String id){
        TemporaryDislocation dislocation = new TemporaryDislocation();
        dislocation.setId(temporaryDisForm.getId());
        dislocation.setTemporaryDislocation(temporaryDisForm.getTemporaryDislocation());
        dislocation.setCity(temporaryDisForm.getCity());
        dislocation.setAddress(temporaryDisForm.getAddress());
        service.update(dislocation);
        return "redirect:/ui/TemporaryDis/get/all";
    }

}
