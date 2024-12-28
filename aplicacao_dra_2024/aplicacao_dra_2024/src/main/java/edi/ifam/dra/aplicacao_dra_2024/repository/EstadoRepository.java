package edi.ifam.dra.aplicacao_dra_2024.repository;

import edi.ifam.dra.aplicacao_dra_2024.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface EstadoRepository  extends JpaRepository<Estado,Long> {
    @Query("select e from Estado e where e.nome = :parNome")
    Estado findByNome(@Param("parNome") String nome);
}
