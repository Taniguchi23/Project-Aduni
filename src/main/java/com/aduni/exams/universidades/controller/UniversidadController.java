package com.aduni.exams.universidades.controller;

import com.aduni.exams.universidades.service.UniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/universidades")
public class UniversidadController {
    @Autowired
    private  UniversidadService universidadService;
    @GetMapping
    public String index(){
       var lista =  universidadService.findUniversidadAll();
        return "/estudiante/universidad/index";
    }
}
