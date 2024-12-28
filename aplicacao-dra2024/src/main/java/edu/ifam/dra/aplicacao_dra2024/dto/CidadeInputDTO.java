package edu.ifam.dra.aplicacao_dra2024.dto;

public class CidadeInputDTO {
    private String nome;
    private String estado;

    public CidadeInputDTO() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public CidadeInputDTO(String nome, String estado) {
        this.nome = nome;
        this.estado = estado;
    }


}
