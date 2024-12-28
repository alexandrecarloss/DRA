package edu.ifam.dra.aplicacao_dra2024.repository;


import edu.ifam.dra.aplicacao_dra2024.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
}
