package edu.ifam.dra.aplicacao_dra2024.controller;

import edu.ifam.dra.aplicacao_dra2024.dto.PessoaInputDTO;
import edu.ifam.dra.aplicacao_dra2024.dto.PessoaOutputDTO;
import edu.ifam.dra.aplicacao_dra2024.model.Pessoa;
import edu.ifam.dra.aplicacao_dra2024.repository.CidadeRepository;
import edu.ifam.dra.aplicacao_dra2024.repository.PessoaRepository;
import edu.ifam.dra.aplicacao_dra2024.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaOutputDTO>> list(){

        List<PessoaOutputDTO> pessoasDTO = pessoaService.list();

        if(!pessoasDTO.isEmpty()){
            return new ResponseEntity<>(pessoasDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaOutputDTO> create(@RequestBody PessoaInputDTO pessoaInputDTO){
        try{
            Pessoa pessoa = pessoaService.create(pessoaInputDTO);
            return new ResponseEntity<>(new PessoaOutputDTO(pessoa), HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaOutputDTO> getById(@PathVariable Long id){
        PessoaOutputDTO p1 = pessoaService.getById(id);
        if(p1!= null){
            return new ResponseEntity<>(p1, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        Boolean b = pessoaService.deleteById(id);
        if(b){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaOutputDTO> alter(@RequestBody Pessoa pessoa, @PathVariable Long id){
       PessoaOutputDTO possivelPessoa = pessoaService.alter(pessoa, id);
            if (possivelPessoa != null){
                return new ResponseEntity<>(possivelPessoa, HttpStatus.OK);
            }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
