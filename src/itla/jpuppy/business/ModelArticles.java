package itla.jpuppy.business;

import itla.jpuppy.datalayer.*;
import java.util.List;
import javax.persistence.EntityManager;

public class ModelArticles implements GeneralModel {

    private static QueryManager queryManager;
    private Object g;

    public ModelArticles() {
        queryManager = new QueryManager();
    }

    public static QueryManager getQueryManager() {
        return queryManager;
    }
    
    

    //retorna un objeto especifico tipo Users cuando se llame debe cargarse el Id desde generalVariableID del paquete util
    //los datos se le asignan cuando el usuario selecciona un cliente  del table
    public Articles searchArticle(Long id) {
        EntityManager entityManager = EntityManagerCreator.getInstanceEM();
        Articles temp = entityManager.find(Articles.class, id);
        return temp;
    }

    // retorna lista de patient para autocomplete

    public List<Articles> searchAllArticleByName(String name) {
        return queryManager.searchArticles(name);
    }
    //Metodos comunes a todos los modelos , se llama el correspondiente de  queryManager

    @Override
    public boolean deleteObject(Object object) {
        return queryManager.deleteObject(object);

    }

    @Override
    public boolean updateObject(Object object) {
        Articles g = (Articles) object;
        return queryManager.updateObject(g);
    }

    @Override
    public boolean insertObject(Object object) {
        Articles g = (Articles) object;
        return queryManager.saveObject(g);
    }
}
