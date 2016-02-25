package com.br.lp3.dao;

import com.br.lp3.entities.UserLP3;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author 31448471
 */
public class UserLP3DAO implements GenericDAO<UserLP3>{

    
    private EntityManager em;

    public UserLP3DAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LP3PU");
        em = emf.createEntityManager();
    }
    
    
    
    @Override
    public boolean create(UserLP3 e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public List<UserLP3> readAll() {
        Query query = em.createQuery("Select u from UserLP3 u");
        List<UserLP3> lista = query.getResultList();
        return lista;
    }

    @Override
    public UserLP3 readById(long id) {
        Query query = em.createQuery("Select u from UserLP3 u where u.id_user = :id");
        query.setParameter("id", id);
        return (UserLP3)query.getSingleResult();
    }
    
    public UserLP3 readByUsername(String username){
        Query query = em.createQuery("Select u from UserLP3 u where u.username = :username");
        query.setParameter("username", username);
        return (UserLP3)query.getSingleResult();
    }

    @Override
    public boolean update(UserLP3 e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(UserLP3 e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        return true;
    }
    
}
