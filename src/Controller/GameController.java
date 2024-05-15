package Controller;

import Model.GameModel;
import Vue.GameView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

public class GameController extends KeyAdapter implements ActionListener {
    private GameModel model;
    private GameView view;
    private Timer timer;

    public GameController(GameView view) {
        this.view = view;
        this.model = view.getModel();
        timer = new Timer(20, this); // Update every 20 ms
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.update();
        view.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (model.isGameOver()) {
                model.restart();
            } else {
                model.getTRex().jump();
            }
        }
    }
}
