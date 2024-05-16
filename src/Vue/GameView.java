package Vue;

import Model.GameModel;
import Model.TRex;
import Model.Obstacle;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;

public class GameView extends JPanel {
    private GameModel model;
    private final int GROUND_LEVEL = 300; // Correspond au sol dans TRex
    private Image trexImage; // Déclarer l'image du T-Rex

    public GameView(GameModel model) {
        this.model = model;
        setPreferredSize(new Dimension(800, 400));
        setOpaque(true);
        setBackground(Color.BLUE); // Changer la couleur de fond

        // Charger l'image du T-Rex
        ImageIcon ii = new ImageIcon("C:\\Users\\HP\\Documents\\Cours\\CPE\\Deuxième semestre\\POO\\shark\\projet-t-rex\\src\\Vue\\teqshark.png"); // Chemin relatif
        trexImage = ii.getImage();
    }

    public GameModel getModel() {
        return model;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        TRex tRex = model.getTRex();

        // Dessiner l'image du T-Rex
        g.drawImage(trexImage, tRex.getXPosition(), tRex.getYPosition(), tRex.getWidth(), tRex.getHeight(), this);

        List<Obstacle> obstacles = model.getObstacles();
        g.setColor(Color.RED);
        for (Obstacle obstacle : obstacles) {
            g.fillRect(obstacle.getXPosition(), obstacle.getYPosition(), obstacle.getWidth(), obstacle.getHeight()); // Dessin des obstacles
        }

        // Dessiner le sol
        g.setColor(Color.BLACK);
        g.fillRect(0, GROUND_LEVEL, getWidth(), 5); // Ligne représentant le sol

        // Dessiner le score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score: " + model.getScore(), 10, 20);

        // Dessiner le message de fin de jeu
        if (model.isGameOver()) {
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over", 300, 200);
        }
    }
}
