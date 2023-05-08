import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ajouterCatégorie extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSpinner spinner1;

    private JFrame parentFrame;

    public ajouterCatégorie(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Ajouter catégorie");

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }


    private void onOK() {
        // add your code here
        erreur dialog = new erreur();
        dialog.pack();
        dialog.setMinimumSize(new Dimension(150, 150));
        dialog.setSize(new Dimension(200, 150));
        dialog.setLocationRelativeTo(ajouterCatégorie.this);
        dialog.setVisible(true);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
