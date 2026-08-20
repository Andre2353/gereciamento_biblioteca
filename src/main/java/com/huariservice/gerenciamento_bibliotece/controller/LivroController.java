package com.huariservice.gerenciamento_bibliotece.controller;

import com.huariservice.gerenciamento_bibliotece.DTO.LivroRequestDTO;
import com.huariservice.gerenciamento_bibliotece.DTO.LivroResponseDTO;
import com.huariservice.gerenciamento_bibliotece.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<LivroResponseDTO> criar(@RequestBody LivroRequestDTO request) {
        LivroResponseDTO response = livroService.criarLivro(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> listar() {
        return ResponseEntity.ok(livroService.listarLivros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> atualizar(@PathVariable Long id,@RequestBody LivroRequestDTO request) {
        return ResponseEntity.ok(livroService.atualizarid(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}