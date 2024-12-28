package teste;

import dao.EstadoDao;
import dao.GenericoDao;
import modelo.Cidade;
import modelo.Pessoa;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class TestaOneToMany {



    public static void criaCidade(){
        EntityManager entityManager =  ConexaoUtil.getEntityManager();
        GenericoDao<Pessoa> genericPessoa = new GenericoDao<>(Pessoa.class, ConexaoUtil.getEntityManager());
        GenericoDao<Cidade> genericCidade = new GenericoDao<>(Cidade.class, ConexaoUtil.getEntityManager());
        /*Pessoa p1 = new Pessoa("12343256","Carlos Araujo","92985485998","cadu@gmail");
        Pessoa p2 = new Pessoa("0000333","Cecilia Batalha Araujo","97981027923","cecilia@gmail");*/
        Pessoa p3 = new Pessoa("223445","Cristiano messias batalha araujo","979862534","anjo@gmail");
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(p3);
        for (Pessoa p:pessoas){
            genericPessoa.inserir(p);
        }
        EstadoDao estadoDao = new EstadoDao(entityManager);
        Cidade c = new Cidade("9872","Tonantins",estadoDao.consultar(1l));
        c.setPessoas(pessoas);
        genericCidade.inserir(c);
    }

    public static void main(String[] args) {
        criaCidade();
        ConexaoUtil.fecharFabrica();
    }
}
