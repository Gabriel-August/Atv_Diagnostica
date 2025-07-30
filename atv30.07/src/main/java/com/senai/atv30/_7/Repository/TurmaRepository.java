package com.senai.atv30._7.Repository;

import com.senai.atv30._7.Entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    List<Turma> findByCursoId(Long cursoId);

    List<Turma> findByProfessorId(Long professorId);

    List<Turma> findByAnoAndSemestre(int ano, int semestre);
}
