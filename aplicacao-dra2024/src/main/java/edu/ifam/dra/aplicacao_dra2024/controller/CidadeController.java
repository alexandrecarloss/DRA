package edu.ifam.dra.aplicacao_dra2024.controller;

import edu.ifam.dra.aplicacao_dra2024.model.Cidade;
import edu.ifam.dra.aplicacao_dra2024.model.Pessoa;
import edu.ifam.dra.aplicacao_dra2024.repository.CidadeRepository;
import edu.ifam.dra.aplicacao_dra2024.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    public ResponseEntity<List<Cidade>> list(){
        List<Cidade> cidades = cidadeRepository.findAll();
        if(!cidades.isEmpty()){
            return new ResponseEntity<>(cidades, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cidade> create(@RequestBody Cidade cidade){
        try{
            cidadeRepository.save(cidade);
            return new ResponseEntity<>(cidade, HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cidade> getById(@PathVariable Long id){
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        if(cidade.isPresent()){
            return new ResponseEntity<>(cidade.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Cidade> deleteById(@PathVariable Long id){
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        if(cidade.isPresent()){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cidade> alter(@RequestBody Cidade cidade){
        Optional<Cidade> c = cidadeRepository.findById(cidade.getId());
        if(c.isPresent()){
            Cidade c1 = c.get();
            c1.setNome(cidade.getNome());
            c1.setEstado(cidade.getEstado());
            Cidade cidadeBD = cidadeRepository.save(c1);
            return new ResponseEntity<>(cidadeBD,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
