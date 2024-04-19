package Controller;

import Model.GameModel;
import Vue.GameView;

public class GameController extends KeyAdapter implements ActionListener {
    private GameModel model;
    private GameView view;
    private Timer timer;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.timer = new Timer(100, this);
        timer.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            model.getTRex().jump();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.update();
        view.repaint();
    }
}

