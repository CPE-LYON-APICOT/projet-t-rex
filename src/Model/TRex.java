package Model;

public class TRex {
    private int xPosition;
    private int yPosition;
    private int yVelocity;
    private final int GRAVITY = 1;
    private final int JUMP_STRENGTH = 15;
    private final int GROUND_LEVEL = 300;
    private final int WIDTH = 40;
    private final int HEIGHT = 40;
    private final int WINDOW_HEIGHT = 400;

    public TRex() {
        this.xPosition = 50; // Position fixe en x pour simplifier
        this.yPosition = GROUND_LEVEL - HEIGHT; // Position initiale en y (sur le sol)
        this.yVelocity = 0;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public void jump() {
        if (yPosition == GROUND_LEVEL - HEIGHT) { // Seul saut s'il est au sol
            yVelocity = -JUMP_STRENGTH; // La vitesse doit être négative pour sauter vers le haut
        }
    }

    public void update() {
        yPosition += yVelocity;
        if (yPosition < GROUND_LEVEL - HEIGHT) { // Tant qu'il n'a pas atteint le sol
            yVelocity += GRAVITY; // Appliquer la gravité pour descendre
        } else {
            yPosition = GROUND_LEVEL - HEIGHT; // Réinitialiser la position au sol
            yVelocity = 0; // Réinitialiser la vitesse au sol
        }
    }
}
