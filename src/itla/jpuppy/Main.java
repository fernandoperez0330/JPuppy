package itla.jpuppy;

import itla.jpuppy.business.EntityManagerCreator;
import itla.jpuppy.business.ModelUsers;
import itla.jpuppy.business.QueryManager;
import itla.jpuppy.datalayer.Users;
import itla.jpuppy.forms.Login;
import itla.jpuppy.utils.EncryptText;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {
            //Quitar de comentario la parte comentada y comentar la parte que no esta comentada
            //para crear la base de datos y luego poner como esta
            
//        EntityManager em = EntityManagerCreator.getInstanceEM();
//        Users user;
//        try {
//            user = new Users("fran", "Frangeris", "Peguero", "123", "algo", "algo", "admin");
//
//        em.getTransaction().begin();
//        em.persist(user);
//
//        } catch (Exception ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        em.getTransaction().commit();
//        em.close();

 
       new Login().showFrame();
      
    }
}
