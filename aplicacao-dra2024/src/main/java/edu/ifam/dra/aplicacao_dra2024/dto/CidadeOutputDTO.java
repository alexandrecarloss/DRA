package edu.ifam.dra.aplicacao_dra2024.dto;

public class CidadeOutputDTO {
    private Long id;
    private String nome;
    private String estado;

    public CidadeOutputDTO() {}

    public CidadeOutputDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
