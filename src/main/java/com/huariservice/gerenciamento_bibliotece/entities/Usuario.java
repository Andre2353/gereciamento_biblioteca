package com.huariservice.gerenciamento_bibliotece.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario") //  Define o nome da tabela no banco de dados como "usuario",
// estou colocando em minusculos para faciitar a busca
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(length = 150,nullable = false)
    private String nome;
    @Column(length = 150,unique = true,nullable = false)
    private String email;
    @Column(length = 15,nullable = false)
    private String telefone;
    @Column(name = "data_cadastro",updatable = false)
    private LocalDateTime dtcadastro; //Data e hora em que o usuario foi cadastrado no sistema

    public Usuario() {
    }

    public Usuario( String nome, String email, String telefone, LocalDateTime dtcadastro) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dtcadastro = dtcadastro;
    }

    public Usuario(Long id, String nome, String email, String telefone, LocalDateTime dtcadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dtcadastro = dtcadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getDtcadastro() {
        return dtcadastro;
    }

    public void setDtcadastro(LocalDateTime dtcadastro) {
        this.dtcadastro = dtcadastro;
    }
}
