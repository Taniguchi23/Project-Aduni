package com.aduni.exams.usuarios.service;

import com.aduni.exams.usuarios.entity.Skill;

import java.util.Map;

public interface SkillService {
    Skill entregarNota(Map<String, String> allParams);

}
