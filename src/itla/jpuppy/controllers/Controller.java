package itla.jpuppy.controllers;

public class Controller {

    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnCancel;
    private javax.swing.JPanel pnlEdition;

    protected void stateButtons(boolean state1, boolean state2) {
        btnAdd.setEnabled(state1);
        btnUpdate.setEnabled(state1);
        btnSearch.setEnabled(state1);
        btnSave.setEnabled(state2);
        btnRemove.setEnabled(state1);
        btnCancel.setEnabled(state2);


    }

    public void changeStatePnlEdition(boolean state) {
        javax.swing.JComponent a;
        for (int i = 0; i < pnlEdition.getComponentCount(); i++) {
            a = (javax.swing.JComponent) pnlEdition.getComponent(i);
            a.setEnabled(state);
        }
    }
}
