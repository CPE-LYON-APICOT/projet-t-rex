package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Model.TRexModel;
import Vue.TRexView;

public class TRexController {
    private TRexModel model;
    private TRexView view;
    private BufferedReader reader;
    private boolean running = true;

    public TRexController(TRexModel model, TRexView view) {
        this.model = model;
        this.view = view;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
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
                Thread.sleep(500); // Sleep time is reduced for more responsive input
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

        // Check for user input
        if (reader.ready()) {
            char input = (char) reader.read();
            if (input == 's') {
                System.out.println("Crouch command received"); // Debug line
                model.crouch();
            } else if (input == 'z') {
                model.jump();
            }
            // Consume the rest of the input line to avoid handling old input in the next frame
            reader.readLine();
        }

        // Update T-Rex position
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
