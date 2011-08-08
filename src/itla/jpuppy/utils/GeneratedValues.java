/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.utils;

import itla.jpuppy.business.ModelCustomers;
import itla.jpuppy.business.ModelInvoice;

public class GeneratedValues {

    private static long personId;
    private static int invoiceId;

    private GeneratedValues() {
    }

    public static void begin() {
        personId = new ModelCustomers().searchAllCustomer().size();
        //invoiceId = new ModelInvoice().searchAllArticleByName("").size();
    }

    public static long getNextPersonId() {
        personId += 1;
        return personId;
    }

    public static long getNextInvoiceId() {
        return invoiceId + 1;
    }

    public static long getPersonId() {
        return personId;
    }

    public static long getInvoiceId() {
        return invoiceId;
    }
}
