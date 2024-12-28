package edi.ifam.dra.aplicacao_dra_2024.dto;

import edi.ifam.dra.aplicacao_dra_2024.model.Estado;

public class EstadoInputDTO {
    private String ibge;
    private String nome;

    public EstadoInputDTO(){}

    public EstadoInputDTO(Estado estado) {
        this.ibge = estado.getIbge();
        this.nome = estado.getNome();
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
