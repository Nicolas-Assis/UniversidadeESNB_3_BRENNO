package com.example.universidadeESN3.service;

import com.example.universidadeESN3.entity.Aluno;
import com.example.universidadeESN3.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService{

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> buscarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public List<Aluno> buscarPorNome(String nome) {
        return alunoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Page<Aluno> listarPaginado(Pageable pageable) {
        return alunoRepository.findAll(pageable);
    }

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public ResponseEntity<?> atualizar(Aluno aluno) {
        if (aluno.getId() == null || !alunoRepository.existsById(aluno.getId())) {
            return ResponseEntity.notFound().build();
        }
        alunoRepository.save(aluno);
        return ResponseEntity.ok().build();
    }

    public void excluir(Long id) {
        alunoRepository.deleteById(id);
    }

    public void desativar(Aluno aluno) {
        alunoRepository.save(aluno);
    }
}