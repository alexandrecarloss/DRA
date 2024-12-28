package edi.ifam.dra.aplicacao_dra_2024.dto;

import edi.ifam.dra.aplicacao_dra_2024.model.Logradouro;
import edi.ifam.dra.aplicacao_dra_2024.repository.CidadeRepository;

public class LogradouroInputDTO {
    private String nome;
    private String cep;
    private String cidade;

    public LogradouroInputDTO() {}

    public LogradouroInputDTO(Logradouro logradouro) {
        this.nome = logradouro.getNome();
        this.cep = logradouro.getCep();
        this.cidade = logradouro.getCidade().getNome();
    }

    public Logradouro build(CidadeRepository cidadeRepository){
        Logradouro logradouro = new Logradouro();
        logradouro.setCep(this.cep);
        logradouro.setNome(this.nome);
        logradouro.setCidade(cidadeRepository.findByNome(this.cidade));
        return logradouro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
