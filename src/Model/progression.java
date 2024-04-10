package Model;

import java.util.Observable;

public class progression extends Observable {
    private static progression instance;
    private int progression = 0;

    public void obstaclePasser(){
        progression++;
        setChanged();
        notifyObservers();
    }

    public int getProgression(){
        return progression;
    }

    public static progression getInstance() {
        if(instance == null)
            instance = new progression();
        return instance;
    }
}
