package com.aduni.exams.usuarios.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "preguntas")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","alternativas"})
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer curso_id;
    private String pregunta;
    private Integer respuesta;


}
