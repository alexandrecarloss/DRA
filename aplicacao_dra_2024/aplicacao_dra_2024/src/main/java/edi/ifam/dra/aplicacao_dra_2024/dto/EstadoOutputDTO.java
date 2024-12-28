package edi.ifam.dra.aplicacao_dra_2024.dto;

import edi.ifam.dra.aplicacao_dra_2024.model.Estado;

public class EstadoOutputDTO {
    private Long id;
    private String ibge;
    private String nome;

    public EstadoOutputDTO(Estado estado) {
        this.id = estado.getId();
        this.ibge = estado.getIbge();
        this.nome = estado.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
