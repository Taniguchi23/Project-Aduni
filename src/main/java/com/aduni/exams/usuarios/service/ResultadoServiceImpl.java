package com.aduni.exams.usuarios.service;

import com.aduni.exams.usuarios.entity.Resultado;
import com.aduni.exams.usuarios.repository.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoServiceImpl implements ResultadoService{
    @Autowired
    private ResultadoRepository resultadoRepository;
    @Override
    public List<Resultado> listaResultados(int Id) {
        return resultadoRepository.findResultado(Id);
    }
}
