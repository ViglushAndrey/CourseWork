package com.example.coursework.controller.rest;

import com.example.coursework.forms.GeneralsForm;
import com.example.coursework.model.Generals;
import com.example.coursework.model.GeneralsRanks;
import com.example.coursework.service.Generals.Impls.GeneralsServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping(value = "/ui/Generals")
@Controller
public class GeneralsRestController {

    @Autowired
    GeneralsServiceImpls service;


}
