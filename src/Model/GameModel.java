package Model;

import Model.GameModel.Obstacle;
import Model.GameModel.TRex;

public class GameModel {
    // Constantes pour les dimensions et positions
    private static final int TREX_WIDTH = 50;
    private static final int TREX_HEIGHT = 50;
    private static final int OBSTACLE_WIDTH = 20;
    private static final int OBSTACLE_HEIGHT = 40;
    private static final int GROUND_Y = 300;
    
    // Variables pour gérer la difficulté du jeu
    private float gameSpeed = 20.0f; // Vitesse initiale du jeu
    private float speedIncrease = 20.0f; // Augmentation de la vitesse du jeu
    int screenWidth = 800;  // Ou la largeur de votre zone de jeu
    int minSpacing = 400;  // Espace minimal entre les obstacles
    int randomSpacing = new Random().nextInt(400);

    private TRex tRex;
    private List<Obstacle> obstacles;

    public GameModel() {
        tRex = new TRex();
        obstacles = new ArrayList<>();
    }

    public boolean checkCollision() {
        Rectangle trexRect = new Rectangle(tRex.getXPosition(), GROUND_Y - tRex.getYPosition() - TREX_HEIGHT, TREX_WIDTH, TREX_HEIGHT);

        for (Obstacle obstacle : obstacles) {
            Rectangle obstacleRect = new Rectangle(obstacle.getXPosition(), GROUND_Y - OBSTACLE_HEIGHT, OBSTACLE_WIDTH, OBSTACLE_HEIGHT);
            if (trexRect.intersects(obstacleRect)) {
                return true;
            }
        }
        return false;
    }

    public void update() {
        gameSpeed += speedIncrease; // Augmentez la vitesse du jeu progressivement
    
        tRex.update(); // Mise à jour du T-Rex
    
        // Mise à jour des obstacles
        for (Obstacle obstacle : obstacles) {
            obstacle.move(gameSpeed);
        }
    
        // Supprimer les obstacles qui sont sortis de l'écran
        obstacles.removeIf(obstacle -> obstacle.getXPosition() < -OBSTACLE_WIDTH);
    
        // Déterminez si un nouvel obstacle doit être ajouté
        int rightmostObstacleX = obstacles.isEmpty() ? 0 : obstacles.get(obstacles.size() - 1).getXPosition();


        //verifier la condition pour que ca marche
        if (screenWidth - rightmostObstacleX > minSpacing + randomSpacing) {
            Obstacle newObstacle = new Obstacle(); // Créez le nouvel obstacle
            obstacles.add(newObstacle);
            rightmostObstacleX = screenWidth; // Réinitialisez la position du dernier obstacle ajouté
        }

        var anyObstacleBehindTrex = obstacles.stream().filter(obstacle -> obstacle.getXPosition() < tRex.getXPosition()).findAny();
        if( anyObstacleBehindTrex.isPresent()) {
            obstacles.remove(anyObstacleBehindTrex.get());
            obstaclePassed();
        }

        // Vérifiez la collision
        if (checkCollision()) {
            javax.swing.SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, "Collision! Le jeu est terminé.", "Game Over", JOptionPane.INFORMATION_MESSAGE));
            gameOver();
        }
    }
    
    public void gameOver() {
        obstacles.clear();
        gameSpeed = 1.0f;
    }

    public TRex getTRex() {
        return tRex;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public class TRex {
        private int yPosition;
        private int xPosition;
        private boolean isJumping;
        private int jumpSpeed = 50; // La vitesse initiale du saut
        private final int RUN_SPEED = 5;
        private final int GRAVITY = 3;

        public TRex() {
            this.yPosition = 0;
            this.xPosition = 50; // Position initiale en X pour le T-Rex
            this.isJumping = false;
        }

        public void jump() {
            if (!isJumping) {
                isJumping = true;
                this.jumpSpeed = 30; // Réinitialiser la vitesse du saut pour chaque nouveau saut
            }
        }

        public void update() {
            if (isJumping) {
                yPosition += jumpSpeed;
                xPosition += RUN_SPEED;
                jumpSpeed -= GRAVITY; // Appliquer la gravité pour ramener le T-Rex au sol

                if (yPosition <= 0) {
                    yPosition = 0;
                    xPosition = 50; // Réinitialiser la position en X après atterrissage
                    isJumping = false;
                }
            }
        }

        public int getYPosition() {
            return yPosition;
        }

        public int getXPosition() {
            return xPosition;
        }

        public boolean isJumping() {
            return isJumping;
        }

        public void startJump() {
            if (!isJumping) {
                jump();
            }
        }
    }

    public class Obstacle {
        private int xPosition;
        
        public Obstacle() {
            this.xPosition = 800; // Position initiale hors de l'écran à droite
        }

        public float getGameSpeed() {
            return gameSpeed;
        }

        public void move(float gameSpeed) {
            xPosition -= 10; // Vitesse de déplacement des obstacles
        }

        public int getXPosition() {
            return xPosition;
        }
    }

    // Méthode appelée lorsqu'un obstacle est passé
    public void obstaclePassed() {
      progression.getInstance().obstaclePasser();
    }
}
