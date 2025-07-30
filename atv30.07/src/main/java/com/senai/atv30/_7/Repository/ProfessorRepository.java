package com.senai.atv30._7.Repository;

import com.senai.atv30._7.Entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Optional<Professor> findByEmail(String email);

    Optional<Professor> findByCpf(String cpf);

    List<Professor> findByEspecialidade(String especialidade);
}
