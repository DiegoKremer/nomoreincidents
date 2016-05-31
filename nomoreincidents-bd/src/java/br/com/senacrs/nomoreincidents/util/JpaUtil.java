package br.com.senacrs.nomoreincidents.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Kremer
 */
public class JpaUtil {
    
    private static final  EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("nomoreincidents-bdPU");
    
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public static void close(){
        emf.close();
    }
    

    
}
