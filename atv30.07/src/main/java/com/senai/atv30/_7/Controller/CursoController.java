package com.senai.atv30._7.Controller;

import com.senai.atv30._7.Dto.CursoDto;
import com.senai.atv30._7.Service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<CursoDto>> listarTodos() {
        return ResponseEntity.ok(cursoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<CursoDto> criar(@RequestBody CursoDto cursoDto) {
        CursoDto novoCurso = cursoService.criarCurso(cursoDto);
        return new ResponseEntity<>(novoCurso, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDto> atualizar(@PathVariable Long id, @RequestBody CursoDto cursoDto) {
        CursoDto cursoAtualizado = cursoService.atualizarCurso(id, cursoDto);
        return ResponseEntity.ok(cursoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cursoService.deletarCurso(id);
        return ResponseEntity.noContent().build();
    }
}
