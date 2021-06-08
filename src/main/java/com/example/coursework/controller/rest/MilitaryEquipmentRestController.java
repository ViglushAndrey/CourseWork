package com.example.coursework.controller.rest;


import com.example.coursework.forms.MilitaryEquipmentForm;
import com.example.coursework.model.BMP;
import com.example.coursework.model.BTR;
import com.example.coursework.model.MilitaryEquipment;
import com.example.coursework.model.Tanks;
import com.example.coursework.repository.BMP.BMPRepository;
import com.example.coursework.repository.BTR.BTRRepository;
import com.example.coursework.repository.MilitaryEquipment.MilitaryEquipmentRepository;
import com.example.coursework.repository.Tanks.TanksRepository;
import com.example.coursework.service.BMP.Impls.BMPServiceImpls;
import com.example.coursework.service.BTR.Impls.BTRServiceImpls;
import com.example.coursework.service.MilitaryEquipment.Impls.MilitaryEquipmentServiceImpls;
import com.example.coursework.service.Tanks.Impls.TanksServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/ui/MilitaryEquipment")
@Controller
public class MilitaryEquipmentRestController {

    @Autowired
    MilitaryEquipmentServiceImpls service;



}
