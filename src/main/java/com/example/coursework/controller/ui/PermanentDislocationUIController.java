package com.example.coursework.controller.ui;

import com.example.coursework.forms.PermamentDisForm;
import com.example.coursework.forms.TemporaryDisForm;
import com.example.coursework.model.PermanentDislocation;
import com.example.coursework.model.TemporaryDislocation;
import com.example.coursework.service.PermamentDislocation.Impls.PermamentDislocationServiceImpls;
import com.example.coursework.service.TemproraryDislocation.Impls.TemproraryDislocationServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/PermanentDis")
@Controller
public class PermanentDislocationUIController {

    @Autowired
    PermamentDislocationServiceImpls service;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<PermanentDislocation> dislocations = service.getAll();
        model.addAttribute("dislocations", dislocations);
        //  model.addAttribute("items", service.getAll());
        return "permanentDislocations/permanentDislocations-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/PermanentDis/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        PermamentDisForm disForm = new PermamentDisForm();
        model.addAttribute("form", disForm);
        return "permanentDislocations/permanentDislocations-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("disForm") PermamentDisForm disForm){
        PermanentDislocation dislocation = new PermanentDislocation();
        dislocation.setPermanentDislocation(disForm.getPermanentDislocation());
        dislocation.setCity(disForm.getCity());
        dislocation.setAddress(disForm.getAddress());
        service.create(dislocation);
        return "redirect:/ui/PermanentDis/get/all";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        PermanentDislocation dislocation = service.getById(id);
        PermamentDisForm disForm = new PermamentDisForm();
        disForm.setId(dislocation.getId());
        disForm.setPermanentDislocation(dislocation.getPermanentDislocation());
        disForm.setCity(dislocation.getCity());
        disForm.setAddress(dislocation.getAddress());
        //officerForm.setbDay(officers.getbDay());

        model.addAttribute("form", disForm);
        return "permanentDislocations/permanentDislocations-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") PermamentDisForm disForm,
                              @PathVariable("id") String id){
        PermanentDislocation dislocation = new PermanentDislocation();
        dislocation.setId(disForm.getId());
        dislocation.setPermanentDislocation(disForm.getPermanentDislocation());
        dislocation.setCity(disForm.getCity());
        dislocation.setAddress(disForm.getAddress());
        service.update(dislocation);
        return "redirect:/ui/PermanentDis/get/all";
    }

}
