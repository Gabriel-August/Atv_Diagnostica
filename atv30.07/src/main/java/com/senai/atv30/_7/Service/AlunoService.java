package com.senai.atv30._7.Service;
import com.senai.atv30._7.Dto.AlunoDto;
import com.senai.atv30._7.Entity.Aluno;
import com.senai.atv30._7.Repository.AlunoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Transactional(readOnly = true)
    public AlunoDto buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));
    }

    @Transactional
    public AlunoDto criarAluno(AlunoDto alunoDto) {
        Aluno novoAluno = toEntity(alunoDto);
        Aluno alunoSalvo = alunoRepository.save(novoAluno);
        return toDto(alunoSalvo);
    }

    @Transactional(readOnly = true)
    public List<AlunoDto> buscarTodos() {
        List<Aluno> listaDeAlunos = alunoRepository.findAll();
        return listaDeAlunos.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public AlunoDto atualizarAluno(Long id, AlunoDto alunoDto) {
        Aluno alunoExistente = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado para atualização!"));

        alunoExistente.setNome(alunoDto.getNome());
        alunoExistente.setEmail(alunoDto.getEmail());
        alunoExistente.setCpf(alunoDto.getCpf());

        Aluno alunoAtualizado = alunoRepository.save(alunoExistente);

        return toDto(alunoAtualizado);
    }

    @Transactional
    public void deletarAluno(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado para exclusão!");
        }
        alunoRepository.deleteById(id);
    }

    private AlunoDto toDto(Aluno aluno) {
        return new AlunoDto(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf());
    }

    private Aluno toEntity(AlunoDto dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setCpf(dto.getCpf());
        return aluno;
    }
}