package Model;

public class Power {
    private String type;
    private int duration; // Durée du pouvoir en frames ou ticks
    private boolean isActive;

    public Power(String type, int duration) {
        this.type = type;
        this.duration = duration;
        this.isActive = false;
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public void activate() {
        this.isActive = true;
    }

    public void deactivate() {
        this.isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }

    public void update() {
        if (isActive && duration > 0) {
            duration--;
        } else {
            deactivate();
        }
    }
}
