package com.example.coursework.controller.ui;

import com.example.coursework.forms.FreightCarForm;
import com.example.coursework.forms.TractorForm;
import com.example.coursework.model.FreightCar;
import com.example.coursework.model.Tractor;
import com.example.coursework.service.FreightCar.Impls.FreightCarServiceImpls;
import com.example.coursework.service.Tractor.Impls.TractorServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/FreightCar")
@Controller
public class FreightCarUIController {

    @Autowired
    FreightCarServiceImpls service;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<FreightCar> freightCars = service.getAll();
        model.addAttribute("freightCars", freightCars);
        //  model.addAttribute("items", service.getAll());
        return "freightCars/freightCars-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/FreightCar/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        FreightCarForm form = new FreightCarForm();
        model.addAttribute("form", form);
        return "freightCars/freightCars-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("form") FreightCarForm form){
        FreightCar freightCar = new FreightCar();
        freightCar.setName(form.getName());
        freightCar.setWeight(form.getWeight());
        freightCar.setMaximumSpeed(form.getMaximumSpeed());
        freightCar.setLiftingCapacity(form.getLiftingCapacity());
        freightCar.setBodyType(form.getBodyType());
        service.create(freightCar);
        return "redirect:/ui/FreightCar/get/all";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        FreightCar freightCar = service.getById(id);
        FreightCarForm form = new FreightCarForm();
        form.setId(id);
        form.setName(freightCar.getName());
        form.setWeight(freightCar.getWeight());
        form.setMaximumSpeed(freightCar.getMaximumSpeed());
        form.setLiftingCapacity(freightCar.getLiftingCapacity());
        form.setBodyType(freightCar.getBodyType());
        model.addAttribute("form", form);
        return "freightCars/freightCars-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") FreightCarForm form,
                              @PathVariable("id") String id){
        FreightCar freightCar = new FreightCar();
        freightCar.setId(form.getId());
        freightCar.setName(form.getName());
        freightCar.setWeight(form.getWeight());
        freightCar.setMaximumSpeed(form.getMaximumSpeed());
        freightCar.setLiftingCapacity(form.getLiftingCapacity());
        freightCar.setBodyType(form.getBodyType());
        service.update(freightCar);
        return "redirect:/ui/FreightCar/get/all";
    }
}
