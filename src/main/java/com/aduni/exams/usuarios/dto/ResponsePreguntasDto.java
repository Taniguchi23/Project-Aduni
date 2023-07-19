package com.aduni.exams.usuarios.dto;

import com.aduni.exams.usuarios.entity.Alternativa;
import com.aduni.exams.usuarios.entity.Pregunta;
import lombok.Data;

import java.util.List;

@Data
public class ResponsePreguntasDto {
    private Pregunta pregunta;
    private List<Alternativa> alternativas;
}
