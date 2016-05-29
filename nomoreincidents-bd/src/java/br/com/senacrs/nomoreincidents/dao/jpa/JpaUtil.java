package br.com.senacrs.nomoreincidents.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    
    public static final EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("nomoreincidents-bdPU");
    
    public static EntityManager getEntityManager() {
        EntityManager eManager = emf.createEntityManager();
        return eManager;
    }
    
    public static void close(){
        emf.close();
    }
    
}
