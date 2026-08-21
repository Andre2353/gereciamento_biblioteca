package com.huariservice.gerenciamento_bibliotece.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity// essa anotação fala para o banco que essa tabela é uma entidade
@Table(name = "livro") // Define o nome da tabela no banco de dados como "livro"
// estou colocando em minusculos para faciitar a busca
public class Livro {
    @Id// vai falar que o id vai ser uma chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //configura o auto incremente no banco
    private long id;
    @Column(nullable = false,length = 150)// vai garantir que é obrigratorio e limita a 150 caracteres
    private String titulo;
    @Column(nullable = false,length = 150)
    private String autor;
    @Column(nullable = false,unique = true) // vai garantir que é obrigratorio, e o deixa unico
    private String isbn;
    @Column(name = "ano_publicacao",nullable = false)
    private Integer anopublicacao;
    @Column(length = 100)
    private String editora;
    @Enumerated(EnumType.STRING) // vai falar que é um enum, e fala que em vez de um numero o banco salve como uma palavra
    @Column(name = "Disponivel",nullable = false) //ta mudando o nome de disponive para Disponive e ta deixando obrigratorio
    private Disponivel disponivel;
    @Column(name = "data_cadastro",updatable = false) // vai dizer a data que foi cadastrado, e inpedir alterações
    private LocalDateTime dtcadastro; //Data e hora em que o livro foi cadastrado no sistema

    public Livro() { // e necessario para criar objetos ao buscar dados no banco.
    }
    // contrutor para o response
    public Livro( String titulo, String autor, String isbn, Integer anopublicacao, String editora, Disponivel disponivel, LocalDateTime dtcadastro) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anopublicacao = anopublicacao;
        this.editora = editora;
        this.disponivel = disponivel;
        this.dtcadastro = dtcadastro;
    }
    //construtor para o request
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
    //Getters e Setters
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
