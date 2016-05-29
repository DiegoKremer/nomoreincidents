package br.com.senacrs.nomoreincidents.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    
    public JpaUtil () {
    
    }
    
    private EntityManager entityManager;
    
    private  EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("nomoreincidents-bdPU");
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void close(){
        emf.close();
    }
    
}
