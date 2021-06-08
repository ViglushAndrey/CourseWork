package com.example.coursework.controller.rest;

import com.example.coursework.forms.TanksForm;
import com.example.coursework.model.Tanks;
import com.example.coursework.service.Tanks.Impls.TanksServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/Tanks")
@Controller
public class TanksRestController {


    @Autowired
    TanksServiceImpls service;



}
