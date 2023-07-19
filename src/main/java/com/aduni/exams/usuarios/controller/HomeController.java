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

    @GetMapping("/generador")
    public String generador(Model model){
        return "/home/examenes/generador";
    }

    @PostMapping("/evaluacion")
    public String procesarRespuestas(@RequestParam Map<String, String> allParams, RedirectAttributes redirectAttributes) {
        // Aquí puedes acceder a las respuestas del examen enviadas desde el formulario
        // El mapa "allParams" contendrá los nombres de los campos y los valores enviados
        var nota = 0;
        // Procesar las respuestas y guardar los resultados, por ejemplo:
      /*  for (Map.Entry<String, String> entry : allParams.entrySet()) {
            String preguntaId = entry.getKey().split("_")[1]; // Obtener el id de la pregunta del nombre del campo
            String respuestaSeleccionada = entry.getValue(); // Obtener la alternativa seleccionada por el usuario
            // Procesar la respuesta y guardarla en la base de datos si es necesario
            if (preguntaService.resultadoPregunta(Integer.parseInt(preguntaId)) == Integer.parseInt(respuestaSeleccionada) ){
                nota ++;
            }
        }*/

        Skill skill =  skillService.entregarNota(allParams);

        // Redireccionar a una página de agradecimiento o resultados

        redirectAttributes.addFlashAttribute("skill", skill);
        return "redirect:/home/entrada/termino";
    }
}
