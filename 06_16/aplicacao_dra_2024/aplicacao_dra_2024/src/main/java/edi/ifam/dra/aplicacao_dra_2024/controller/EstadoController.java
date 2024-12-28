package edi.ifam.dra.aplicacao_dra_2024.controller;

import edi.ifam.dra.aplicacao_dra_2024.dto.EstadoInputDTO;
import edi.ifam.dra.aplicacao_dra_2024.dto.EstadoOutputDTO;
import edi.ifam.dra.aplicacao_dra_2024.model.Estado;
import edi.ifam.dra.aplicacao_dra_2024.repository.EstadoRepository;
import edi.ifam.dra.aplicacao_dra_2024.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<EstadoOutputDTO>> list(){

        List<EstadoOutputDTO> estadosDTO = estadoService.list();

        if(!estadosDTO.isEmpty()){
            return new ResponseEntity<>(estadosDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estado> create(@RequestBody EstadoInputDTO estadoInputDTO){
        try{
            Estado estado = estadoService.create(estadoInputDTO);
            return new ResponseEntity<>(estado, HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstadoOutputDTO> getById(@PathVariable Long id){
        EstadoOutputDTO estadoOutputDTO = estadoService.getById(id);
        if(estadoOutputDTO != null){
            return new ResponseEntity<>(estadoOutputDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        Boolean apagou = estadoService.deleteById(id);
        if(apagou){
            return new ResponseEntity<>("Estado apagado com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Estado não encontrado!", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstadoOutputDTO> alter(@RequestBody EstadoInputDTO estadoInputDTO, @PathVariable Long id) {
        try {
            return new ResponseEntity<>(estadoService.alter(estadoInputDTO, id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
