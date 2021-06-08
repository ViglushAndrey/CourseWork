package com.example.coursework.controller.rest;

import com.example.coursework.forms.TransportEquipmentForm;
import com.example.coursework.model.FreightCar;
import com.example.coursework.model.Tractor;
import com.example.coursework.model.TransportEquipment;
import com.example.coursework.repository.FreightCar.FreightCarRepository;
import com.example.coursework.repository.Tractor.TractorRepository;
import com.example.coursework.repository.TransportEquipment.TransportEquipmentRepository;
import com.example.coursework.service.FreightCar.Impls.FreightCarServiceImpls;
import com.example.coursework.service.Tractor.Impls.TractorServiceImpls;
import com.example.coursework.service.TransportEquipment.Impls.TransportEquipmentServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/ui/TransportEquip")
@Controller
public class TransportEquipmentRestController {

    @Autowired
    TransportEquipmentServiceImpls service;



}
