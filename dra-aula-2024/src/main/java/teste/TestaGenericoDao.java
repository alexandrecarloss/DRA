package teste;

import dao.EstadoDao;
import dao.GenericoDao;
import modelo.Cidade;
import modelo.Estado;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class TestaGenericoDao {

    public static void main(String[] args){
        //novoEstado();
        EntityManager entityManager =  ConexaoUtil.getEntityManager();
        /*GenericoDao<Estado> genericoDao = new GenericoDao<>(entityManager);

        Estado e = new Estado();
        e.setIbge("5242");
        e.setNome("Tocantins");
        genericoDao.inserir(e);
        ConexaoUtil.fecharFabrica();*\

         */

        EstadoDao estadoDao = new EstadoDao(entityManager);
        Cidade ci = new Cidade ("1234", "Manaus", estadoDao.consultar(1l));
        GenericoDao<Cidade> genericoDao = new GenericoDao<>(Cidade.class, ConexaoUtil.getEntityManager());

        genericoDao.inserir(ci);
        List<Cidade> cidades = genericoDao.listar();

        for (Cidade c:cidades){
            System.out.println(c.getNome());
        }
    }
}
