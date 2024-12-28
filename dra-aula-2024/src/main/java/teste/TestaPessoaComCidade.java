package teste;

import dao.CidadeDao;
import dao.PessoaDao;
import modelo.Cidade;
import modelo.Pessoa;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaPessoaComCidade {
    public static void inserir(){
        EntityManager entityManager =  ConexaoUtil.getEntityManager();
        Pessoa pessoa = new Pessoa("06512581202", "Marcela", "8654-3214", "marcela@gmail.com");
        PessoaDao pessoaDao = new PessoaDao(entityManager);
        CidadeDao cd = new CidadeDao(entityManager);
        Cidade cidade = new Cidade();
        cidade = cd.consultarCidade(1l);
        pessoa.setCidade(cidade);
        entityManager.persist(cidade);
        pessoaDao.inserirPessoa(pessoa);
        entityManager.close();
    }

    public static void inserirNovaPessoaNovaCidade(Pessoa p, Cidade c){
        EntityManager entityManager =  ConexaoUtil.getEntityManager();
        PessoaDao pessoaDao = new PessoaDao(entityManager);
        CidadeDao cidadeDao = new CidadeDao(entityManager);
        pessoaDao.setEntityManager(entityManager);
        cidadeDao.setEntityManager(entityManager);
        cidadeDao.inserirCidade(c);
        p.setCidade(c);
        pessoaDao.inserirPessoa(p);
        entityManager.close();
    }

    private static void inserirNovaPessoaComCidadeJaSalva() {
        EntityManager entityManager =  ConexaoUtil.getEntityManager();
        PessoaDao pessoaDao = new PessoaDao(entityManager);
        pessoaDao.setEntityManager(entityManager);
        Cidade cidade = new Cidade();
        cidade = entityManager.find(Cidade.class,1L);
        Pessoa pessoa = new Pessoa("12345678904","Carlos","85485998","kadu4@email.com");
        pessoa.setCidade(cidade);
        pessoaDao.inserirPessoa(pessoa);
        entityManager.close();
    }

    public static void main(String[] args){
        inserir();
        //inserirNovaPessoaComCidadeJaSalva();
        //Pessoa p = new Pessoa("93893837","Cecília","97981027933","cecilia@gmail.com");
        //inserirNovaPessoaNovaCidade(p,c);
        ConexaoUtil.fecharFabrica();
    }
}
