package Model;

import Model.GameModel.Obstacle;

public class GameModel {
    public class TRex {
        private int yPosition;
        private boolean isJumping;

        public TRex() {
            this.yPosition = 0;
            this.isJumping = false;
        }

        public void jump() {
            if (!isJumping) {
                isJumping = true;
                yPosition = 200; // Hauteur du saut
            }
        }

        public void fall() {
            if (isJumping) {
                yPosition -= 30; // Vitesse de chute
                if (yPosition <= 0) {
                    isJumping = false;
                    yPosition = 0;
                }
            }
        }

        public int getYPosition() {
            return yPosition;
        }
    }

    public class Obstacle {
        private int xPosition;

        public Obstacle() {
            this.xPosition = 500; // Position initiale
        }

        public void move() {
            xPosition -= 10; // Vitesse de déplacement
        }

        public int getXPosition() {
            return xPosition;
        }
    }

    public class Trex {
        private int yPosition;
        private int xPosition;
        private boolean isJumping;
        private int jumpPeak;
        private final int JUMP_SPEED = 5;
        private final int GRAVITY = 2;
    
        public Trex() {
            this.yPosition = 0;
            this.xPosition = 50; // Position de départ du T-Rex en X
            this.isJumping = false;
            this.jumpPeak = 100; // Hauteur maximale du saut
        }
    
        public void startJump() {
            if (!isJumping) {
                isJumping = true;
            }
        }
    
        public void updateJump() {
            if (isJumping) {
                if (yPosition < jumpPeak) {
                    yPosition += JUMP_SPEED;
                } else {
                    isJumping = false;
                }
            } else if (yPosition > 0) {
                yPosition -= GRAVITY;
            }
        }
    
        public int getYPosition() {
            return yPosition;
        }
    
        public int getXPosition() {
            return xPosition;
        }
    }

    public void update() {
        tRex.updateJump();
        for (Obstacle obstacle : obstacles) {
            obstacle.move();
        }
        if (Math.random() > 0.95) { // Condition pour ajouter des obstacles aléatoirement
            obstacles.add(new Obstacle());
        }
    }
    
}

