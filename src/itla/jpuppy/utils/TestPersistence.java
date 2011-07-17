package itla.jpuppy.utils;

import itla.jpuppy.business.EntityManagerCreator;
import itla.jpuppy.datalayer.*;

public final class TestPersistence {

    public TestPersistence() {
        insertEntity();
    }

    private void insertEntity() {
        Users usersEntity = new Users();
        
        usersEntity.setApellido("Apellido");
        usersEntity.setCelular("Celular");
        usersEntity.setNombre("Nombre"); 
        usersEntity.setTelefono("Telefono");
        usersEntity.setTipoUsuario("Nivel");
        
        //Inicia prueba de transaccion
        EntityManagerCreator.getInstance().getEntity().getTransaction().begin();
        EntityManagerCreator.getInstance().getEntity().persist(usersEntity);
        //EntityManagerCreator.getInstance().getEntity().getTransaction().commit();
        EntityManagerCreator.getInstance().getEntity().close();
    }
}
