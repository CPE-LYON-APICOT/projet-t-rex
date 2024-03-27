package Model;

import java.util.Arrays;
import java.util.Random;

public class TRexModel {
    public static final int WIDTH = 40;
    public static final int HEIGHT = 10;
    private static final int FLOOR_HEIGHT = 8;
    private static final int GRAVITY = 1;
    private static final int JUMP_STRENGTH = -3;
    private static final char HORIZON = '_';  // Utilisez le caractère sous-ligne pour le sol
    private static final char OBSTACLE = 'x'; // Utilisez le caractère x pour les obstacles
    private static final char TREX = 'T';     // Utilisez le caractère T pour le T-Rex
    private char[][] screen = new char[HEIGHT][WIDTH];
    private int tRexPositionX = 2;
    private int tRexPositionY = FLOOR_HEIGHT;
    private int velocityY = 0;
    private boolean isJumping = false;
    private boolean isCrouching = false;
    private int obstacleSpacing = 3;  // Commencez avec un espacement initial pour le premier obstacle
    private Random random = new Random();

    public TRexModel() {
        clearScreen();
        // Initialisez la ligne du sol avec le caractère HORIZON
        Arrays.fill(screen[FLOOR_HEIGHT], HORIZON);
    }

    // ... Les autres méthodes sont inchangées ...

    public void clearScreen() {
        for (int i = 0; i < HEIGHT; i++) {
            Arrays.fill(screen[i], ' ');
        }
        // Restaurez la ligne du sol après avoir effacé l'écran
        Arrays.fill(screen[FLOOR_HEIGHT], HORIZON);
    }

    public char getValueAt(int y, int x) {
        return screen[y][x];
    }

    public void updateFloor() {
        // Déplacez le sol d'une case vers la gauche
        for (int i = 0; i < WIDTH - 1; i++) {
            screen[FLOOR_HEIGHT][i] = screen[FLOOR_HEIGHT][i + 1];
        }
        // Générez un nouveau caractère aléatoire pour la dernière case
        screen[FLOOR_HEIGHT][WIDTH - 1] = random.nextBoolean() ? HORIZON : ' ';
    }

    public void placeObstaclesIfNeeded() {
        // Générez un nouvel obstacle si l'espacement est atteint
        if (obstacleSpacing == 0) {
            int obstacleHeight = random.nextInt(FLOOR_HEIGHT);
            screen[obstacleHeight][WIDTH - 1] = OBSTACLE;
            obstacleSpacing = 3 + random.nextInt(3);  // Générer un nouvel espacement
        } else {
            obstacleSpacing--;
        }
    }

    public void updatePosition() {
        // Mise à jour de la position du T-Rex lorsqu'il saute
        if (isJumping) {
            tRexPositionY += velocityY; // Déplacez le T-Rex verticalement en fonction de la vélocité
            velocityY += GRAVITY; // Appliquez la gravité pour changer la vélocité pour le prochain cycle

            // Vérifiez si le T-Rex a atterri sur le sol
            if (tRexPositionY >= FLOOR_HEIGHT) {
                tRexPositionY = FLOOR_HEIGHT; // Fixez la position du T-Rex sur le sol
                isJumping = false; // Arrêtez le saut
                velocityY = 0; // Réinitialisez la vélocité
            }
        }

        // Mise à jour de l'écran pour représenter le T-Rex
        // Assurez-vous que la ligne ci-dessous est à la bonne place dans votre jeu
        // Par exemple, effacez l'ancienne position du T-Rex avant de dessiner la nouvelle
        screen[tRexPositionY][tRexPositionX] = TREX; 
    }

    public void jump() {
        if (!isJumping) {
            isJumping = true;
            velocityY = JUMP_STRENGTH;
        }
    }

    public boolean checkCollision() {
        // Vérifiez si le T-Rex est en collision avec un obstacle
        if (screen[tRexPositionY][tRexPositionX] == OBSTACLE) {
            return true;
        }
        return false;
    }
}
