import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class equipe extends Component {
    private JTable table1;
    private JTable table2;
    private JTable table3;
    protected JPanel panel3;
    private JButton ajouterHistoriqueButton;
    private JFrame parentFrame;
public equipe(JFrame parentFrame) {
    this.parentFrame = parentFrame;
    ajouterHistoriqueButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            ajouterHistorique dialog = new ajouterHistorique();
            dialog.pack();
            dialog.setMinimumSize(new Dimension(450, 250));
            dialog.setSize(new Dimension(450, 250));
            dialog.setLocationRelativeTo(equipe.this);
            dialog.setVisible(true);
        }
    });
}
}
