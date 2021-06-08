package com.example.coursework.controller.rest;

import com.example.coursework.forms.PistolsForm;
import com.example.coursework.model.Pistols;
import com.example.coursework.service.Pistols.Impls.PistolsServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/Pistols")
@Controller
public class PistolsRestController {
    @Autowired
    PistolsServiceImpls service;


}
