package Vue;

<<<<<<< HEAD
=======
import Model.GameModel;
import Model.TRex;
import Model.Obstacle;
import Model.Power;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.List;
>>>>>>> bd9279521197e02e08cee3f29fa112599fbdd6ff
import java.awt.Color;
import java.awt.Dimension; // Import the Dimension class
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon; // Import the ImageIcon class
import javax.swing.JPanel;

import Model.GameModel;
import Model.Obstacle;
import Model.TRex;


public class GameView extends JPanel {
    private GameModel model;
<<<<<<< HEAD
    private final int GROUND_LEVEL = 300; // Correspond au sol dans TRex
    private Image trexImage; // Déclarer l'image du T-Rex
    private Image obstacleImage; 
=======
    private final int GROUND_LEVEL = 300;
    private Image trexImage;
>>>>>>> bd9279521197e02e08cee3f29fa112599fbdd6ff

    public GameView(GameModel model) {
        this.model = model;
        setPreferredSize(new Dimension(800, 400));
        setOpaque(true);
<<<<<<< HEAD
        setBackground(Color.BLUE); // Changer la couleur de fond

        // Charger l'image du T-Rex
        ImageIcon trexIcon = new ImageIcon("src/Vue/teqshark.png");
        trexImage = trexIcon.getImage();
        if (trexImage == null) {
            System.out.println("Erreur : l'image teqshark.png n'a pas été chargée.");
        }

        // Charger l'image de l'obstacle
        ImageIcon obstacleIcon = new ImageIcon("src/Vue/cactus.png");
        obstacleImage = obstacleIcon.getImage();
        if (obstacleImage == null) {
            System.out.println("Erreur : l'image cactus.png n'a pas été chargée.");
        }
=======
        setBackground(Color.BLUE);
        ImageIcon ii = new ImageIcon("projet-t-rex\\src\\Vue\\teqshark.png");
        trexImage = ii.getImage();
>>>>>>> bd9279521197e02e08cee3f29fa112599fbdd6ff
    }

    public GameModel getModel() {
        return model;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        TRex tRex = model.getTRex();

        g.drawImage(trexImage, tRex.getXPosition(), tRex.getYPosition(), tRex.getWidth(), tRex.getHeight(), this);
        
        List<Obstacle> obstacles = model.getObstacles();
        for (Obstacle obstacle : obstacles) {
<<<<<<< HEAD
            // Dessiner l'image de l'obstacle
            g.drawImage(obstacleImage, obstacle.getXPosition(), obstacle.getYPosition(), obstacle.getWidth(), obstacle.getHeight(), this);
        }
        
        // Dessiner le sol
=======
            g.fillRect(obstacle.getXPosition(), obstacle.getYPosition(), obstacle.getWidth(), obstacle.getHeight());
        }

>>>>>>> bd9279521197e02e08cee3f29fa112599fbdd6ff
        g.setColor(Color.BLACK);
        g.fillRect(0, GROUND_LEVEL, getWidth(), 5);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score: " + model.getScore(), 10, 20);

        List<Power> powers = tRex.getPowers();
        if (!powers.isEmpty()) {
            for (Power power : powers) {
                if (power.isActive()) {
                    g.drawString("Power: " + power.getType() + " (" + power.getDuration() / 60 + "s)", 10, 50);
                }
            }
        }

        if (model.isGameOver()) {
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over", 300, 200);
        }
    }
}
