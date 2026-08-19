package com.huariservice.gerenciamento_bibliotece.service;

import com.huariservice.gerenciamento_bibliotece.DTO.EmprestimoRequestDTO;
import com.huariservice.gerenciamento_bibliotece.DTO.EmprestimosResponseDTO;
import com.huariservice.gerenciamento_bibliotece.entities.Emprestimos;
import com.huariservice.gerenciamento_bibliotece.entities.Livro;
import com.huariservice.gerenciamento_bibliotece.entities.Status;
import com.huariservice.gerenciamento_bibliotece.entities.Usuario;
import com.huariservice.gerenciamento_bibliotece.repository.EmprestimoRepository;
import com.huariservice.gerenciamento_bibliotece.repository.Livrorepository;
import com.huariservice.gerenciamento_bibliotece.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmprestimosService {


        private final EmprestimoRepository emprestimoRepository;
        private final UsuarioRepository usuarioRepository;
        private final Livrorepository livrorepository;

        public EmprestimosService(EmprestimoRepository emprestimoRepository,
                                  UsuarioRepository usuarioRepository,
                                  Livrorepository livrorepository) {
            this.emprestimoRepository = emprestimoRepository;
            this.usuarioRepository = usuarioRepository;
            this.livrorepository = livrorepository;
        }

        public EmprestimosResponseDTO criarEmprestimo(EmprestimoRequestDTO request) {
            Usuario usuario = usuarioRepository.findById(request.getUsuarioid())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + request.getUsuarioid()));

            Livro livro = livrorepository.findById(request.getLivroid())
                    .orElseThrow(() -> new RuntimeException("Livro não encontrado: " + request.getLivroid()));

            Emprestimos emprestimo = new Emprestimos();
            emprestimo.setLivro(livro);
            emprestimo.setUsuario(usuario);
            emprestimo.setDtemprestimos(LocalDate.now());
            emprestimo.setDtdevolucao(LocalDate.now().plusDays(14));
            emprestimo.setStatus(Status.ATRASADO);
            emprestimo.setDtcadastro(LocalDateTime.now());

            Emprestimos emprestimosalvo = emprestimoRepository.save(emprestimo);

            EmprestimosResponseDTO response = new EmprestimosResponseDTO();
            response.setId(emprestimosalvo.getId());
            response.setLivro(emprestimosalvo.getLivro());
            response.setUsuario(emprestimosalvo.getUsuario());
            response.setDtemprestimos(emprestimosalvo.getDtemprestimos());
            response.setDtdevolucao(emprestimosalvo.getDtdevolucao());
            response.setDtdevolucaoreal(emprestimosalvo.getDtdevolucaoreal());
            response.setStatus(emprestimosalvo.getStatus());
            response.setDtcadastro(emprestimosalvo.getDtcadastro());

            return response;
        }

        public List<EmprestimosResponseDTO> listarEmprestimos() {
            return emprestimoRepository.findAll().stream()
                    .map(emprestimo -> {
                        EmprestimosResponseDTO response = new EmprestimosResponseDTO();
                        response.setId(emprestimo.getId());
                        response.setLivro(emprestimo.getLivro());
                        response.setUsuario(emprestimo.getUsuario());
                        response.setDtemprestimos(emprestimo.getDtemprestimos());
                        response.setDtdevolucao(emprestimo.getDtdevolucao());
                        response.setDtdevolucaoreal(emprestimo.getDtdevolucaoreal());
                        response.setStatus(emprestimo.getStatus());
                        response.setDtcadastro(emprestimo.getDtcadastro());
                        return response;
                    })
                    .toList();
        }

        public EmprestimosResponseDTO buscarid(long id) {
            Emprestimos emprestimo = emprestimoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado: " + id));

            EmprestimosResponseDTO response = new EmprestimosResponseDTO();
            response.setId(emprestimo.getId());
            response.setLivro(emprestimo.getLivro());
            response.setUsuario(emprestimo.getUsuario());
            response.setDtemprestimos(emprestimo.getDtemprestimos());
            response.setDtdevolucao(emprestimo.getDtdevolucao());
            response.setDtdevolucaoreal(emprestimo.getDtdevolucaoreal());
            response.setStatus(emprestimo.getStatus());
            response.setDtcadastro(emprestimo.getDtcadastro());

            return response;
        }

        public String atualizarid(Long id, Emprestimos emprestimoatualizado) {
            Emprestimos emprestimoexistente = emprestimoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado: " + id));

            emprestimoexistente.setLivro(emprestimoatualizado.getLivro());
            emprestimoexistente.setUsuario(emprestimoatualizado.getUsuario());
            emprestimoexistente.setDtemprestimos(emprestimoatualizado.getDtemprestimos());
            emprestimoexistente.setDtdevolucao(emprestimoatualizado.getDtdevolucao());
            emprestimoexistente.setDtdevolucaoreal(emprestimoatualizado.getDtdevolucaoreal());
            emprestimoexistente.setStatus(emprestimoatualizado.getStatus());

            emprestimoRepository.save(emprestimoexistente);
            return "Empréstimo atualizado com sucesso";
        }
    }

