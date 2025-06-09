package com.example.universidadeESN3.controller;

import com.example.universidadeESN3.entity.Professor;
import com.example.universidadeESN3.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> buscarTodos() {
        return ResponseEntity.ok(professorService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarPorId(@PathVariable Long id) {
        Professor professor = professorService.buscarPorId(id);
        if (professor != null) {
            return ResponseEntity.ok(professor);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Professor> salvar(@RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.salvar(professor));
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody Professor professor) {
        professorService.atualizar(professor);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        professorService.excluir(id);
        return ResponseEntity.ok().build();
    }
}