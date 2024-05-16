package Model;

public class Obstacle {
    private int xPosition;
    private final int yPosition;
    private final int width;
    private final int height;
    private final int GROUND_LEVEL = 300;
    private final int MIN_SPACE = 100; // Minimum space between obstacles
    private final int MAX_SPACE = 150; // Maximum space between obstacles

    private static int lastXPosition = 0; // Track the position of the last created obstacle

    public Obstacle(int xPosition) {
        this.xPosition = Math.max(xPosition, lastXPosition + MIN_SPACE);
        this.width = 20;  // Fixed width for simplicity
        this.height = 40; // Fixed height for simplicity
        this.yPosition = GROUND_LEVEL - height; // Y position based on obstacle height and ground level
        lastXPosition = this.xPosition + this.width + (int) (Math.random() * (MAX_SPACE - MIN_SPACE + 1)) + MIN_SPACE; // Update lastXPosition
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
        xPosition -= speed; // Move obstacle based on speed
    }

    public boolean isOffScreen() {
        return xPosition + width < 0; // Check if the obstacle is off screen
    }

    public boolean collidesWith(TRex tRex) {
        return tRex.getXPosition() < xPosition + width &&
               tRex.getXPosition() + tRex.getWidth() > xPosition &&
               tRex.getYPosition() < yPosition + height &&
               tRex.getYPosition() + tRex.getHeight() > yPosition;
    }
}
