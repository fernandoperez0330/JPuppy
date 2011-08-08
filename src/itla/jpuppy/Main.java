package itla.jpuppy;

import itla.jpuppy.business.EntityManagerCreator;
import itla.jpuppy.business.GeneralModel;
import itla.jpuppy.business.ModelBreeds;
import itla.jpuppy.business.ModelSpecies;
import itla.jpuppy.business.QueryManager;
import itla.jpuppy.datalayer.Breeds;
import itla.jpuppy.datalayer.Species;
import itla.jpuppy.datalayer.Users;
import itla.jpuppy.forms.Login;
import itla.jpuppy.forms.ManageAppointnments;
import itla.jpuppy.forms.ManageBreeds;
import itla.jpuppy.utils.EncryptText;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
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
        EntityManager em = EntityManagerCreator.getInstanceEM();
        Users user;
        try {
            user = new Users("Admintrador", "JPuppy", "123456789", "admin", EncryptText.md5("123456"), "admin");
        em.getTransaction().begin();
        em.persist(user);

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        em.getTransaction().commit();
        em.close();

       new Login().showFrame();
    }
}
