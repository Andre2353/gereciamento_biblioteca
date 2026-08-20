package com.huariservice.gerenciamento_bibliotece.DTO;

import com.huariservice.gerenciamento_bibliotece.entities.Status;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmprestimosResponseDTO {

    private Long id;
    private Long livroId;
    private String livroTitulo;
    private Long usuarioId;
    private String usuarioNome;
    private LocalDate dtemprestimos;
    private LocalDate dtdevolucao;
    private LocalDate dtdevolucaoreal;
    private Status status;
    private LocalDateTime dtcadastro;

    public EmprestimosResponseDTO() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public String getLivroTitulo() {
        return livroTitulo;
    }

    public void setLivroTitulo(String livroTitulo) {
        this.livroTitulo = livroTitulo;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
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