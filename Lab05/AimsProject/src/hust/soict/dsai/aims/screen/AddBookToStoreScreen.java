package hust.soict.dsai.aims.screen;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        buildScreen();
    }

    @Override
    protected String getScreenTitle() {
        return "Add Book To Store";
    }

    @Override
    protected JPanel createSpecificInfoPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Book information"));

        tfAuthors = new JTextField();

        panel.add(new JLabel("Authors:"));
        panel.add(tfAuthors);

        return panel;
    }

    @Override
    protected Media createMedia() throws Exception {
        String title = getTitleInput();
        String category = getCategoryInput();
        float cost = getCostInput();

        Book book = new Book(title, category, cost);

        String authorsText = tfAuthors.getText().trim();

        if (!authorsText.isEmpty()) {
            String[] authors = authorsText.split(",");

            for (String author : authors) {
                String authorName = author.trim();

                if (!authorName.isEmpty()) {
                    book.addAuthor(authorName);
                }
            }
        }

        return book;
    }

    @Override
    protected void clearSpecificFields() {
        if (tfAuthors != null) {
            tfAuthors.setText("");
        }
    }
}