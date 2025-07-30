package com.senai.atv30._7.Service;
import com.senai.atv30._7.Dto.ProfessorDto;
import com.senai.atv30._7.Entity.Professor;
import com.senai.atv30._7.Repository.ProfessorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Transactional(readOnly = true)
    public ProfessorDto buscarPorId(Long id) {
        return professorRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado!"));
    }

    @Transactional
    public ProfessorDto criarProfessor(ProfessorDto professorDto) {
        Professor novoProfessor = toEntity(professorDto);
        Professor professorSalvo = professorRepository.save(novoProfessor);
        return toDto(professorSalvo);
    }

    @Transactional(readOnly = true)
    public List<ProfessorDto> buscarTodos() {
        return professorRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProfessorDto atualizarProfessor(Long id, ProfessorDto professorDto) {
        Professor professorExistente = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado para atualização!"));

        professorExistente.setNome(professorDto.getNome());
        professorExistente.setEmail(professorDto.getEmail());
        professorExistente.setCpf(professorDto.getCpf());
        professorExistente.setEspecialidade(professorDto.getEspecialidade());

        Professor professorAtualizado = professorRepository.save(professorExistente);
        return toDto(professorAtualizado);
    }

    @Transactional
    public void deletarProfessor(Long id) {
        if (!professorRepository.existsById(id)) {
            throw new RuntimeException("Professor não encontrado para exclusão!");
        }
        professorRepository.deleteById(id);
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