package itla.jpuppy.business;

import javax.persistence.EntityManager;

public class ModelUsers {
  
    private QueryManager manager;
    private EntityManager entityManager;
    
    public ModelUser(){
        entitymanager = EntityManagerCreator.getInstance();
    }
    
    public static boolean validateUser(String name,String password){
        return true;
    }
    
}
