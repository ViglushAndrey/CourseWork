package com.example.coursework.controller.rest;

import com.example.coursework.forms.SniperRiflesForm;
import com.example.coursework.model.SniperRifles;
import com.example.coursework.service.SniperRifles.Impls.SniperRiflesServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/SniperRifles")
@Controller
public class SniperRiflesRestController {

    @Autowired
    SniperRiflesServiceImpls service;



}
