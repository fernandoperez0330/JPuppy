package itla.jpuppy;

import itla.jpuppy.business.EntityManagerCreator;
import itla.jpuppy.datalayer.Breeds;
import itla.jpuppy.datalayer.Species;
import itla.jpuppy.datalayer.Users;
import itla.jpuppy.forms.Login;
import itla.jpuppy.utils.EncryptText;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
//        1. Quitar como comentario el codigo abajo
//        2. Ir a persistence.XML y poner drop and create
//        3. Ejecutar
//        4. Cerrar
//        5. Poner como comentario
//        6. En Persistence.XML poner create
            
        //Inserta el primer usuario
//        EntityManager em = EntityManagerCreator.getInstanceEM();
//        Users user;
//        try {
//            user = new Users("Frangeris", "Peguero", "12356789", "fran", EncryptText.md5("123"), "admin");
//
//        em.getTransaction().begin();
//        em.persist(user);
//
//        } catch (Exception ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        em.getTransaction().commit();
//        em.close();

 
    //   new Login().showFrame();
      
        EntityManager em = Persistence.createEntityManagerFactory( "JPuppyPU" ).createEntityManager();
        Species s = new Species( "specie" );
        
        em.getTransaction().begin();
        em.persist( s );
        Breeds b = new Breeds( "anything", s,5.5, 3.5 );
        em.persist( b );
        em.getTransaction().commit();
        em.close();
        
        
    }
}
