package com.huariservice.gerenciamento_bibliotece.service;

import com.huariservice.gerenciamento_bibliotece.DTO.LivroRequestDTO;
import com.huariservice.gerenciamento_bibliotece.DTO.LivroResponseDTO;
import com.huariservice.gerenciamento_bibliotece.entities.Disponivel;
import com.huariservice.gerenciamento_bibliotece.entities.Livro;
import com.huariservice.gerenciamento_bibliotece.repository.Livrorepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final Livrorepository livrorepository;

    public LivroService(Livrorepository livrorepository) {
        this.livrorepository = livrorepository;
    }

    public LivroResponseDTO criarLivro(LivroRequestDTO request) {
        Livro livro = new Livro();
        livro.setTitulo(request.getTitulo());
        livro.setAutor(request.getAutor());
        livro.setIsbn(request.getIsbn());
        livro.setAnopublicacao(request.getAnodepublicacao());
        livro.setEditora(request.getEditora());
        livro.setDisponivel(Disponivel.DISPONIVEL);
        livro.setDtcadastro(LocalDateTime.now());

        // Guarda a instância retornada com o ID populado pelo banco
        Livro livrosalvo = livrorepository.save(livro);

        return new LivroResponseDTO(
                livrosalvo.getId(),
                livrosalvo.getTitulo(),
                livrosalvo.getAutor(),
                livrosalvo.getIsbn(),
                livrosalvo.getAnopublicacao(),
                livrosalvo.getEditora(),
                livrosalvo.getDisponivel(),
                livrosalvo.getDtcadastro()
        );
    }


    public List<LivroResponseDTO> listarLivros() {
        return livrorepository.findAll().stream()
                .map(livro -> new LivroResponseDTO(
                        livro.getId(), // Corrigido para 'livro.getId()' (L minúsculo)
                        livro.getTitulo(),
                        livro.getAutor(),
                        livro.getIsbn(),
                        livro.getAnopublicacao(),
                        livro.getEditora(),
                        livro.getDisponivel(),
                        livro.getDtcadastro()))
                .toList();
    }

    public LivroResponseDTO buscarPorId(Long id) {
        Livro livro = livrorepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com o ID: " + id));

        LivroResponseDTO livroResponse = new LivroResponseDTO();
        livroResponse.setId(livro.getId());
        livroResponse.setTitulo(livro.getTitulo());
        livroResponse.setAutor(livro.getAutor());
        livroResponse.setIsbn(livro.getIsbn());
        livroResponse.setAnopublicacao(livro.getAnopublicacao());
        livroResponse.setEditora(livro.getEditora());
        livroResponse.setDisponivel(livro.getDisponivel());
        livroResponse.setDtcadastro(livro.getDtcadastro());

        return livroResponse;
    }
    public String deletar(long id) {
        Optional<Livro> livro = livrorepository.findById(id);
        if (livro.isEmpty()) {
            return "Usuário não existe";
        } else {
            livrorepository.deleteById(id);
            return "Usuário kickado";
        }
    }
    public LivroResponseDTO atualizarid(Long id, LivroRequestDTO request) {
        Livro livroexistente = livrorepository.findById(id).get();

        livroexistente.setTitulo(request.getTitulo());
        livroexistente.setAutor(request.getAutor());
        livroexistente.setIsbn(request.getIsbn());
        livroexistente.setAnopublicacao(request.getAnodepublicacao());
        livroexistente.setEditora(request.getEditora());

        Livro atualizado = livrorepository.save(livroexistente);

        return new LivroResponseDTO(
                atualizado.getId(),
                atualizado.getTitulo(),
                atualizado.getAutor(),
                atualizado.getIsbn(),
                atualizado.getAnopublicacao(),
                atualizado.getEditora(),
                atualizado.getDisponivel(),
                atualizado.getDtcadastro()
        );
    }
}