package Model;

import java.util.ArrayList;
import java.util.List;

public class TRex {
    private int xPosition;
    private int yPosition;
    private int yVelocity;
    private int jumpStrength; // Ajouté pour permettre la modification de la force de saut
    private final int GRAVITY = 2;
    private final int BASE_JUMP_STRENGTH = 20;
    private final int GROUND_LEVEL = 300;
    private final int WIDTH = 50;
    private final int HEIGHT = 50;
    private List<Power> powers;

    public TRex() {
        this.xPosition = 50;
        this.yPosition = GROUND_LEVEL - HEIGHT;
        this.yVelocity = 0;
        this.jumpStrength = BASE_JUMP_STRENGTH; // Initialisation de la force de saut
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
            yVelocity = -jumpStrength; // Utilisation de jumpStrength pour la force de saut
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
        switch (power.getType()) {
            case "slow_jump":
                jumpStrength = BASE_JUMP_STRENGTH / 2; // Réduire la force de saut
                break;
            case "invincibility":
                // Code pour l'invincibilité, si nécessaire
                break;
            default:
                jumpStrength = BASE_JUMP_STRENGTH; // Réinitialiser la force de saut après le malus
                break;
        }
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
