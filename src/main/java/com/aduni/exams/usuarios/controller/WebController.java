package com.aduni.exams.usuarios.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/")
public class WebController {

    @GetMapping("/")
    public String index(){
        log.error("hola");
        return "web/index";
    }

    @GetMapping("/home")
    public String home(){
        return "home/index";
    }
}
