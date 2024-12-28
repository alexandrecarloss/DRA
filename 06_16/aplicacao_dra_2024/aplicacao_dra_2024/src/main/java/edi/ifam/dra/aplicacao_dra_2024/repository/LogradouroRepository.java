package edi.ifam.dra.aplicacao_dra_2024.repository;

import edi.ifam.dra.aplicacao_dra_2024.model.Estado;
import edi.ifam.dra.aplicacao_dra_2024.model.Logradouro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LogradouroRepository extends JpaRepository<Logradouro,Long> {
    @Query("select l from Logradouro l where l.nome = :parNome")
    Logradouro findByNome(@Param("parNome") String nome);
}
