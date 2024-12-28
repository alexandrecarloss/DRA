package edi.ifam.dra.aplicacao_dra_2024.service;

import edi.ifam.dra.aplicacao_dra_2024.dto.CidadeInputDTO;
import edi.ifam.dra.aplicacao_dra_2024.dto.CidadeOutputDTO;
import edi.ifam.dra.aplicacao_dra_2024.dto.EstadoOutputDTO;
import edi.ifam.dra.aplicacao_dra_2024.model.Cidade;
import edi.ifam.dra.aplicacao_dra_2024.model.Estado;
import edi.ifam.dra.aplicacao_dra_2024.repository.CidadeRepository;
import edi.ifam.dra.aplicacao_dra_2024.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CidadeService {
    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    EstadoRepository estadoRepository;

    public List<CidadeOutputDTO> list(){
        List<Cidade> cidades = cidadeRepository.findAll();
        List<CidadeOutputDTO> cidadesDTO = new ArrayList<>();
        for(Cidade cidade:cidades){
            cidadesDTO.add(new CidadeOutputDTO(cidade));
        }
        return cidadesDTO ;
    }

    public CidadeOutputDTO create(CidadeInputDTO cidadeInputDTO){
        try{
            Cidade cidade = cidadeInputDTO.build(estadoRepository);
            return new CidadeOutputDTO(cidadeRepository.save(cidade));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CidadeOutputDTO getById(Long id){
        try{
            CidadeOutputDTO cidadeDTO = new CidadeOutputDTO(cidadeRepository.findById(id).get());
            return cidadeDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CidadeOutputDTO alter(CidadeInputDTO cidadeInputDTO, Long id){
        try {
            Cidade cidadeAlterada = cidadeRepository.findById(id).get();
            cidadeAlterada.setEstado(estadoRepository.findByNome(cidadeInputDTO.getEstado()) );
            cidadeAlterada.setNome(cidadeInputDTO.getNome());
            cidadeAlterada.setIbge(cidadeInputDTO.getIbge());
            return new CidadeOutputDTO(cidadeRepository.save(cidadeAlterada));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao alterar Cidade: " + e.getMessage());
        }
    }

    public Boolean deleteById(Long id){
        try{
            Cidade cidade = cidadeRepository.findById(id).get();
            cidadeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
