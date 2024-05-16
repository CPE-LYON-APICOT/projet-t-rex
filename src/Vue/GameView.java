package Vue;

import java.awt.Color;
import java.awt.Dimension; // Import the Dimension class
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Model.GameModel;
import Model.Obstacle;
import Model.Power;
import Model.TRex;


public class GameView extends JPanel {
    private GameModel model;
    private final int GROUND_LEVEL = 300; // Correspond au sol dans TRex
    private Image trexImage; // Déclarer l'image du T-Rex
    private Image obstacleImage; 
    private Image backgroundImage;


    public GameView(GameModel model) {
        this.model = model;
        setPreferredSize(new Dimension(800, 400));
        setOpaque(true);
        backgroundImage = new ImageIcon("src\\Vue\\fond.gif").getImage();

        // Charger l'image du T-Rex
        ImageIcon trexIcon = new ImageIcon("src\\Vue\\teqshark.png");
        trexImage = trexIcon.getImage();
        if (trexImage == null) {
            System.out.println("Erreur : l'image teqshark.png n'a pas été chargée.");
        }

        // Charger l'image de l'obstacle
        ImageIcon obstacleIcon = new ImageIcon("src\\Vue\\cactus.png");
        obstacleImage = obstacleIcon.getImage();
        if (obstacleImage == null) {
            System.out.println("Erreur : l'image cactus.png n'a pas été chargée.");
        }
    }

    public GameModel getModel() {
        return model;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        TRex tRex = model.getTRex();

        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        g.drawImage(trexImage, tRex.getXPosition(), tRex.getYPosition(), tRex.getWidth(), tRex.getHeight(), this);
        
        List<Obstacle> obstacles = model.getObstacles();
        for (Obstacle obstacle : obstacles) {
            // Dessiner l'image de l'obstacle
            g.drawImage(obstacleImage, obstacle.getXPosition(), obstacle.getYPosition(), obstacle.getWidth(), obstacle.getHeight(), this);
        }
        
        // Dessiner le sol
        g.setColor(Color.BLACK);
        g.fillRect(0, GROUND_LEVEL, getWidth(), 5);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score: " + model.getScore(), 10, 20);

        List<Power> powers = tRex.getPowers();
        if (!powers.isEmpty()) {
        int powerCount = 0;
        for (Power power : powers) {
            if (power.isActive()) {
                g.drawString("Power: " + power.getType() + " (" + power.getDuration() / 60 + "s)", 10, 50 + powerCount * 50);
                powerCount++;
        }
    }
}

        if (model.isGameOver()) {
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over", 300, 200);
        }
    }
}
