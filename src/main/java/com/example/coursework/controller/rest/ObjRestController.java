package com.example.coursework.controller.rest;

import com.example.coursework.forms.ObjForm;
import com.example.coursework.model.Obj;
import com.example.coursework.service.Obj.Impls.ObjServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ui/Obj")
@Controller
public class ObjRestController {
    @Autowired
    ObjServiceImpls service;


}
