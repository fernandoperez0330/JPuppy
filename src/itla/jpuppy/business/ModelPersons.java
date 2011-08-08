package itla.jpuppy.business;

import itla.jpuppy.datalayer.*;
import java.util.List;

public class ModelPersons {

    private QueryManager queryManager;
    private int filter;
    private List<Persons> list;

    public ModelPersons(QueryManager queryManager) {
        this.queryManager = queryManager;
    }

    public void setFilter(int filter) {
        this.filter = filter;
    }

    public Persons searchPerson(Long id) {
        return queryManager.searchPerson(id);
    }

    public List<Persons> searchAllPersons(String name) {
        List<Persons> list = queryManager.searchPersons(name);
        switch (filter) {
            case 1:
                List<Users> users = queryManager.searchUsers(name);
                for (int i = 0; i < users.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).getPersonId() == users.get(i).getPersonId()) {
                            list.remove(j);
                        }
                    }
                }
                break;
            case 2:
                List<Employees> empls = queryManager.searchEmployees(name);
                for (int i = 0; i < empls.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).getPersonId() == empls.get(i).getPersonId()) {
                            list.remove(j);
                        }
                    }
                }
                break;
            case 3:
                List<Customers> customers = queryManager.searchCustomer(name);
                for (int i = 0; i < customers.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).getPersonId() == customers.get(i).getPersonId()) {
                            list.remove(j);
                        }
                    }
                }
                break;
            case 4:
                List<Users> users2 = queryManager.searchUsers(name);
                for (int i = 0; i < users2.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).getPersonId() == users2.get(i).getPersonId()) {
                            list.remove(j);
                        }
                    }
                }
                List<Employees> empls2 = queryManager.searchEmployees(name);
                for (int i = 0; i < empls2.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).getPersonId() == empls2.get(i).getPersonId()) {
                            list.remove(j);
                        }
                    }
                }
                break;
        }

        return list;
    }
}
