package itla.jpuppy.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerCreator {

    private static EntityManager em;
    private static EntityManagerFactory emf;
    private static String puName = "JPuppyPU";

    private EntityManagerCreator() {
    }

    public synchronized static EntityManager getInstanceEM() {

        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(puName);
            em = emf.createEntityManager();
        }
        return em;
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }
    
    
}
