package edi.ifam.dra.aplicacao_dra_2024.dto;

import edi.ifam.dra.aplicacao_dra_2024.model.Cidade;

public class CidadeOutputDTO {
    private Long id;
    private String ibge;
    private String nome;
    private String estado;

    public CidadeOutputDTO() {}

    public CidadeOutputDTO(Cidade cidade) {
        this.id = cidade.getId();
        this.ibge = cidade.getIbge();
        this.nome = cidade.getNome();
        this.estado = cidade.getEstado().getNome();
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
