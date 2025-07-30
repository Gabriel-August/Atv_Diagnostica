package com.senai.atv30._7.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurmaDto {
    private Long id;
    private int ano;
    private int semestre;
    private String turno;
    private Long cursoId;
    private String cursoNome;
    private Long professorId;
    private String professorNome;
    private int totalAlunos;
}
