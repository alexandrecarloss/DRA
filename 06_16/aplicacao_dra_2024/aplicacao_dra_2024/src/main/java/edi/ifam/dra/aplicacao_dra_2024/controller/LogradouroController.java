package edi.ifam.dra.aplicacao_dra_2024.controller;

import edi.ifam.dra.aplicacao_dra_2024.dto.CidadeOutputDTO;
import edi.ifam.dra.aplicacao_dra_2024.dto.LogradouroInputDTO;
import edi.ifam.dra.aplicacao_dra_2024.dto.LogradouroOutputDTO;
import edi.ifam.dra.aplicacao_dra_2024.service.LogradouroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logradouro")
public class LogradouroController {
    @Autowired
    LogradouroService logradouroService;

    @GetMapping
    public ResponseEntity<List<LogradouroOutputDTO>> list(){
        List<LogradouroOutputDTO> logradourosDTO = logradouroService.list();

        if(!logradourosDTO.isEmpty()){
            return new ResponseEntity<>(logradourosDTO, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LogradouroOutputDTO> create(@RequestBody LogradouroInputDTO logradouroInputDTO){
        try{
            LogradouroOutputDTO logradouroDTO = logradouroService.create(logradouroInputDTO);
            return new ResponseEntity<>(logradouroDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LogradouroOutputDTO> getById(@PathVariable Long id){
        try{
            LogradouroOutputDTO logradouroDTO = logradouroService.getById(id);
            return new ResponseEntity<>(logradouroDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        Boolean apagou = logradouroService.deleteById(id);
        if(apagou){
            return new ResponseEntity<>("Logradouro excluído com sucesso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Logradouro não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LogradouroOutputDTO> alter(@RequestBody LogradouroInputDTO logradouroInputDTO, @PathVariable Long id){
        try{
            return new ResponseEntity<>(logradouroService.alter(logradouroInputDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
