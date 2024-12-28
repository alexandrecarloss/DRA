package edi.ifam.dra.aplicacao_dra_2024.repository;

import edi.ifam.dra.aplicacao_dra_2024.model.Cidade;
import edi.ifam.dra.aplicacao_dra_2024.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CidadeRepository extends JpaRepository<Cidade,Long> {
    @Query("select c from Cidade c where c.nome = :parNome")
    Cidade findByNome(@Param("parNome") String nome);
}
