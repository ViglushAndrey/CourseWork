package com.example.coursework.controller.rest;


import com.example.coursework.forms.MachinesGunsForm;
import com.example.coursework.model.MachinesGuns;
import com.example.coursework.service.MachinesGuns.Impls.MachinesGunsServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/MachinesGuns")
@Controller
public class MachinesRestUIController {

    @Autowired
    MachinesGunsServiceImpls service;



}
