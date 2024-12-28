package dao;

import modelo.Pessoa;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PessoaDao {

    private EntityManager entityManager;

    public PessoaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void inserirPessoa(Pessoa pessoa){
        entityManager.getTransaction().begin();
        entityManager.persist(pessoa);
        entityManager.getTransaction().commit();
    }

    public Pessoa consultarPessoa(Long id){
        return entityManager.find(Pessoa.class, id);
    }

    public List<Pessoa> listar(){
        String consulta = "select p from Pessoa p";
        Query query = entityManager.createQuery(consulta);
        return query.getResultList();
    }

    public void excluirPessoa(Long id){
        entityManager.getTransaction().begin();
        Pessoa pessoa = entityManager.find(Pessoa.class, id);
        entityManager.remove(pessoa);
        entityManager.getTransaction().commit();
    }

    public void alterarPessoa(Pessoa pessoa){
        entityManager.getTransaction().begin();
        Pessoa pessoa_db= entityManager.find(Pessoa.class, pessoa.getId());
        pessoa_db.setNome(pessoa.getNome());
        pessoa_db.setCpf(pessoa.getCpf());
        pessoa_db.setEmail(pessoa.getEmail());
        pessoa_db.setTelefone(pessoa.getTelefone());
        entityManager.getTransaction().commit();
    }

}
