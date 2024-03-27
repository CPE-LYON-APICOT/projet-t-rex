package GUI;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

import Model.TRexModel;

public class GamePanel extends JPanel implements ActionListener {
    private TRexModel model;
    private Timer timer;

    public GamePanel(TRexModel model) {
        this.model = model;
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                processKey(e);
            }
        });
        timer = new Timer(100, this);
        timer.start();
    }

    private void processKey(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            model.jump(); // Assurez-vous que cette méthode existe dans votre modèle
        } else if (key == KeyEvent.VK_DOWN) {
            model.crouch(); // Assurez-vous que cette méthode existe dans votre modèle
        }
        // Ajoutez d'autres contrôles si nécessaire
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessiner le jeu ici
        char[][] screen = model.getScreen();
        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[i].length; j++) {
                if (screen[i][j] == TRexModel.TREX) {
                    // Dessinez le T-Rex, par exemple avec un rectangle ou une image
                } else if (screen[i][j] == TRexModel.OBSTACLE) {
                    // Dessinez un obstacle
                }
                // Ajoutez des conditions pour d'autres éléments si nécessaire
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.update();
        repaint();
    }
}
