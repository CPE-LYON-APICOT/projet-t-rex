package Model;

import Controller.GameController;
import Vue.GameView;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TRexGame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("T-Rex Game");
        GameModel model = new GameModel();
        GameView view = new GameView(model);
        GameController controller = new GameController(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(view);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(controller);
    }
}
