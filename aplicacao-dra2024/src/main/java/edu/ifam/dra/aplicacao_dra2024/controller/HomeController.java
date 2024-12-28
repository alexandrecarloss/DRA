package edu.ifam.dra.aplicacao_dra2024.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String iniciar(){

        System.out.println("Console: aplicação rodando...");

        return "Testando minha aplicação Spring Boot.";
    }

}
