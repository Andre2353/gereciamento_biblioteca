package com.huariservice.gerenciamento_bibliotece.DTO;

import com.huariservice.gerenciamento_bibliotece.entities.Livro;
import com.huariservice.gerenciamento_bibliotece.entities.Status;
import com.huariservice.gerenciamento_bibliotece.entities.Usuario;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmprestimosResponseDTO {
    private Long id;
    private Livro livro;
    private Usuario usuario;
    private LocalDate dtemprestimos;
    private LocalDate dtdevolucao;
    private LocalDate dtdevolucaoreal;
    private Status status;
    private LocalDateTime dtcadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDtemprestimos() {
        return dtemprestimos;
    }

    public void setDtemprestimos(LocalDate dtemprestimos) {
        this.dtemprestimos = dtemprestimos;
    }

    public LocalDate getDtdevolucao() {
        return dtdevolucao;
    }

    public void setDtdevolucao(LocalDate dtdevolucao) {
        this.dtdevolucao = dtdevolucao;
    }

    public LocalDate getDtdevolucaoreal() {
        return dtdevolucaoreal;
    }

    public void setDtdevolucaoreal(LocalDate dtdevolucaoreal) {
        this.dtdevolucaoreal = dtdevolucaoreal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDtcadastro() {
        return dtcadastro;
    }

    public void setDtcadastro(LocalDateTime dtcadastro) {
        this.dtcadastro = dtcadastro;
    }
}
