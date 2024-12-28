package edi.ifam.dra.aplicacao_dra_2024.controller;

import edi.ifam.dra.aplicacao_dra_2024.dto.CidadeInputDTO;
import edi.ifam.dra.aplicacao_dra_2024.dto.CidadeOutputDTO;
import edi.ifam.dra.aplicacao_dra_2024.dto.EstadoInputDTO;
import edi.ifam.dra.aplicacao_dra_2024.dto.EstadoOutputDTO;
import edi.ifam.dra.aplicacao_dra_2024.model.Cidade;
import edi.ifam.dra.aplicacao_dra_2024.model.Estado;
import edi.ifam.dra.aplicacao_dra_2024.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {
    @Autowired
    CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<List<CidadeOutputDTO>> list(){
        List<CidadeOutputDTO> cidadesDTO = cidadeService.list();

        if(!cidadesDTO.isEmpty()){
            return new ResponseEntity<>(cidadesDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CidadeOutputDTO> create(@RequestBody CidadeInputDTO cidadeInputDTO){
        try{
            CidadeOutputDTO cidadeDTO = cidadeService.create(cidadeInputDTO);
            return new ResponseEntity<>(cidadeDTO, HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CidadeOutputDTO> getById(@PathVariable Long id){
        CidadeOutputDTO cidadeOutputDTO = cidadeService.getById(id);
        if(cidadeOutputDTO != null){
            return new ResponseEntity<>(cidadeOutputDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        Boolean apagou = cidadeService.deleteById(id);
        if(apagou){
            return new ResponseEntity<>("Cidade apagada com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cidade não encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CidadeOutputDTO> alter(@RequestBody CidadeInputDTO cidadeInputDTO, @PathVariable Long id) {
        try {
            return new ResponseEntity<>(cidadeService.alter(cidadeInputDTO, id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
