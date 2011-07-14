/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.business;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Fernando
 */
public class EntityGeneral {

    private static EntityManager em;
    private static String puName = "JPuppyPU";

    private EntityGeneral() {
    }

    public static EntityManager getInstance() {

        if (em == null) {
            em = Persistence.createEntityManagerFactory(puName).createEntityManager();
        }
        return em;
    }
}
