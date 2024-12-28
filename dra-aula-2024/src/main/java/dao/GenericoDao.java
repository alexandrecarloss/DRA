package dao;

import modelo.Cidade;
import modelo.Estado;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GenericoDao <Tipo> {
    private EntityManager entityManager;

    private Class<Tipo> classe;



    public GenericoDao(Class<Tipo> classe, EntityManager entityManager) {
        this.classe = classe;
        this.entityManager = entityManager;
    }

    public void inserir(Tipo obj){
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
    }

    public Tipo consultar( Long id){
        return entityManager.find(classe, id);
    }

    public List<Tipo> listar(){
        String consulta = "select o from"+ classe.getName()+"o";
        Query query = entityManager.createQuery(consulta);
        return query.getResultList();
    }

    public void Excluir(Long id){
        entityManager.getTransaction().begin();
        Tipo obj = entityManager.find(classe, id);
        entityManager.remove(obj);
        entityManager.getTransaction().commit();
    }

    public void alterar(Tipo obj){
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.getTransaction().commit();
    }

}
