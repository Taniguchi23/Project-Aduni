package com.aduni.exams.usuarios.controller;


import com.aduni.exams.usuarios.dto.ResponsePreguntasDto;
import com.aduni.exams.usuarios.entity.Resultado;
import com.aduni.exams.usuarios.entity.Skill;
import com.aduni.exams.usuarios.service.PreguntaService;
import com.aduni.exams.usuarios.service.ResultadoService;
import com.aduni.exams.usuarios.service.SkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private PreguntaService preguntaService;
    @Autowired
    private ResultadoService resultadoService;

    @Autowired
    private SkillService skillService;
    @GetMapping
    public String home(Model model){
        Skill skill =  skillService.buscarSkill(1);
        Integer[] ahora = {skill.getHistoria_peru_b(), skill.getComunicacion_b(),skill.getBiologia_b(),skill.getHistoria_universal_b(),skill.getFilosofia_b(),skill.getEconomia_b()};
        Integer[] antes = {skill.getHistoria_peru_a(), skill.getComunicacion_a(),skill.getBiologia_a(),skill.getHistoria_universal_a(),skill.getFilosofia_a(),skill.getEconomia_a()};
        Integer[] biologia = resultadoService.listarnotas(5,1);
        Integer[] historia_universal = resultadoService.listarnotas(4,1);
        Integer[] filosofia = resultadoService.listarnotas(3,1);
        Integer[] economia = resultadoService.listarnotas(2,1);
        Integer[] comunicacion = resultadoService.listarnotas(6,1);
        Integer[] historia_peru = resultadoService.listarnotas(1,1);

        model.addAttribute("biologia",biologia);
        model.addAttribute("historia_universal",historia_universal);
        model.addAttribute("filosofia",filosofia);
        model.addAttribute("economia",economia);
        model.addAttribute("comunicacion",comunicacion);
        model.addAttribute("historia_peru",historia_peru);
        model.addAttribute("ahora",ahora);
        model.addAttribute("antes",antes);

        return "home/index";
    }


    @GetMapping("/historial")
    public String historial(Model model){
        List<Resultado> listaResultado = resultadoService.listaResultados(1);
        model.addAttribute("listaResultado",listaResultado);
        return "/home/historial/index";
    }

    @GetMapping("/entrada")
    public String entrada(Model model){
        List<ResponsePreguntasDto> listaPreguntas = preguntaService.generarPreguntas();
        model.addAttribute("preguntas",listaPreguntas);
        return "/home/examenes/medicion";
    }

    @GetMapping("/entrada/termino")
    public String termino(Model model,@ModelAttribute("nota") Skill skill){
      //  model.addAttribute("skill", skill);
        return "/home/examenes/termino";
    }
    @GetMapping("/entrada/nota")
    public String termino(Model model,@ModelAttribute("resultado") Resultado resultado){
        //  model.addAttribute("skill", skill);
        return "/home/examenes/nota";
    }

    @GetMapping("/generador")
    public String generador(Model model){
        return "/home/examenes/generador";
    }

    @PostMapping("/evaluacion")
    public String procesarRespuestas(@RequestParam Map<String, String> allParams, RedirectAttributes redirectAttributes) {
        Skill skill =  skillService.entregarNota(allParams);
        redirectAttributes.addFlashAttribute("skill", skill);
        return "redirect:/home/entrada/termino";
    }

    @PostMapping("/examen")
    public String examen(@RequestParam("curso") String idCurso, Model model ){
        List<ResponsePreguntasDto> responsePreguntasDtos = preguntaService.generarPreguntasByCurso(Integer.parseInt(idCurso));
        model.addAttribute("preguntas", responsePreguntasDtos);
        return "/home/examenes/examen";
    }

    @PostMapping("/corregir")
    public String procesarRespuestasPOrCurso(@RequestParam Map<String, String> allParams, RedirectAttributes redirectAttributes) {
        Resultado resultado =  resultadoService.entregarNota(allParams);
        redirectAttributes.addFlashAttribute("resultado", resultado);
        return "redirect:/home/entrada/nota";
    }
}
