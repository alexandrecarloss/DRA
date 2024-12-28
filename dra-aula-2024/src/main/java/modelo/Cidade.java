package modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cidade_id;

    @Column(nullable = false, unique = true, length = 7)
    private String ibge;
    @Column(nullable = false)
    private String nome;



    public Cidade() {}

    public Cidade(String ibge, String nome, Estado estado) {
        this.ibge = ibge;
        this.nome = nome;
        this.estado = estado;
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



    public Long getCidade_id() {
        return cidade_id;
    }

    public void setCidade_id(Long cidade_id) {
        this.cidade_id = cidade_id;
    }

    @ManyToOne
    private Estado estado;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @OneToMany(mappedBy = "cidade")
    List<Pessoa> pessoas = new ArrayList<>();

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void Addpessoa(Pessoa p){
        if(!this.pessoas.contains(p)){
            this.pessoas.add(p);
            p.setCidade(this);
        }
    }
}
