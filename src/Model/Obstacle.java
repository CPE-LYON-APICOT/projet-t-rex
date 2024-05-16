package Model;

public class Obstacle {
    private int xPosition;
    private final int yPosition;
    private final int width;
    private final int height;
    private final int GROUND_LEVEL = 300;
    private final int MIN_SPACE = 100; // Minimum space between obstacles
    private final int MAX_SPACE = 300; // Maximum space between obstacles
    private final int MIN_JUMP_SPACE = 150; // Minimum space to allow jumping

    public Obstacle(int xPosition) {
        this.xPosition = xPosition;
        this.width = 20;  // Fixed width for simplicity
        this.height = 40; // Fixed height for simplicity
        this.yPosition = GROUND_LEVEL - height; // Y position based on obstacle height and ground level
        int space = (int) (Math.random() * (MAX_SPACE - MIN_JUMP_SPACE + 1)) + MIN_JUMP_SPACE; // Randomly generate space between obstacles ensuring enough space for a jump
        this.xPosition += space + 100; // Add space to x position
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
