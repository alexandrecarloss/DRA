package teste;

import dao.CidadeDao;
import modelo.Cidade;
import modelo.Pessoa;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class TesteCidade {
/*
   private static void persistir(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();
        Cidade c = new Cidade("1234","Xique-Xique","BA");
        CidadeDao cidadeDao = new CidadeDao();
        cidadeDao.setEntityManager(entityManager);
        cidadeDao.inserirCidade(c);
        entityManager.close();
    }
    private static void deletar(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();
        CidadeDao cidadeDao = new CidadeDao();
        cidadeDao.setEntityManager(entityManager);
        cidadeDao.excluirCidade(1L);
        entityManager.close();
    }

    private static void atualizar(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();
        CidadeDao cidadeDao = new CidadeDao();
        cidadeDao.setEntityManager(entityManager);
        Cidade c = new Cidade();
        c.setCidade_id(1L);
        c.setEstado("Mg");
        c.setIbge("2543");
        c.setNome("Serra da saudade");
        cidadeDao.alterarCidade(c);
        entityManager.close();
    }


    private static void listar(){
        EntityManager entityManager = ConexaoUtil.getEntityManager();
        CidadeDao cidadeDao = new CidadeDao();
        cidadeDao.setEntityManager(entityManager);

        List<Cidade> cidades = cidadeDao.listar();

        for(Cidade c: cidades){
            System.out.println(c.getNome());
            System.out.println(c.getIbge());
            System.out.println(c.getEstado());
            System.out.println("****************");
        }
        entityManager.close();
    }

    public void main (String[] args){
        //persistir();
        //deletar();
        //listar();
        //mesclar();
        //atualizar();
        ConexaoUtil.fecharFabrica();
    }

}\
 */
}
