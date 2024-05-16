package Vue;

import Model.GameModel;
import Model.TRex;
import Model.Obstacle;
import Model.Power;
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
    private final int GROUND_LEVEL = 300;
    private Image trexImage;

    public GameView(GameModel model) {
        this.model = model;
        setPreferredSize(new Dimension(800, 400));
        setOpaque(true);
        setBackground(Color.BLUE);
        ImageIcon ii = new ImageIcon("projet-t-rex\\src\\Vue\\teqshark.png");
        trexImage = ii.getImage();
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
        g.setColor(Color.RED);
        for (Obstacle obstacle : obstacles) {
            g.fillRect(obstacle.getXPosition(), obstacle.getYPosition(), obstacle.getWidth(), obstacle.getHeight());
        }

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
