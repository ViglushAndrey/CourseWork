package com.example.coursework.controller.rest;

import com.example.coursework.forms.PermamentDisForm;
import com.example.coursework.model.PermanentDislocation;
import com.example.coursework.service.PermamentDislocation.Impls.PermamentDislocationServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/PermanentDis")
@Controller
public class PermanentDislocationRestController {

    @Autowired
    PermamentDislocationServiceImpls service;


}
