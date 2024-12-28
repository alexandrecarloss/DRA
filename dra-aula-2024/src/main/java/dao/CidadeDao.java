package dao;

import modelo.Cidade;
import modelo.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CidadeDao {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public CidadeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void inserirCidade(Cidade c){
        entityManager.getTransaction().begin();
        entityManager.persist(c);
        entityManager.getTransaction().commit();
    }

    public Cidade consultarCidade(Long id){
        return entityManager.find(Cidade.class, id);
    }

    public List<Cidade> listar(){
        String consulta = "select c from Cidade c";
        Query query = entityManager.createQuery(consulta);
        return query.getResultList();
    }

    public void excluirCidade(Long id){
        entityManager.getTransaction().begin();
        Cidade c = entityManager.find(Cidade.class, id);
        entityManager.remove(c);
        entityManager.getTransaction().commit();
    }

    public void alterarCidade(Cidade c){
        entityManager.getTransaction().begin();
        Cidade c_db= entityManager.find(Cidade.class, c.getCidade_id());
        c_db.setNome(c.getNome());
        c_db.setIbge(c.getIbge());
        c_db.setEstado(c.getEstado());
        entityManager.getTransaction().commit();
    }

}
