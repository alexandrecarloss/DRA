package teste;

import dao.CidadeDao;
import dao.EstadoDao;
import dao.PessoaDao;
import modelo.Cidade;
import modelo.Estado;
import modelo.Pessoa;
import util.ConexaoUtil;

import javax.persistence.EntityManager;

public class testarEstado {

    public static void novoEstado(){
        EntityManager entityManager =  ConexaoUtil.getEntityManager();
        Estado e = new Estado("Amazonas", "26");
        EstadoDao estadoDao = new EstadoDao(entityManager);
        estadoDao.setEntityManager(entityManager);
        estadoDao.inserir(e);
        entityManager.close();
    }


    public static void inserirNovaPessoaEstado(Pessoa p){
        EntityManager entityManager =  ConexaoUtil.getEntityManager();
        PessoaDao pessoaDao = new PessoaDao(entityManager);

    }

    public static void inserirNovaPessoaNovaCidadeEstado(Pessoa p, Cidade c, Estado e){
        EntityManager entityManager =  ConexaoUtil.getEntityManager();
        PessoaDao pessoaDao = new PessoaDao(entityManager);
        CidadeDao cidadeDao = new CidadeDao(entityManager);
        EstadoDao estadoDao = new EstadoDao(entityManager);

        estadoDao.setEntityManager(entityManager);
        pessoaDao.setEntityManager(entityManager);
        cidadeDao.setEntityManager(entityManager);

        estadoDao.inserir(e);
        c.setEstado(e);
        cidadeDao.inserirCidade(c);
        p.setCidade(c);
        pessoaDao.inserirPessoa(p);

        entityManager.close();
    }

    public static void main(String[] args){
        novoEstado();
        ConexaoUtil.fecharFabrica();
    }
}
