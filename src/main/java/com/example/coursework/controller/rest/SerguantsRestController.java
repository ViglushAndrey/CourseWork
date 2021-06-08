package com.example.coursework.controller.rest;

import com.example.coursework.forms.SerguantsForm;
import com.example.coursework.model.Serguants;
import com.example.coursework.model.SerguantsRanks;
import com.example.coursework.service.Serguants.Impls.SerguantsServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping(value = "/ui/Serguants")
@Controller
public class SerguantsRestController {
    @Autowired
    SerguantsServiceImpls service;


}
