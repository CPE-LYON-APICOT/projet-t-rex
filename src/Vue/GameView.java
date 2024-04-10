package Vue;

import javax.swing.*;

import Model.GameModel;
import Model.GameModel.TRex;

import java.awt.*;
import java.util.List;

public class GameView extends JPanel {
    private GameModel model;

    public GameView(GameModel model) {
        this.model = model;
        setPreferredSize(new Dimension(800, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        TRex tRex = model.getTRex();
        g.setColor(Color.GREEN);
        g.fillRect(50, 350 - tRex.getYPosition(), 50, 50); // Dessin du T-Rex

        List<GameModel.Obstacle> obstacles = model.getObstacles();
        g.setColor(Color.RED);
        for (GameModel.Obstacle obstacle : obstacles) {
            g.fillRect(obstacle.getXPosition(), 350, 30, 50); // Dessin des obstacles
        }
    }
}

