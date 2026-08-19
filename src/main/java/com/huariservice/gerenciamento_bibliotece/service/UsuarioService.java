package com.huariservice.gerenciamento_bibliotece.service;

import com.huariservice.gerenciamento_bibliotece.DTO.UsuarioRequestDTO;
import com.huariservice.gerenciamento_bibliotece.DTO.UsuarioResponseDTO;
import com.huariservice.gerenciamento_bibliotece.entities.Usuario;
import com.huariservice.gerenciamento_bibliotece.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO request) {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setTelefone(request.getTelefone());
        usuario.setDtcadastro(LocalDateTime.now());

        // Guarda a instância retornada com o ID populado pelo banco
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        // Retorna o ResponseDTO passando o ID gerado
        return new UsuarioResponseDTO(
                usuarioSalvo.getId(),
                usuarioSalvo.getNome(),
                usuarioSalvo.getEmail(),
                usuarioSalvo.getTelefone(),
                usuarioSalvo.getDtcadastro()
        );
    }

    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> new UsuarioResponseDTO(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getDtcadastro()))
                .toList();
    }

    public UsuarioResponseDTO buscarid(long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + id));

        UsuarioResponseDTO usuarioResponse = new UsuarioResponseDTO();
        usuarioResponse.setId(usuario.getId());
        usuarioResponse.setDtcadastro(usuario.getDtcadastro());
        usuarioResponse.setNome(usuario.getNome());
        usuarioResponse.setEmail(usuario.getEmail());
        return usuarioResponse;
    }

    public String deletar(long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            return "Usuário não existe";
        } else {
            usuarioRepository.deleteById(id);
            return "Usuário kickado";
        }
    }
    public String atualizarid(Long id, Usuario usuarioatualizado) {
        Usuario usuarioexistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("usuario não encontrado: " + id));

        usuarioexistente.setNome(usuarioatualizado.getNome());
        usuarioexistente.setEmail(usuarioatualizado.getEmail());
        usuarioexistente.setTelefone(usuarioatualizado.getTelefone());

        usuarioRepository.save(usuarioexistente);
        return "usuario atualizado com sucesso";
    }

}

