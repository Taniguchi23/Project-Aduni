package com.aduni.exams.usuarios.service;

import com.aduni.exams.usuarios.dto.ResponsePreguntasDto;
import com.aduni.exams.usuarios.entity.Alternativa;
import com.aduni.exams.usuarios.entity.Pregunta;
import com.aduni.exams.usuarios.repository.AlternativaRepository;
import com.aduni.exams.usuarios.repository.PreguntaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class PreguntaServiceImpl implements PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private AlternativaRepository alternativaRepository;
    @Override
    public List<ResponsePreguntasDto> generarPreguntas() {
        List<ResponsePreguntasDto> responsePreguntasList = new ArrayList<>();
        List<Pregunta> preguntas1 = preguntaRepository.findRandomPreguntasWithAlternativasByCursoId(1,3);
        List<Pregunta> preguntas2 = preguntaRepository.findRandomPreguntasWithAlternativasByCursoId(2,3);
        List<Pregunta> preguntas3 = preguntaRepository.findRandomPreguntasWithAlternativasByCursoId(3,3);
        List<Pregunta> preguntas4 = preguntaRepository.findRandomPreguntasWithAlternativasByCursoId(4,3);
        List<Pregunta> preguntas5 = preguntaRepository.findRandomPreguntasWithAlternativasByCursoId(5,3);
        List<Pregunta> preguntas6 = preguntaRepository.findRandomPreguntasWithAlternativasByCursoId(6,3);
        List<Pregunta> preguntas = new ArrayList<>();;
        preguntas.addAll(preguntas1);
        preguntas.addAll(preguntas2);
        preguntas.addAll(preguntas3);
        preguntas.addAll(preguntas4);
        preguntas.addAll(preguntas5);
        preguntas.addAll(preguntas6);

        for (Pregunta pregunta : preguntas){
            List<Alternativa> listaAlternativa = alternativaRepository.findAlternativasByPreguntaId(pregunta.getId());
            ResponsePreguntasDto responsePreguntasDto = new ResponsePreguntasDto();
            responsePreguntasDto.setPregunta(pregunta);
            responsePreguntasDto.setAlternativas(listaAlternativa);
            responsePreguntasList.add(responsePreguntasDto);
        }
        return responsePreguntasList;
    }

    @Override
    public List<ResponsePreguntasDto> generarPreguntasByCurso(Integer idCurso) {
        List<ResponsePreguntasDto> responsePreguntasList = new ArrayList<>();
        List<Pregunta> preguntas = preguntaRepository.findRandomPreguntasWithAlternativasByCursoId(idCurso,20);


        for (Pregunta pregunta : preguntas){
            List<Alternativa> listaAlternativa = alternativaRepository.findAlternativasByPreguntaId(pregunta.getId());
            ResponsePreguntasDto responsePreguntasDto = new ResponsePreguntasDto();
            responsePreguntasDto.setPregunta(pregunta);
            responsePreguntasDto.setAlternativas(listaAlternativa);
            responsePreguntasList.add(responsePreguntasDto);
        }
        return responsePreguntasList;
    }

    @Override
    public Boolean verificarRespuesta(Integer idPregunta, Integer idRespuesta) {
        Pregunta pregunta = preguntaRepository.getById(idPregunta);

        return pregunta.getRespuesta() == idRespuesta;
    }


}
