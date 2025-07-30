package com.senai.atv30._7.Repository;

import com.senai.atv30._7.Entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Optional<Curso> findByNome(String nome);

    List<Curso> findByMateria(String materia);

    List<Curso> findByNomeContainingIgnoreCase(String nome);

}
