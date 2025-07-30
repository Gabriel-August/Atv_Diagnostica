package com.senai.atv30._7.Controller;
import com.senai.atv30._7.Dto.AlunoDto;
import com.senai.atv30._7.Service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<AlunoDto>> listarTodos() {
        List<AlunoDto> alunos = alunoService.buscarTodos();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> buscarPorId(@PathVariable Long id) {
        AlunoDto aluno = alunoService.buscarPorId(id);
        return ResponseEntity.ok(aluno);
    }

    @PostMapping
    public ResponseEntity<AlunoDto> criar(@RequestBody AlunoDto alunoDto) {
        AlunoDto novoAluno = alunoService.criarAluno(alunoDto);
        return new ResponseEntity<>(novoAluno, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDto> atualizar(@PathVariable Long id, @RequestBody AlunoDto alunoDto) {
        AlunoDto alunoAtualizado = alunoService.atualizarAluno(id, alunoDto);
        return ResponseEntity.ok(alunoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}