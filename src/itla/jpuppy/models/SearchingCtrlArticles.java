/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.models;

import itla.jpuppy.datalayer.Articles;

/**
 *
 * @author Jordhano
 */
public class SearchingCtrlArticles implements SearchingControl{

    @Override
    public Object getValueAt(Object x, int y) {
        Articles temp = (Articles) x;
        switch (y) {
            case 0:
                return temp.getArticleId();
            case 1:
                return temp.getName();
            case 2:
                return temp.getAmount();
            case 3:
                return temp.getPrice();
        }

        return null;
    }
}
