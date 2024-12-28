package edu.ifam.dra.aplicacao_dra2024.service;

import edu.ifam.dra.aplicacao_dra2024.model.Cidade;
import edu.ifam.dra.aplicacao_dra2024.repository.CidadeRepository;
import edu.ifam.dra.aplicacao_dra2024.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CidadeService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    CidadeRepository cidadeRepository;


    public List<Cidade> list(){
        List<Cidade> cidades = cidadeRepository.findAll();
        return cidades;
    }


}
