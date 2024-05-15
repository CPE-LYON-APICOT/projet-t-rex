package Model;

public class Obstacle {
    private int xPosition;
    private final int yPosition;
    private final int width;
    private final int height;
    private final int GROUND_LEVEL = 300;

    public Obstacle(int xPosition) {
        this.xPosition = xPosition;
        this.width = 20;  // Largeur fixe pour simplifier
        this.height = 40; // Hauteur fixe pour simplifier
        this.yPosition = GROUND_LEVEL - height; // Position en y basée sur la hauteur de l'obstacle et le niveau du sol
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void update(int speed) {
        xPosition -= speed; // Déplacer l'obstacle en fonction de la vitesse
    }

    public boolean isOffScreen() {
        return xPosition + width < 0; // Vérifie si l'obstacle est sorti de l'écran
    }

    public boolean collidesWith(TRex tRex) {
        return tRex.getXPosition() < xPosition + width &&
               tRex.getXPosition() + tRex.getWidth() > xPosition &&
               tRex.getYPosition() < yPosition + height &&
               tRex.getYPosition() + tRex.getHeight() > yPosition;
    }
}
