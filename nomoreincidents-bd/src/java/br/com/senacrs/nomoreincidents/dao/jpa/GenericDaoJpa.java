/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senacrs.nomoreincidents.dao.jpa;

import br.com.senacrs.nomoreincidents.dao.GenericDao;
import br.com.senacrs.nomoreincidents.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Diego Kremer
 */
public abstract class GenericDaoJpa<T> implements GenericDao<T> {

    private Class<T> entityClass;

    private GenericDaoJpa() {
    }

    protected GenericDaoJpa(Class<T> entityClass) {
        this();
        this.entityClass = entityClass;
    }
    
    protected EntityManager getEntityManager(){
        return JpaUtil.getEntityManager();
    }
            

    @Override
    public T salvar(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.flush();
            em.getTransaction().commit();
        } catch (RuntimeException ex) {
            em.getTransaction().rollback();
            throw new BDException(ex);
        } finally {
            em.close();
        }
        return entity;
    }

    @Override
    public void excluir(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(entity));
            em.flush();
            em.getTransaction().commit();
        } catch (RuntimeException ex) {
            em.getTransaction().rollback();
            throw new BDException(ex);
        } finally {
            em.close();
        }
    }

    @Override
    public T atualizar(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.flush();
            em.getTransaction().commit();
        } catch (RuntimeException ex) {
            em.getTransaction().rollback();
            throw new BDException(ex);
        } finally {
            em.close();
        }
        return entity;
    }

    @Override
    public List<T> listar() {
        EntityManager em = getEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(entityClass);
        query.from(entityClass);
        List<T> lista = em.createQuery(query).getResultList();
        em.close();
        return(lista);
    }

    @Override
    public T procurarPorId(Long id) {
        EntityManager em = getEntityManager();
        T entity = em.find(entityClass, id);
        em.close();
        return entity;
    }

}
