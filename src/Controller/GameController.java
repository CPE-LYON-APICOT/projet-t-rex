package Controller;

import javax.swing.*;

import Model.GameModel;
import Model.progression;
import Vue.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameController extends KeyAdapter implements ActionListener {
    private GameModel model;
    private GameView view;
    private Timer timer;

    @SuppressWarnings("deprecation")
    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.timer = new Timer(50 , this);
        timer.start();
        progression.getInstance().addObserver((o, arg) -> {
            var nvDelai = (int)(timer.getDelay()* 0.9);

            nvDelai =Math.max(10, (int) (100- java.lang.Math.pow(((progression)o).getProgression() ,1.25)));
            System.out.println(nvDelai);
            timer.setDelay(nvDelai);
        });
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            model.getTRex().startJump();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.update();
        view.repaint();
    }

    public void jump() {
        model.getTRex().jump();
    }
}

