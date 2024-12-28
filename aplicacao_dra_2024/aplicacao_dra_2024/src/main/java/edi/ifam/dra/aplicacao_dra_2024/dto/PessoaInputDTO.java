package edi.ifam.dra.aplicacao_dra_2024.dto;

import edi.ifam.dra.aplicacao_dra_2024.model.Pessoa;
import edi.ifam.dra.aplicacao_dra_2024.repository.LogradouroRepository;

public class PessoaInputDTO {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String logradouro;
    private String numeroEndereco;
    private String complementoEndereco;

    public PessoaInputDTO() {
    }

    public PessoaInputDTO(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.email = pessoa.getEmail();
        this.telefone = pessoa.getTelefone();
        this.logradouro = pessoa.getLogradouro().getNome();
        this.numeroEndereco = pessoa.getNumeroEndereco();
        this.complementoEndereco = pessoa.getComplementoEndereco();
    }

    public Pessoa build(LogradouroRepository logradouroRepository) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(this.nome);
        pessoa.setCpf(this.cpf);
        pessoa.setEmail(this.email);
        pessoa.setTelefone(this.telefone);
        pessoa.setLogradouro(logradouroRepository.findByNome(this.logradouro));
        pessoa.setNumeroEndereco(this.numeroEndereco);
        pessoa.setComplementoEndereco(this.complementoEndereco);
        return pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }
}
