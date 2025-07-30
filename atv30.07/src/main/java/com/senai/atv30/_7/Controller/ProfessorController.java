package com.senai.atv30._7.Controller;
import com.senai.atv30._7.Dto.ProfessorDto;
import com.senai.atv30._7.Service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<ProfessorDto>> listarTodos() {
        return ResponseEntity.ok(professorService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProfessorDto> criar(@RequestBody ProfessorDto professorDto) {
        ProfessorDto novoProfessor = professorService.criarProfessor(professorDto);
        return new ResponseEntity<>(novoProfessor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorDto> atualizar(@PathVariable Long id, @RequestBody ProfessorDto professorDto) {
        ProfessorDto professorAtualizado = professorService.atualizarProfessor(id, professorDto);
        return ResponseEntity.ok(professorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        professorService.deletarProfessor(id);
        return ResponseEntity.noContent().build();
    }
}