package com.huariservice.gerenciamento_bibliotece.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LivroRequestDTO {
    @NotBlank(message = "o TItulo é obrigatorio") // aparece a mensagem erro correspondente a mensagem
    @Size(max = 150)
    private String titulo;
    @NotBlank(message = "o Autor é obrigatorio") // aparece a mensagem erro correspondente a mensagem
    @Size(max = 100)
    private String autor;
    @NotBlank(message = "o ISBN é obrigatorio")// aparece a mensagem erro correspondente a mensagem
    @Size(max = 20)
    private String isbn;
    @NotNull(message = "o ano de publicação obrigatorio")// aparece a mensagem erro correspondente a mensagem
    private Integer anodepublicacao;
    @Size(max = 100)
    private String editora;

    public LivroRequestDTO() {
    }

    public LivroRequestDTO(String titulo, String autor, String isbn, Integer anodepublicacao, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anodepublicacao = anodepublicacao;
        this.editora = editora;
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

    public Integer getAnodepublicacao() {
        return anodepublicacao;
    }

    public void setAnodepublicacao(Integer anodepublicacao) {
        this.anodepublicacao = anodepublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}