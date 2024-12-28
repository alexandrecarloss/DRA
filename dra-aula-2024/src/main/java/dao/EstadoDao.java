package dao;

import modelo.Estado;
import modelo.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EstadoDao {
    private EntityManager entityManager;

    public EstadoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void inserir(Estado e){
        entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
    }

    public Estado consultar(Long id){
        return entityManager.find(Estado.class, id);
    }

    public List<Estado> listar(){
        String consulta = "select e from Esatdo e ";
        Query query = entityManager.createQuery(consulta);
        return query.getResultList();
    }

    public void excluir(Long id){
        entityManager.getTransaction().begin();
        Estado e = entityManager.find(Estado.class, id);
        entityManager.remove(e);
        entityManager.getTransaction().commit();
    }

    public void alterar(Estado e){
        entityManager.getTransaction().begin();
        Estado e_db= entityManager.find(Estado.class, e.getEstado_id());
        e_db.setNome(e.getNome());
        e_db.setIbge(e.getIbge());
        entityManager.getTransaction().commit();
    }
}
