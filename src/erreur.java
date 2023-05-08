import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class erreur extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;

    public erreur() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Erreur !");

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }
}
