package com.aduni.exams.usuarios.service;

import com.aduni.exams.usuarios.entity.Resultado;
import com.aduni.exams.usuarios.entity.Skill;

import java.util.List;
import java.util.Map;

public interface ResultadoService {
    List<Resultado> listaResultados(int Id);
    Resultado entregarNota(Map<String, String> allParams);
}
