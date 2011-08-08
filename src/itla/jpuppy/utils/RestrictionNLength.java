/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.utils;

/**
 *
 * @author Jordhano
 * Restriction Number Length
 */
public class RestrictionNLength extends javax.swing.text.PlainDocument {

    private javax.swing.text.JTextComponent field;
    private int length;
    private boolean isInteger;

    public RestrictionNLength(javax.swing.text.JTextComponent field, int length, boolean isInteger) {
        this.field = field;
        this.length = length;
        this.isInteger = isInteger;
    }

    @Override
    public void insertString(int arg0, String arg1, javax.swing.text.AttributeSet a) throws javax.swing.text.BadLocationException {

        int n = 0;
        for (int i = 0; i < arg1.length(); i++) {
            n = (int) arg1.charAt(i);
            if ((field.getText().length() + arg1.length()) > length) {
                return;
            }
            if (!(n > 45 && n < 58)) {
                return;
            }

            if ((n == 46) && (isInteger == true)) {
                return;
            }

            if ((n ==46) && (field.getText().indexOf(".") != -1) && (isInteger == false)) {
                return;
            }
        }
        super.insertString(arg0, arg1, a);
    }
}
