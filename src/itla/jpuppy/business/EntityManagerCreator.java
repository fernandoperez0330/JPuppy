package itla.jpuppy.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerCreator {

    private static EntityManager[] em = null;
    private static EntityManager em2 = null;
    private static EntityManagerFactory emf = null;
    private static String puName = "JPuppyPU";
    private static Boolean[] useEm;
    private boolean someProblems;

    private EntityManagerCreator() {
        someProblems = false;
    }

    private static void initialize() {
        em = new EntityManager[5];
        useEm = new Boolean[5];
        emf = Persistence.createEntityManagerFactory(puName);
        for (int i = 0; i < em.length; i++) {
            em[i] = emf.createEntityManager();
            useEm[i] = false;
        }
    }

    private static void reload(int i) {
        if (!em[i].isOpen()) {
            em[i] = emf.createEntityManager();
            useEm[i] = false;
        }
    }

    public static EntityManager getInstanceEM() {
        
        if ((emf == null) && (em2 == null)) {
            emf = Persistence.createEntityManagerFactory(puName);
            em2 = emf.createEntityManager();
        }
        
        return em2;
    }
    public static EntityManager getInstanceEM2() {
        boolean correct = true;
        
        if ((emf == null) && (em == null)) {
            initialize();
        }
        do {


            for (int i = 0; i < em.length; i++) {
                if (useEm[i] == false) {
                    useEm[i] = true;
                    return em[i];
                }
            }

            for (int i = 0; i < em.length; i++) {
                reload(i);
                correct = false;
            }
        } while (!correct);
            
        return null;
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}
