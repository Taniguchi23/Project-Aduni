package com.aduni.exams.controller;


import com.aduni.exams.entity.Resultado;
import com.aduni.exams.service.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private ResultadoService resultadoService;
    @GetMapping("/historial")
    public String historial(Model model){


        List<Resultado> listaResultado = resultadoService.listaResultados(1);
        model.addAttribute("listaResultado",listaResultado);
        return "home/historial/index";
    }
}
