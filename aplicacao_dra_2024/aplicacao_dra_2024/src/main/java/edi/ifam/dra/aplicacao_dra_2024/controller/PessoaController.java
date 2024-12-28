package edi.ifam.dra.aplicacao_dra_2024.controller;

import edi.ifam.dra.aplicacao_dra_2024.dto.PessoaInputDTO;
import edi.ifam.dra.aplicacao_dra_2024.dto.PessoaOutputDTO;
import edi.ifam.dra.aplicacao_dra_2024.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaOutputDTO>> list(){
        List<PessoaOutputDTO> pessoasDTO = pessoaService.list();
        if(!pessoasDTO.isEmpty()) {
            return new ResponseEntity<>(pessoasDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaOutputDTO> getById(@PathVariable Long id){
        try{
            PessoaOutputDTO pessoaDTO = pessoaService.getById(id);
            return new ResponseEntity(pessoaDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaOutputDTO> create(@RequestBody PessoaInputDTO pessoaInputDTO){
        try{
            PessoaOutputDTO pessoaDTO = pessoaService.create(pessoaInputDTO);
            return new ResponseEntity<>(pessoaDTO, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaOutputDTO> alter(@RequestBody PessoaInputDTO pessoaInputDTO, @PathVariable Long id){
        try{
            PessoaOutputDTO pessoaDTO = pessoaService.alter(pessoaInputDTO, id);
            return new ResponseEntity<>(pessoaDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        Boolean apagou = pessoaService.deleteById(id);
        if(apagou){
            return new ResponseEntity<>("Pessoa excluída com sucesso", HttpStatus.OK);
        } else  {
            return new ResponseEntity<>("Pessoa não encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
