package teste;

import dao.PessoaDao;
import modelo.Pessoa;
import util.ConexaoUtil;

import javax.persistence.*;
import java.util.List;

public class TestaPessoa {

    private static void persistir(){
       EntityManager entityManager =  ConexaoUtil.getEntityManager();
       Pessoa pessoa = new Pessoa("06512581202", "Marcela", "8654-3214", "marcela@gmail.com");
       PessoaDao pessoaDao = new PessoaDao(entityManager);
       pessoaDao.setEntityManager(entityManager);
       pessoaDao.inserirPessoa(pessoa);
       entityManager.close();
    }

    private static void listar(){
        EntityManager entityManager =  ConexaoUtil.getEntityManager();
        PessoaDao pessoaDao = new PessoaDao(entityManager);

        pessoaDao.setEntityManager(entityManager);
        List<Pessoa> pessoas = pessoaDao.listar();

        for(Pessoa p: pessoas){
            System.out.println(p.getNome());
            System.out.println(p.getEmail());
            System.out.println(p.getTelefone());
            System.out.println("****************");
        }
        entityManager.close();
    }

    private static void consultar(){
        EntityManager entityManager =  ConexaoUtil.getEntityManager();
        Pessoa pessoa = entityManager.find(Pessoa.class,1L);
        System.out.println("Pessoa: "+pessoa.getNome());
        entityManager.close();

    }

    private static void remover(){
        EntityManager entityManager =  ConexaoUtil.getEntityManager();
        PessoaDao pessoaDao = new PessoaDao(entityManager);
        pessoaDao.setEntityManager(entityManager);
        pessoaDao.excluirPessoa(1l);
        entityManager.close();
    }

    private static void alterar(){
        EntityManager entityManager =  ConexaoUtil.getEntityManager();

        Pessoa p = new Pessoa("065125", "Carlos","1234", "cadu@gmail.com");
        PessoaDao pessoaDao = new PessoaDao(entityManager);
        pessoaDao.setEntityManager(entityManager);

        entityManager.getTransaction().commit();
        entityManager.close();
    }


    private static void mesclar(){
        EntityManager entityManager =  ConexaoUtil.getEntityManager();
        Pessoa pessoa = new Pessoa();
        pessoa.setId(2l);
        pessoa.setNome("Alterado pelo mesclar");
        entityManager.getTransaction().begin();
        entityManager.merge(pessoa);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void main(String[] args) {
        //persistir();
        //remover();
        //alterar();
        //mesclar();
        //listar();
        //consultar();
        ConexaoUtil.fecharFabrica();
    }

}
