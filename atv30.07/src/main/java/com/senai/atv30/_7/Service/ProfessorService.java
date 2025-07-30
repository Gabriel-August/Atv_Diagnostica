package com.senai.atv30._7.Service;

import com.senai.atv30._7.Dto.ProfessorDto;
import com.senai.atv30._7.Entity.Professor;
import com.senai.atv30._7.Repository.ProfessorRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public ProfessorDto buscarPorId(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        return toDto(professor);
    }


    private ProfessorDto toDto(Professor professor) {
        return new ProfessorDto(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getCpf(),
                professor.getEspecialidade()
        );
    }

    private Professor toEntity(ProfessorDto dto) {
        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());
        professor.setCpf(dto.getCpf());
        professor.setEspecialidade(dto.getEspecialidade());
        return professor;
    }
}
