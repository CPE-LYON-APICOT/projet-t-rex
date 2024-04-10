import javax.swing.*;

import Controller.GameController;
import Model.GameModel;
import Vue.GameView;

public class Game {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameModel model = new GameModel();
            GameView view = new GameView(model);
            JFrame frame = new JFrame("T-Rex Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(view);
            frame.pack();
            frame.setVisible(true);
            frame.addKeyListener(new GameController(model, view));
        });
    }
}