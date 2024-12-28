package edi.ifam.dra.aplicacao_dra_2024.service;

import edi.ifam.dra.aplicacao_dra_2024.dto.EstadoInputDTO;
import edi.ifam.dra.aplicacao_dra_2024.dto.EstadoOutputDTO;
import edi.ifam.dra.aplicacao_dra_2024.model.Estado;
import edi.ifam.dra.aplicacao_dra_2024.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    public List<EstadoOutputDTO> list(){

        List<Estado> estados = estadoRepository.findAll();
        List<EstadoOutputDTO> estadosDTO = new ArrayList<>();

        for(Estado estado:estados){
            estadosDTO.add(new EstadoOutputDTO(estado));
        }
        return estadosDTO ;
    }

    public Estado create(EstadoInputDTO estadoInputDTO){
        try{
            Estado estado = new Estado();
            estado.setIbge(estadoInputDTO.getIbge());
            estado.setNome(estadoInputDTO.getNome());
            return estadoRepository.save(estado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean deleteById(Long id){
        try{
            Estado estado = estadoRepository.findById(id).get();
            estadoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public EstadoOutputDTO getById(Long id){
        try{
            EstadoOutputDTO estadoDTO = new EstadoOutputDTO(estadoRepository.findById(id).get());
            return estadoDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public EstadoOutputDTO alter(EstadoInputDTO estadoInputDTO, Long id) {
        try {
            // Verificar se o estado existe
            Estado estadoAlterado = estadoRepository.findById(id).get();

            // Atualizar os atributos
            estadoAlterado.setNome(estadoInputDTO.getNome());
            estadoAlterado.setIbge(estadoInputDTO.getIbge());

            // Salvar as alterações
            return new EstadoOutputDTO(estadoRepository.save(estadoAlterado));
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao alterar Estado: " + e.getMessage());
        }
    }

}
