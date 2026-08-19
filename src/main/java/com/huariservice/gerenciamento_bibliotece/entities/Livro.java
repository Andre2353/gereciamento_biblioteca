package com.huariservice.gerenciamento_bibliotece.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "livro") // Define o nome da tabela no banco de dados como "livro"
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,length = 150)
    private String titulo;
    @Column(nullable = false,length = 150)
    private String autor;
    @Column(nullable = false,unique = true)
    private String isbn;
    @Column(name = "ano_publicacao",nullable = false)
    private Integer anopublicacao;
    @Column(length = 100)
    private String editora;
    @Enumerated(EnumType.STRING)
    @Column(name = "Disponivel",nullable = false)
    private Disponivel disponivel;
    @Column(name = "data_cadastro",updatable = false)
    private LocalDateTime dtcadastro; //Data e hora em que o livro foi cadastrado no sistema

    public Livro() {
    }

    public Livro( String titulo, String autor, String isbn, Integer anopublicacao, String editora, Disponivel disponivel, LocalDateTime dtcadastro) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anopublicacao = anopublicacao;
        this.editora = editora;
        this.disponivel = disponivel;
        this.dtcadastro = dtcadastro;
    }

    public Livro(long id, String titulo, String autor, String isbn, Integer anopublicacao, String editora, Disponivel disponivel, LocalDateTime dtcadastro) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anopublicacao = anopublicacao;
        this.editora = editora;
        this.disponivel = disponivel;
        this.dtcadastro = dtcadastro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnopublicacao() {
        return anopublicacao;
    }

    public void setAnopublicacao(Integer anopublicacao) {
        this.anopublicacao = anopublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Disponivel getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Disponivel disponivel) {
        this.disponivel = disponivel;
    }

    public LocalDateTime getDtcadastro() {
        return dtcadastro;
    }

    public void setDtcadastro(LocalDateTime dtcadastro) {
        this.dtcadastro = dtcadastro;
    }
}
