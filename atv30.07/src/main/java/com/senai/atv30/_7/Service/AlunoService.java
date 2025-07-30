package com.senai.atv30._7.Service;

import com.senai.atv30._7.Dto.AlunoDto;
import com.senai.atv30._7.Entity.Aluno;
import com.senai.atv30._7.Repository.AlunoRepository;
import org.springframework.stereotype.Service;
// Importe suas classes Aluno, AlunoDto e AlunoRepository

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository; // Supondo que você tenha um Repository
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public AlunoDto buscarPorId(Long id) {
        Aluno alunoEntity = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        return toDto(alunoEntity);
    }

    public AlunoDto criarAluno(AlunoDto alunoDto) {
        Aluno novoAluno = toEntity(alunoDto);

        Aluno alunoSalvo = alunoRepository.save(novoAluno);

        return toDto(alunoSalvo);
    }

    private AlunoDto toDto(Aluno aluno) {
        return new AlunoDto(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getCpf()
        );
    }

    // Converte de DTO para Entidade
    private Aluno toEntity(AlunoDto dto) {
        Aluno aluno = new Aluno();
       aluno.setNome(dto.getNome());
       aluno.setEmail(dto.getEmail());
       aluno.setCpf(dto.getCpf());
        return aluno;
    }
}