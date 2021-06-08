package com.example.coursework.controller.rest;

import com.example.coursework.forms.OrdinaryForm;
import com.example.coursework.model.OrdinaryRanks;
import com.example.coursework.model.Ordinarys;
import com.example.coursework.service.Ordinarys.Impls.OrdinarysServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping(value = "/ui/Ordinarys")
@Controller
public class OrdinarysRestController {

    @Autowired
    OrdinarysServiceImpls service;


}
