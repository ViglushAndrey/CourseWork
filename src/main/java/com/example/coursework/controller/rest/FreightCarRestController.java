package com.example.coursework.controller.rest;

import com.example.coursework.forms.FreightCarForm;
import com.example.coursework.model.FreightCar;
import com.example.coursework.service.FreightCar.Impls.FreightCarServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/FreightCar")
@Controller
public class FreightCarRestController {

    @Autowired
    FreightCarServiceImpls service;


}
