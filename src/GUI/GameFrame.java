package GUI;

import javax.swing.JFrame;

import Controller.TRexController;
import Model.TRexModel;
import Vue.TRexView;

import java.awt.BorderLayout;
import javax.swing.SwingUtilities;

public class GameFrame extends JFrame {

    public GameFrame(TRexModel model) {
        initUI(model);
    }

    private void initUI(TRexModel model) {
        setTitle("Jeu TRex");
        setSize(800, 400); // Taille de la fenêtre
        setLocationRelativeTo(null); // Centre la fenêtre
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Ferme l'application lorsque la fenêtre est fermée

        // Créez une instance de GamePanel avec le modèle et l'ajoutez à la fenêtre
        GamePanel gamePanel = new GamePanel(model);
        add(gamePanel, BorderLayout.CENTER);

        // Vous pouvez ajouter d'autres composants ici si nécessaire, par exemple un scorePanel, etc.

        // Rendre la fenêtre visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Assurez-vous que votre application GUI est exécutée dans l'EDT
        SwingUtilities.invokeLater(() -> {
            TRexModel model = new TRexModel();
            TRexView view = new TRexView(); // Assurez-vous que TRexView est adapté pour Swing
            TRexController controller = new TRexController(model, view);
            GameFrame frame = new GameFrame(model);
            frame.add(new GamePanel(model)); // Ajoutez le panneau de jeu à la fenêtre
            frame.setVisible(true); // Affichez la fenêtre
            controller.startGame(); // Commencez le jeu
        });
    }
}
