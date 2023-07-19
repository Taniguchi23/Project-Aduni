package com.aduni.exams.usuarios.service;

import com.aduni.exams.usuarios.dto.ResponsePreguntasDto;

import java.util.List;

public interface PreguntaService {
    List<ResponsePreguntasDto> generarPreguntas();
    Boolean verificarRespuesta(Integer idPregunta,Integer idRespuesta);
}
