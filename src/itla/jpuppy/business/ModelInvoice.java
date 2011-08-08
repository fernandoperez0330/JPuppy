package itla.jpuppy.business;

import itla.jpuppy.datalayer.*;
import java.util.List;
import javax.persistence.EntityManager;

public class ModelInvoice implements GeneralModel {

    private static QueryManager queryManager;
    private Object g;

    public ModelInvoice() {
        queryManager = new QueryManager();
    }
    public ModelInvoice(QueryManager queryManager) {
        this.queryManager = queryManager;
    }

    public static QueryManager getQueryManager() {
        return queryManager;
    }
    
    public Invoice searchArticle(Long id) {
        EntityManager entityManager = EntityManagerCreator.getInstanceEM();
        Invoice temp = entityManager.find(Invoice.class, id);
        return temp;
    }
    
    // retorna lista de patient para autocomplete

    public List<Invoice> searchAllInvoicesByDate(String date) {
        return queryManager.searchInvoices(date);
    }
    //Metodos comunes a todos los modelos , se llama el correspondiente de  queryManager

    @Override
    public boolean deleteObject(Object object) {
        return queryManager.deleteObject(object);

    }

    @Override
    public boolean updateObject(Object object) {
        Invoice g = (Invoice) object;
        return queryManager.updateObject(g);
    }

    @Override
    public boolean insertObject(Object object) {
        Invoice g = (Invoice) object;
        return queryManager.saveObject(g);
    }
}
