package com.example.universidadeESN3.service;

import com.example.universidadeESN3.entity.Professor;
import com.example.universidadeESN3.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> buscarTodos() {
        return professorRepository.findAll();
    }

    public Professor buscarPorId(Long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        return professor.orElse(null);
    }

    public Professor salvar(Professor professor) {
        return professorRepository.save(professor);
    }

    public void atualizar(Professor professor) {
        if (professor.getId() != null && professorRepository.existsById(professor.getId())) {
            professorRepository.save(professor);
        }
    }

    public void excluir(Long id) {
        professorRepository.deleteById(id);
    }
}