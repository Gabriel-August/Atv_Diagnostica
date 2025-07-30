package com.senai.atv30._7.Service;
import com.senai.atv30._7.Dto.TurmaDto;
import com.senai.atv30._7.Entity.Turma;
import com.senai.atv30._7.Repository.TurmaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    @Transactional(readOnly = true)
    public List<TurmaDto> buscarTodos() {
        return turmaRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TurmaDto buscarPorId(Long id) {
        return turmaRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada!"));
    }

    @Transactional
    public void deletarTurma(Long id) {
        if (!turmaRepository.existsById(id)) {
            throw new RuntimeException("Turma não encontrada para exclusão!");
        }
        turmaRepository.deleteById(id);
    }

    private TurmaDto toDto(Turma turma) {
        Long professorId = (turma.getProfessor() != null) ? turma.getProfessor().getId() : null;
        String professorNome = (turma.getProfessor() != null) ? turma.getProfessor().getNome() : null;

        return new TurmaDto(
                turma.getId(),
                turma.getAno(),
                turma.getSemestre(),
                turma.getTurno(),
                turma.getCurso().getId(),
                turma.getCurso().getNome(),
                professorId,
                professorNome,
                turma.getAlunos().size()
        );
    }

}