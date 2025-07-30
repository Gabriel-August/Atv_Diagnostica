package com.senai.atv30._7.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDto {

    private Long id;
    private String nome;
    private String materia;
    private int cargaHoraria;
}
