/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.jpuppy.utils;

/**
 *
 * @author Jordhano
 * Restriction String Length
 */
public class RestrictionSLength extends javax.swing.text.PlainDocument {

    private javax.swing.text.JTextComponent field;
    private int lenght;

    public RestrictionSLength(javax.swing.text.JTextComponent field, int lenght) {
        this.field = field;
        this.lenght = lenght;
    }

    @Override
    public void insertString(int arg0, String arg1, javax.swing.text.AttributeSet a) throws javax.swing.text.BadLocationException {

        for (int i = 0; i < arg1.length(); i++) {
            if ((field.getText().length() + arg1.length()) >= lenght) {
                return;
            }
        }
        super.insertString(arg0, arg1, a);
    }
    
}
