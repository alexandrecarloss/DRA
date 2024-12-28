package edu.ifam.dra.aplicacao_dra2024.service;

import edu.ifam.dra.aplicacao_dra2024.dto.PessoaInputDTO;
import edu.ifam.dra.aplicacao_dra2024.dto.PessoaOutputDTO;
import edu.ifam.dra.aplicacao_dra2024.model.Pessoa;
import edu.ifam.dra.aplicacao_dra2024.repository.CidadeRepository;
import edu.ifam.dra.aplicacao_dra2024.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    public List<PessoaOutputDTO> list(){

        List<Pessoa> pessoas = pessoaRepository.findAll();
        List<PessoaOutputDTO> pessoasDTO = new ArrayList<>();

        for(Pessoa pessoa:pessoas){
            pessoasDTO.add(new PessoaOutputDTO(pessoa));
        }
        return pessoasDTO;
    }

    public Pessoa create(PessoaInputDTO pessoaInputDTO){
        try{
            Pessoa pessoa = pessoaInputDTO.build(cidadeRepository);
            return  pessoaRepository.save(pessoa);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }


    public Boolean deleteById (Long id){
        try{
            Pessoa pessoa = pessoaRepository.findById(id).get();
            pessoaRepository.deleteById(id);
            return Boolean.TRUE;
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public PessoaOutputDTO getById(Long id) {
        try{
            PessoaOutputDTO p1 = new PessoaOutputDTO(pessoaRepository.findById(id).get());
            return p1;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public PessoaOutputDTO alter(Pessoa pessoa,Long id){
        Optional<Pessoa> possivelPessoa = pessoaRepository.findById(id);
        if(possivelPessoa.isPresent()){
            Pessoa pessoaUpdade = possivelPessoa.get();
            pessoaUpdade.setNome(pessoa.getNome());
            pessoaUpdade.setEmail(pessoa.getEmail());
            return new PessoaOutputDTO(pessoaRepository.save(pessoaUpdade));
        }else
            return new PessoaOutputDTO(possivelPessoa.get());
    }

}
