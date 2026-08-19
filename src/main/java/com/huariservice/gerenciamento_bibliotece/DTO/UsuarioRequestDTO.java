package com.huariservice.gerenciamento_bibliotece.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioRequestDTO {
    @NotBlank(message = "o nome é obrigatorio")
    @Size(max = 100)
    private String nome;
    @NotBlank(message = "o E-mail é obrigatorio")
    @Email(message = "E-mail invalido")
    private String email;
    @Size(max = 20)
    private String telefone;

    public String getNome() {z
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
}
