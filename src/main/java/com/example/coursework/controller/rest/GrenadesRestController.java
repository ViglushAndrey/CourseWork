package com.example.coursework.controller.rest;

import com.example.coursework.forms.GrenadesForm;
import com.example.coursework.model.Grenades;
import com.example.coursework.service.Grenades.Impls.GrenadesServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/Grenades")
@Controller
public class GrenadesRestController {

    @Autowired
    GrenadesServiceImpls service;



}
