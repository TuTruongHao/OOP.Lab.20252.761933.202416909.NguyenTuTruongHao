package hust.soict.dsai.aims.screen;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        buildScreen();
    }

    @Override
    protected String getScreenTitle() {
        return "Add DVD To Store";
    }

    @Override
    protected JPanel createSpecificInfoPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("DVD information"));

        tfDirector = new JTextField();
        tfLength = new JTextField();

        panel.add(new JLabel("Director:"));
        panel.add(tfDirector);

        panel.add(new JLabel("Length:"));
        panel.add(tfLength);

        return panel;
    }

    @Override
    protected Media createMedia() throws Exception {
        String title = getTitleInput();
        String category = getCategoryInput();
        float cost = getCostInput();

        String director = tfDirector.getText().trim();

        if (director.isEmpty()) {
            throw new IllegalArgumentException("Director cannot be empty.");
        }

        int length = parsePositiveInt(tfLength.getText(), "Length");

        DigitalVideoDisc dvd = new DigitalVideoDisc(
                title,
                category,
                director,
                length,
                cost
        );

        return dvd;
    }

    @Override
    protected void clearSpecificFields() {
        if (tfDirector != null) {
            tfDirector.setText("");
        }

        if (tfLength != null) {
            tfLength.setText("");
        }
    }
}