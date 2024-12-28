package edi.ifam.dra.aplicacao_dra_2024.dto;

import edi.ifam.dra.aplicacao_dra_2024.model.Cidade;
import edi.ifam.dra.aplicacao_dra_2024.repository.EstadoRepository;

public class CidadeInputDTO {
    private String ibge;
    private String nome;
    private String estado;

    public CidadeInputDTO(){}

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

    public Cidade build(EstadoRepository estadoRepository){
        Cidade cidade = new Cidade();
        cidade.setNome(this.nome);
        cidade.setEstado(estadoRepository.findByNome(this.estado));
        cidade.setIbge(this.ibge);
        return cidade;
    }
}
