package com.example.coursework.controller.rest;

import com.example.coursework.forms.TemporaryDisForm;
import com.example.coursework.model.TemporaryDislocation;
import com.example.coursework.service.TemproraryDislocation.Impls.TemproraryDislocationServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/TemporaryDis")
@Controller
public class TemporaryDislocationRestContoller {

    @Autowired
    TemproraryDislocationServiceImpls service;



}
