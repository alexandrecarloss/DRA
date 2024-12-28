package edu.ifam.dra.aplicacao_dra2024.repository;

import edu.ifam.dra.aplicacao_dra2024.model.Cidade;
import edu.ifam.dra.aplicacao_dra2024.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CidadeRepository extends JpaRepository<Cidade,Long> {

    @Query("select c from Cidade c where c.nome = :parNome")
    Cidade fyndByNome(@Param("parNome") String nome);

}
