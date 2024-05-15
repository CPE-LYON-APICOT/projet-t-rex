package Model;

public class TRex {
    private int xPosition;
    private int yPosition;
    private int yVelocity;
    private final int GRAVITY = 1;
    private final int JUMP_STRENGTH = 13;
    private final int GROUND_LEVEL = 40; // Correspond au sol dans GameView
    private final int WIDTH = 40;
    private final int HEIGHT = 40;

    public TRex() {
        this.xPosition = 50; // Position fixe en x pour simplifier
        this.yPosition = GROUND_LEVEL;
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
        if (yPosition == GROUND_LEVEL) {
            yVelocity = JUMP_STRENGTH; 
        }
    }

    public void update() {
        yPosition += yVelocity;
        if (yPosition < GROUND_LEVEL) {
            yVelocity += GRAVITY;
        } else {
            yPosition = GROUND_LEVEL;
            yVelocity = 0;
        }
    }
}
