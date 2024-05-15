package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GameModel {
    private TRex tRex;
    private List<Obstacle> obstacles;
    private Random random;
    private int score;
    private boolean gameOver;
    private int obstacleSpeed;
    private int obstacleFrequency;

    public GameModel() {
        tRex = new TRex();
        obstacles = new ArrayList<>();
        random = new Random();
        score = 0;
        gameOver = false;
        obstacleSpeed = 10;
        obstacleFrequency = 100; // Frequency for obstacle appearance
    }

    public TRex getTRex() {
        return tRex;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public int getScore() {
        return score;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void update() {
        if (!gameOver) {
            tRex.update();
            for (Obstacle obstacle : obstacles) {
                obstacle.update(obstacleSpeed);
            }

            // Remove off-screen obstacles
            Iterator<Obstacle> iterator = obstacles.iterator();
            while (iterator.hasNext()) {
                Obstacle obstacle = iterator.next();
                if (obstacle.isOffScreen()) {
                    iterator.remove();
                }
            }

            // Randomly add new obstacles
            if (random.nextInt(obstacleFrequency) < 5) {
                obstacles.add(new Obstacle(800));
            }

            // Increase difficulty over time
            increaseDifficulty();

            // Check for collisions
            checkCollisions();

            // Update score
            score++;
        }
    }

    private void increaseDifficulty() {
        if (score % 1000 == 0) {
            obstacleSpeed += 1;
            if (obstacleFrequency > 20) {
                obstacleFrequency -= 5;
            }
        }
    }

    private void checkCollisions() {
        for (Obstacle obstacle : obstacles) {
            if (tRex.getXPosition() + tRex.getWidth() > obstacle.getXPosition() &&
                tRex.getXPosition() < obstacle.getXPosition() + obstacle.getWidth() &&
                tRex.getYPosition() + tRex.getHeight() > obstacle.getYPosition()) {
                gameOver = true;
            }
        }
    }

    public void restart() {
        tRex = new TRex();
        obstacles.clear();
        score = 0;
        gameOver = false;
        obstacleSpeed = 10;
        obstacleFrequency = 100;
    }
}

