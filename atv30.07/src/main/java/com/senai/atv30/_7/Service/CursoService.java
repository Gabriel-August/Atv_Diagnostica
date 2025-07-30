package com.senai.atv30._7.Service;
import com.senai.atv30._7.Dto.CursoDto;
import com.senai.atv30._7.Entity.Curso;
import com.senai.atv30._7.Repository.CursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Transactional(readOnly = true)
    public CursoDto buscarPorId(Long id) {
        return cursoRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado!"));
    }

    @Transactional
    public CursoDto criarCurso(CursoDto cursoDto) {
        Curso novoCurso = toEntity(cursoDto);
        Curso cursoSalvo = cursoRepository.save(novoCurso);
        return toDto(cursoSalvo);
    }

    @Transactional(readOnly = true)
    public List<CursoDto> buscarTodos() {
        return cursoRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public CursoDto atualizarCurso(Long id, CursoDto cursoDto) {
        Curso cursoExistente = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado para atualização!"));

        cursoExistente.setNome(cursoDto.getNome());
        cursoExistente.setMateria(cursoDto.getMateria());
        cursoExistente.setCargaHoraria(cursoDto.getCargaHoraria());

        Curso cursoAtualizado = cursoRepository.save(cursoExistente);
        return toDto(cursoAtualizado);
    }

    @Transactional
    public void deletarCurso(Long id) {
        if (!cursoRepository.existsById(id)) {
            throw new RuntimeException("Curso não encontrado para exclusão!");
        }
        cursoRepository.deleteById(id);
    }

    private CursoDto toDto(Curso curso) {
        return new CursoDto(
                curso.getId(),
                curso.getNome(),
                curso.getMateria(),
                curso.getCargaHoraria()
        );
    }

    private Curso toEntity(CursoDto dto) {
        Curso curso = new Curso();
        curso.setNome(dto.getNome());
        curso.setMateria(dto.getMateria());
        curso.setCargaHoraria(dto.getCargaHoraria());
        return curso;
    }
}