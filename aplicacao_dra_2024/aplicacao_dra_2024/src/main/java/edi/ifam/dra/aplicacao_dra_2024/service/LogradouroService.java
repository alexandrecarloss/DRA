package edi.ifam.dra.aplicacao_dra_2024.service;

import edi.ifam.dra.aplicacao_dra_2024.dto.CidadeOutputDTO;
import edi.ifam.dra.aplicacao_dra_2024.dto.LogradouroInputDTO;
import edi.ifam.dra.aplicacao_dra_2024.dto.LogradouroOutputDTO;
import edi.ifam.dra.aplicacao_dra_2024.model.Cidade;
import edi.ifam.dra.aplicacao_dra_2024.model.Logradouro;
import edi.ifam.dra.aplicacao_dra_2024.repository.CidadeRepository;
import edi.ifam.dra.aplicacao_dra_2024.repository.LogradouroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogradouroService {
    @Autowired
    LogradouroRepository logradouroRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    public LogradouroOutputDTO create(LogradouroInputDTO logradouroInputDTO){
        try{
            Logradouro logradouro = logradouroInputDTO.build(cidadeRepository);
            return new LogradouroOutputDTO(logradouroRepository.save(logradouro));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<LogradouroOutputDTO> list(){
        List<Logradouro> logradouros = logradouroRepository.findAll();
        List<LogradouroOutputDTO> logradourosDTO = new ArrayList<>();
        for(Logradouro logradouro:logradouros){
            logradourosDTO.add(new LogradouroOutputDTO(logradouro));
        }
        return logradourosDTO ;
    }

    public LogradouroOutputDTO getById(Long id){
        try{
            LogradouroOutputDTO logradouroOutputDTO = new LogradouroOutputDTO(logradouroRepository.findById(id).get());
            return logradouroOutputDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public LogradouroOutputDTO alter(LogradouroInputDTO logradouroInputDTO, Long id){
        try{
            Logradouro logradouroAlterado = logradouroRepository.findById(id).get();
            logradouroAlterado.setNome(logradouroInputDTO.getNome());
            logradouroAlterado.setCep(logradouroInputDTO.getCep());
            logradouroAlterado.setCidade(cidadeRepository.findByNome(logradouroInputDTO.getCidade()));
            return new LogradouroOutputDTO(logradouroRepository.save(logradouroAlterado));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao alterar Logradouro " + e.getMessage());
        }
    }

    public Boolean deleteById(Long id){
        try {
            Logradouro logradouro = logradouroRepository.findById(id).get();
            logradouroRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
