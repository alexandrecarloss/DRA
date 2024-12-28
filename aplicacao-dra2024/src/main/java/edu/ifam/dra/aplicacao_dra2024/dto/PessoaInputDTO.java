package edu.ifam.dra.aplicacao_dra2024.dto;

import edu.ifam.dra.aplicacao_dra2024.model.Pessoa;
import edu.ifam.dra.aplicacao_dra2024.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PessoaInputDTO {
    private String nome;
    private String email;
    private String cidade;


    public PessoaInputDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Pessoa build(CidadeRepository cidadeRepository){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(this.nome);
        pessoa.setCidade(cidadeRepository.fyndByNome(this.cidade));
        pessoa.setEmail(this.email);
        return pessoa;
    }
}
