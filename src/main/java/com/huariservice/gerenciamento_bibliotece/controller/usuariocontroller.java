package com.huariservice.gerenciamento_bibliotece.controller;

import com.huariservice.gerenciamento_bibliotece.dto.UsuarioRequest;
import com.huariservice.gerenciamento_bibliotece.dto.UsuarioResponse;
import com.huariservice.gerenciamento_bibliotece.model.Usuario;
import com.huariservice.gerenciamento_bibliotece.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<String> criarUsuario(@Valid @RequestBody UsuarioRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Criado com sucesso: " + usuarioService.criarUsuario(req));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> mostrar() {
        return ResponseEntity.ok(usuarioService.mostrarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(usuarioService.buscarId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.deletar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarPorId(@PathVariable Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.atualizarId(id, usuario));
    }
}