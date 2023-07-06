package com.aduni.exams.controller;


import com.aduni.exams.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/login")
    public String login(){
        boolean respuesta = usuariosService.Login("sdsdsd","dssdsd");

        return "/index";
    }
}
