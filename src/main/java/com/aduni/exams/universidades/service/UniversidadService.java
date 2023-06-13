package com.aduni.exams.universidades.service;

import com.aduni.exams.universidades.entity.Universidad;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UniversidadService {

    List<Universidad> findUniversidadAll();
}
