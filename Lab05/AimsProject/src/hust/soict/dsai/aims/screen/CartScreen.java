package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {

    private Cart cart;

    public CartScreen(Cart cart) {
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // JFXPanel dung de nhung JavaFX vao Swing
        JFXPanel fxPanel = new JFXPanel();
        cp.add(fxPanel, BorderLayout.CENTER);

        setTitle("AIMS Cart");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Load JavaFX UI tren JavaFX Application Thread
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
        });

        setVisible(true);
    }

    private void initFX(JFXPanel fxPanel) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("cart.fxml")
            );

            // Truyen cart sang controller
            CartScreenController controller = new CartScreenController(cart);
            loader.setController(controller);

            Parent root = loader.load();
            Scene scene = new Scene(root);

            fxPanel.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(
                            CartScreen.this,
                            "Cannot load cart.fxml\n" + e.getMessage(),
                            "FXML Loading Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            });
        } catch (Exception e) {
            e.printStackTrace();

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(
                            CartScreen.this,
                            "Unexpected error\n" + e.getMessage(),
                            "Cart Screen Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            });
        }
    }
}