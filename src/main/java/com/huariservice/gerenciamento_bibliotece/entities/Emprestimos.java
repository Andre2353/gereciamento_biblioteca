package com.huariservice.gerenciamento_bibliotece.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "emprestimos")
public class Emprestimos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;
    @ManyToOne
    @JoinColumn(name = "usuario_id",nullable = false)
    private Usuario usuario;
    @Column(name = "dt_emprestimo",nullable = false)//Data e hora em que o livro foi emprestado
    private LocalDate dtemprestimos;
    @Column(name = "dt_devolucao",nullable = false) //Data estimada da devolucao
    private LocalDate dtdevolucao;
    @Column(name = "dt_devolucao_real")//Data real da devolução do livro
    private LocalDate dtdevolucaoreal;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
    @Column(name = "data_cadastro",updatable = false)
    private LocalDateTime dtcadastro; //Data e hora em que o emprestimo foi cadastrado no sistema

    public Emprestimos() {
    }

    public Emprestimos( Livro livro, Usuario usuario, LocalDate dtemprestimos, LocalDate dtdevolucao, LocalDate dtdevolucaoreal, Status status, LocalDateTime dtcadastro) {
        this.livro = livro;
        this.usuario = usuario;
        this.dtemprestimos = dtemprestimos;
        this.dtdevolucao = dtdevolucao;
        this.dtdevolucaoreal = dtdevolucaoreal;
        this.status = status;
        this.dtcadastro = dtcadastro;
    }

    public Emprestimos(Long id, Livro livro, Usuario usuario, LocalDate dtemprestimos, LocalDate dtdevolucao, LocalDate dtdevolucaoreal, Status status, LocalDateTime dtcadastro) {
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.dtemprestimos = dtemprestimos;
        this.dtdevolucao = dtdevolucao;
        this.dtdevolucaoreal = dtdevolucaoreal;
        this.status = status;
        this.dtcadastro = dtcadastro;
    }

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
