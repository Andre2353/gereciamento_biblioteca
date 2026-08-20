package com.huariservice.gerenciamento_bibliotece.service;

import com.huariservice.gerenciamento_bibliotece.DTO.EmprestimoRequestDTO;
import com.huariservice.gerenciamento_bibliotece.DTO.EmprestimosResponseDTO;
import com.huariservice.gerenciamento_bibliotece.entities.*;
import com.huariservice.gerenciamento_bibliotece.repository.EmprestimoRepository;
import com.huariservice.gerenciamento_bibliotece.repository.Livrorepository;
import com.huariservice.gerenciamento_bibliotece.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimosService {

    private final EmprestimoRepository emprestimoRepository;
    private final UsuarioRepository usuarioRepository;
    private final Livrorepository livroRepository;

    public EmprestimosService(EmprestimoRepository emprestimoRepository,
                              UsuarioRepository usuarioRepository,
                              Livrorepository livroRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.usuarioRepository = usuarioRepository;
        this.livroRepository = livroRepository;
    }

    // Criar empréstimo
    public EmprestimosResponseDTO criarEmprestimo(EmprestimoRequestDTO request) {
        Usuario usuario = buscarUsuario(request.getUsuarioid());
        Livro livro = buscarLivro(request.getLivroid());

        if (livro.getDisponivel() != Disponivel.DISPONIVEL) {
            throw new RuntimeException("Livro já está emprestado");
        }

        Emprestimos emprestimo = new Emprestimos();
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        emprestimo.setDtemprestimos(LocalDate.now());
        emprestimo.setDtdevolucao(LocalDate.now().plusDays(14));
        emprestimo.setStatus(Status.EMPRESTADO);

        // Trava o livro
        livro.setDisponivel(Disponivel.INDISPONIVEL);
        livroRepository.save(livro);

        return DTO(emprestimoRepository.save(emprestimo));
    }

    // Devolver livro
    public EmprestimosResponseDTO devolver(Long id) {
        Emprestimos emprestimo = buscarEmprestimo(id);

        if (emprestimo.getStatus() == Status.DEVOLVIDO) {
            throw new RuntimeException("Empréstimo já foi devolvido");
        }

       ;
        emprestimo.setStatus(Status.DEVOLVIDO);

        // Libera o livro
        Livro livro = emprestimo.getLivro();
        livro.setDisponivel(Disponivel.DISPONIVEL);
        livroRepository.save(livro);

        return DTO(emprestimoRepository.save(emprestimo));
    }

    // Listar todos
    public List<EmprestimosResponseDTO> listarTodos() {
        return emprestimoRepository.findAll()
                .stream()
                .map(this::DTO)
                .toList();
    }

    // Buscar por ID
    public EmprestimosResponseDTO buscarPorId(Long id) {
        return DTO(buscarEmprestimo(id));
    }


    private Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    private Livro buscarLivro(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    private Emprestimos buscarEmprestimo(Long id) {
        return emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));
    }

    private EmprestimosResponseDTO DTO(Emprestimos emprestimo) {
        EmprestimosResponseDTO dto = new EmprestimosResponseDTO();
        dto.setId(emprestimo.getId());
        dto.setLivroId(emprestimo.getLivro().getId());
        dto.setLivroTitulo(emprestimo.getLivro().getTitulo());
        dto.setUsuarioId(emprestimo.getUsuario().getId());
        dto.setUsuarioNome(emprestimo.getUsuario().getNome());
        dto.setDtemprestimos(emprestimo.getDtemprestimos());
        dto.setDtdevolucao(emprestimo.getDtdevolucao());
        dto.setStatus(emprestimo.getStatus());
        dto.setDtcadastro(emprestimo.getDtcadastro());
        return dto;
    }
}