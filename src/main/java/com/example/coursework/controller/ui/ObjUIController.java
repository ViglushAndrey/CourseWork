package com.example.coursework.controller.ui;

import com.example.coursework.forms.ObjForm;
import com.example.coursework.forms.OfficerForm;
import com.example.coursework.model.Obj;
import com.example.coursework.model.Officers;
import com.example.coursework.model.OfficersRanks;
import com.example.coursework.service.Obj.Impls.ObjServiceImpls;
import com.example.coursework.service.Officers.Impls.OfficersServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping(value = "/ui/Obj")
@Controller
public class ObjUIController {
    @Autowired
    ObjServiceImpls service;

    @RequestMapping(value = "/get/all")
    public String showAll(Model model){
        List<Obj> objs = service.getAll();
        model.addAttribute("objs", objs);
        //  model.addAttribute("items", service.getAll());
        return "obj/obj-page";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/Obj/get/all";
    }
    @GetMapping(value = "create")
    public String create(Model model){
        ObjForm objForm = new ObjForm();
        model.addAttribute("form", objForm);
        return "obj/obj-create";
    }
    @PostMapping(value = "create")
    public String create( @ModelAttribute("objForm") ObjForm objForm){

        Obj obj = new Obj();
        obj.setTypesOfBuildings(objForm.getTypesOfBuildings());

        service.create(obj);
        return "redirect:/ui/Obj/get/all";
    }
    @GetMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        Obj obj = service.getById(id);
        ObjForm objForm = new ObjForm();
        objForm.setId(id);
        objForm.setTypesOfBuildings(obj.getTypesOfBuildings());
        model.addAttribute("form", objForm);
        return "obj/obj-appdate";
    }
    @PostMapping(value = "edit/{id}")
    public String editStudent(Model model,
                              @ModelAttribute("form") ObjForm objForm,
                              @PathVariable("id") String id){
        Obj obj = new Obj();
        obj.setId(objForm.getId());
        obj.setTypesOfBuildings(objForm.getTypesOfBuildings());
        service.update(obj);
        return "redirect:/ui/Obj/get/all";
    }
}
