/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.utils;

import itla.jpuppy.business.ModelInvoice;

public class GeneratedValues {

    private static int invoiceId;

    private GeneratedValues() {
    }

    public static void begin() {
        invoiceId = new ModelInvoice().searchAllInvoicesByDate("%%").size();
    }

    public static long getNextInvoiceId() {
        invoiceId += 1;
        return invoiceId;
    }

    public static long getInvoiceId() {
        return invoiceId;
    }
}
