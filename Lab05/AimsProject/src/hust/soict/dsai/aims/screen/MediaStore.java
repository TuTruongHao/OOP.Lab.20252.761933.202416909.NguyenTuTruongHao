package hust.soict.dsai.aims.screen;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {

    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(300, 180));
        this.setBorder(BorderFactory.createEtchedBorder());

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 18));
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);
        cost.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(e -> {
            cart.addMedia(media);
            JOptionPane.showMessageDialog(
                    this,
                    media.getTitle() + " has been added to cart."
            );
        });

        container.add(btnAddToCart);

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");

            btnPlay.addActionListener(e -> {
                try {
                    ((Playable) media).play();

                    JOptionPane.showMessageDialog(
                            this,
                            "Playing: " + media.getTitle()
                    );

                } catch (PlayerException ex) {
                    JOptionPane.showMessageDialog(
                            this,
                            ex.getMessage(),
                            "Player Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            });

            container.add(btnPlay);
        }

        this.add(title);
        this.add(cost);
        this.add(container);
    }

    public Media getMedia() {
        return media;
    }
}