package Model;

import java.util.ArrayList;
import java.util.List;

public class TRex {
    private int xPosition;
    private int yPosition;
    private int yVelocity;
    private final int GRAVITY = 2;
    private final int JUMP_STRENGTH = 20;
    private final int GROUND_LEVEL = 300;
    private final int WIDTH = 50;
    private final int HEIGHT = 50;
    private List<Power> powers;

    public TRex() {
        this.xPosition = 50;
        this.yPosition = GROUND_LEVEL - HEIGHT;
        this.yVelocity = 0;
        this.powers = new ArrayList<>();
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
        if (yPosition == GROUND_LEVEL - HEIGHT) {
            yVelocity = -JUMP_STRENGTH;
        }
    }

    public void update() {
        yPosition += yVelocity;
        if (yPosition < GROUND_LEVEL - HEIGHT) {
            yVelocity += GRAVITY;
        } else {
            yPosition = GROUND_LEVEL - HEIGHT;
            yVelocity = 0;
        }

        // Appliquer les effets des pouvoirs actifs
        for (Power power : powers) {
            if (power.isActive()) {
                applyPower(power);
                power.update();
            }
        }
    }

    public void applyPower(Power power) {
        // Pour le moment, nous n'avons pas de comportement spécifique à chaque type de pouvoir
    }

    public void addPower(Power power) {
        powers.add(power);
        power.activate();
    }

    public void removePower(Power power) {
        power.deactivate();
        powers.remove(power);
    }

    public boolean hasPower(String type) {
        for (Power power : powers) {
            if (power.getType().equals(type) && power.isActive()) {
                return true;
            }
        }
        return false;
    }

    public List<Power> getPowers() {
        return powers;
    }
}
