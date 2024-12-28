package edi.ifam.dra.aplicacao_dra_2024.service;

import edi.ifam.dra.aplicacao_dra_2024.dto.PessoaInputDTO;
import edi.ifam.dra.aplicacao_dra_2024.dto.PessoaOutputDTO;
import edi.ifam.dra.aplicacao_dra_2024.model.Logradouro;
import edi.ifam.dra.aplicacao_dra_2024.model.Pessoa;
import edi.ifam.dra.aplicacao_dra_2024.repository.LogradouroRepository;
import edi.ifam.dra.aplicacao_dra_2024.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    LogradouroRepository logradouroRepository;

    public PessoaOutputDTO create(PessoaInputDTO pessoaInputDTO){
        try{
            Pessoa pessoa = pessoaInputDTO.build(logradouroRepository);
            return new PessoaOutputDTO(pessoaRepository.save(pessoa));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PessoaOutputDTO> list(){
        try{
            List<Pessoa> pessoas = pessoaRepository.findAll();
            List<PessoaOutputDTO> pessoasDTO = new ArrayList<>();

            for(Pessoa pessoa:pessoas){
                pessoasDTO.add(new PessoaOutputDTO(pessoa));
            }

            return pessoasDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PessoaOutputDTO getById(Long id){
        try{
            Pessoa pessoa = pessoaRepository.findById(id).get();
            PessoaOutputDTO pessoaDTO = new PessoaOutputDTO(pessoa);
            return pessoaDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PessoaOutputDTO alter(PessoaInputDTO pessoaInputDTO, Long id){
        try{
            Pessoa pessoaAlterada = pessoaRepository.findById(id).get();
            pessoaAlterada.setNome(pessoaInputDTO.getNome());
            pessoaAlterada.setCpf(pessoaInputDTO.getCpf());
            pessoaAlterada.setEmail(pessoaInputDTO.getEmail());
            pessoaAlterada.setTelefone(pessoaInputDTO.getTelefone());
            pessoaAlterada.setLogradouro(logradouroRepository.findByNome(pessoaInputDTO.getLogradouro()));
            pessoaAlterada.setNumeroEndereco(pessoaInputDTO.getNumeroEndereco());
            pessoaAlterada.setComplementoEndereco(pessoaInputDTO.getComplementoEndereco());
            return new PessoaOutputDTO(pessoaRepository.save(pessoaAlterada));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean deleteById(Long id){
        try {
            Pessoa pessoa = pessoaRepository.findById(id).get();
            pessoaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
