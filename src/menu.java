import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class menu extends JFrame {
    private JPanel panel1;
    private JList list1;

    private JList list2;

    private JList list3;



    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private BufferedImage originalImage;
    public menu() {
        // Ajoutez le panel1 au JFrame.
        //add(panel1);

        joueur secondForm = new joueur();
        equipe troisForm = new equipe(menu.this);
        entraineur quatreForm = new entraineur();

        // Configurez le JFrame.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Centre la fenêtre sur l'écran.

        cardLayout = new CardLayout(5, 5);
        mainPanel = new JPanel(cardLayout);


        mainPanel.add(panel1, "Panel 1");
        mainPanel.add(secondForm.panel2, "Panel 2");
        mainPanel.add(troisForm.panel3, "Panel 3");
        mainPanel.add(quatreForm.panel4, "Panel 4");

        add(mainPanel);




        jMenuBar1 = new JMenuBar();
        jMenu4 = new JMenu();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();
        jMenu3 = new JMenu();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion club de foot");
        setMinimumSize(new Dimension(700, 500));



        jMenu4.setText("menu principale");
        jMenuBar1.add(jMenu4);

        jMenu1.setText("ajouter joueur");

        jMenuBar1.add(jMenu1);

        jMenu2.setText("ajouter entraineur");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("ajouter catégorie");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);


        pack();
        setVisible(true);

        // Ajoutez un ActionListener à jMenu4
        jMenu4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(mainPanel, "Panel 1");
            }
        });
        jMenu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ajouterJoueur dialog = new ajouterJoueur();
                dialog.pack();
                dialog.setMinimumSize(new Dimension(450, 250));
                dialog.setSize(new Dimension(450, 250));
                dialog.setLocationRelativeTo(menu.this);
                dialog.setVisible(true);
            }
        });

        jMenu2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ajouterEntraineur dialog = new ajouterEntraineur();
                dialog.pack();
                dialog.setMinimumSize(new Dimension(450, 250));
                dialog.setSize(new Dimension(450, 250));
                dialog.setLocationRelativeTo(menu.this);
                dialog.setVisible(true);
            }
        });

        jMenu3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ajouterCatégorie dialog = new ajouterCatégorie(menu.this);
                dialog.pack();
                dialog.setMinimumSize(new Dimension(150, 150));
                dialog.setSize(new Dimension(200, 150));
                dialog.setLocationRelativeTo(menu.this);
                dialog.setVisible(true);
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateCroppedImage();
            }
        });

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(mainPanel, "Panel 2");
            }
        });
        list3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(mainPanel, "Panel 3");
            }
        });
        list2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(mainPanel, "Panel 4");
            }
        });
    }



    public static void main(String[] args) {
        // Créez une instance de la classe menu.
        menu frame = new menu();
    }

    private void updateCroppedImage() {
        int panelWidth = getContentPane().getWidth();
        int panelHeight = getContentPane().getHeight();

        // Rogne l'image en fonction de la taille du panneau
        BufferedImage croppedImage = originalImage.getSubimage(0, 0, panelWidth, panelHeight);

        // Met à jour l'image du JLabel
        imageLabel.setIcon(new ImageIcon(croppedImage));
    }
}

