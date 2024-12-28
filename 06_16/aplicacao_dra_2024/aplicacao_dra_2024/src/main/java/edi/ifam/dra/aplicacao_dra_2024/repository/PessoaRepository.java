package edi.ifam.dra.aplicacao_dra_2024.repository;

import edi.ifam.dra.aplicacao_dra_2024.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
