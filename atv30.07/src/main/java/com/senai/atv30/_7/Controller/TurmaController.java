package com.senai.atv30._7.Controller;

import com.senai.atv30._7.Dto.TurmaDto;
import com.senai.atv30._7.Service.TurmaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/turmas")
public class TurmaController {

    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping
    public ResponseEntity<List<TurmaDto>> listarTodos() {
        return ResponseEntity.ok(turmaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(turmaService.buscarPorId(id));
    }

    // Os métodos de Criar e Atualizar uma Turma são mais complexos e
    // geralmente precisam de um DTO de entrada específico (ex: CriarTurmaDto)

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        turmaService.deletarTurma(id);
        return ResponseEntity.noContent().build();
    }
}
