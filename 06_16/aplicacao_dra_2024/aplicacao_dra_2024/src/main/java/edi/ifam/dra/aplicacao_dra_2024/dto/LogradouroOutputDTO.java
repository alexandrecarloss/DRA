package edi.ifam.dra.aplicacao_dra_2024.dto;

import edi.ifam.dra.aplicacao_dra_2024.model.Logradouro;

public class LogradouroOutputDTO {
    private Long id;
    private String cep;
    private String nome;
    private String cidade;

    public LogradouroOutputDTO() {
    }

    public LogradouroOutputDTO(Logradouro logradouro) {
        this.id = logradouro.getId();
        this.cep = logradouro.getCep();
        this.nome = logradouro.getNome();
        this.cidade = logradouro.getCidade().getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
