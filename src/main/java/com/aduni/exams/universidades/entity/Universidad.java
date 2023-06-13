package com.aduni.exams.universidades.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "universidades")
@Data
public class Universidad {
    @Id
    private Integer id;
    private String nombre;


}
