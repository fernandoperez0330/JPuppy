package itla.jpuppy.business;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerCreator {

    private static EntityManagerCreator em;
    private static String puName = "JPuppyPU";

    private EntityManagerCreator() {
    }

    public synchronized static EntityManagerCreator getInstance() {

        if (em == null) {
            em = new EntityManagerCreator();
        }
        return em;
    }

    public EntityManager getEntity() {
        return Persistence.createEntityManagerFactory(puName).createEntityManager();
    }
}
