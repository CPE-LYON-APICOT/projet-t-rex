package Vue;

import Model.TRexModel;

public class TRexView {
    static final char HORIZON = '_';
    static final char OBSTACLE = 'x';
    static final char TREX = 'T';

    public void printScreen(TRexModel model) {
        for (int i = 0; i < TRexModel.HEIGHT; i++) {
            for (int j = 0; j < TRexModel.WIDTH; j++) {
                System.out.print(model.getValueAt(i, j));
            }
            System.out.println();
        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public void gameOver() {
        System.out.println("Game Over!");
    }

    public void printScore(int score) {
        System.out.println("Score: " + score);
    }
    public void printInstructions() {
        System.out.println("Press '↑' to jump");
        System.out.println("Press '↓' to crouching");
    }

    public void printWelcome() {
        System.out.println("Welcome to TRex Runner!");
    }

    public void printGoodbye() {
        System.out.println("Goodbye!");
    }
}
