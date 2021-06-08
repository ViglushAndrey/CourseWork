package com.example.coursework.controller.rest;

import com.example.coursework.forms.TractorForm;
import com.example.coursework.model.Tractor;
import com.example.coursework.service.Tractor.Impls.TractorServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/Tractor")
@Controller
public class TractorRestController {

    @Autowired
    TractorServiceImpls service;


}
