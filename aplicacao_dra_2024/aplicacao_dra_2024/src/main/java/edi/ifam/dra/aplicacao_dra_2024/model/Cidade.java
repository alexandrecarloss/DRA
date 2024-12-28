package edi.ifam.dra.aplicacao_dra_2024.model;

import jakarta.persistence.*;

@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ibge;

    @Column(nullable = false)
    private String nome;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Estado estado;

    public Cidade() {
    }

    public Cidade(Long id, String ibge, String nome, Estado estado) {
        this.id = id;
        this.ibge = ibge;
        this.nome = nome;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
