package com.huariservice.gerenciamento_bibliotece.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity // essa anotação fala para o banco que essa tabela é uma entidade
@Table(name = "emprestimos")// vai falar que o nome da tabela vai ser exatamente essa
// estou colocando em minusculos para faciitar a busca
public class Emprestimos {
    @Id // vai falar que o id vai ser uma chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // diz que o ID sera gerado automaticamente pelo banco de dados
    private Long id;
    @ManyToOne // vai falar que é uma relação de muitos para um, muitos para um unico livro
    @JoinColumn(name = "livro_id", nullable = false)// Cria uma coluna de Chave Estrangeira
    private Livro livro;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @Column(name = "dt_emprestimo", nullable = false)//vai definir no banco o nome e vai dizer que éobrigatorio
    private LocalDate dtemprestimos;//Data e hora em que o livro foi emprestado
    @Column(name = "dt_devolucao", nullable = false) //Data estimada da devolucao
    private LocalDate dtdevolucao;
    @Enumerated(EnumType.STRING)// vai dizer que o campo é um enum,O STRING faz com que o banco salve uma palavra
    @Column(nullable = false)//é obrigatorio
    private Status status;
    @Column(name = "data_cadastro", updatable = false)// o updatable = false vai garantir que não seja alterado dps
    private LocalDateTime dtcadastro; //Data e hora em que o emprestimo foi cadastrado no sistema

    public Emprestimos() {//o jpa precisa de um construtor vazio para conseguir montar os objetos
    }
    // o construtor sem id é usado para criar um novo empréstimo no código
    public Emprestimos( Livro livro, Usuario usuario, LocalDate dtemprestimos, LocalDate dtdevolucao, Status status, LocalDateTime dtcadastro) {
        this.livro = livro;
        this.usuario = usuario;
        this.dtemprestimos = dtemprestimos;
        this.dtdevolucao = dtdevolucao;
        this.status = status;
        this.dtcadastro = dtcadastro;
    }
    // o com id Usado caso voce precise criar um objeto onde já se sabe o ID
    public Emprestimos(Long id, Livro livro, Usuario usuario, LocalDate dtemprestimos, LocalDate dtdevolucao, Status status, LocalDateTime dtcadastro) {
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.dtemprestimos = dtemprestimos;
        this.dtdevolucao = dtdevolucao;
        this.status = status;
        this.dtcadastro = dtcadastro;
    }
    //Getters e Setters

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