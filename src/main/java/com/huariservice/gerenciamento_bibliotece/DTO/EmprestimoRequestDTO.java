package com.huariservice.gerenciamento_bibliotece.DTO;

import jakarta.validation.constraints.NotNull;

public class EmprestimoRequestDTO {
    @NotNull(message = "o id do livro é obrigatoria")
    private Long livroid;
    @NotNull(message = "o id do livro é obrigatoria")
    private Long usuarioid;

    public Long getLivroid() {
        return livroid;
    }

    public void setLivroid(Long livroid) {
        this.livroid = livroid;
    }

    public Long getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Long usuarioid) {
        this.usuarioid = usuarioid;
    }
}
