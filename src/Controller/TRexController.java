package Controller;

import java.io.IOException;
import java.util.Scanner;

import Model.TRexModel;
import Vue.TRexView;

public class TRexController {
    private TRexModel model;
    private TRexView view;
    private Scanner scanner;
    private boolean running = true;

    public TRexController(TRexModel model, TRexView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void startGame() throws IOException {
        while (running) {
            // Update model and view
            updateGame();
            renderGame();

            // Check for collision, end game if collision occurs
            if (model.checkCollision()) {
                view.gameOver();
                running = false;
            }

            // Sleep to control frame rate
            try {
                Thread.sleep(400); // Add this to slow down the loop for human interaction
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void updateGame() throws IOException {
        // Clear the screen
        model.clearScreen();

        // Update the floor and obstacles
        model.updateFloor();
        model.placeObstaclesIfNeeded();

        // Check for jump input
        if (System.in.available() > 0) {
            scanner.nextLine();
            model.jump();
        }

        // Update T-Rex position based on gravity and jump
        model.updatePosition();
    }

    private void renderGame() {
        view.printScreen(model);
    }

    public static void main(String[] args) throws IOException {
        TRexModel model = new TRexModel();
        TRexView view = new TRexView();
        TRexController controller = new TRexController(model, view);
        view.printWelcome();
        view.printInstructions();
        controller.startGame();
    }
}