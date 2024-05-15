package Model;

public class Obstacle {
    private int xPosition;
    private final int yPosition = 50; // Position au sol, correspondant au GROUND_LEVEL du T-Rex
    private final int width = 20;
    private final int height = 40;

    public Obstacle(int xPosition) {
        this.xPosition = xPosition;
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
        xPosition -= speed;
    }

    public boolean isOffScreen() {
        return xPosition + width < 0;
    }
}
