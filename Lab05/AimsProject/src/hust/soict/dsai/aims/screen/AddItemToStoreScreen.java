package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {

    protected Store store;
    protected Cart cart;

    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    public AddItemToStoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    protected void buildScreen() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createMainPanel(), BorderLayout.CENTER);

        setTitle(getScreenTitle());
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    protected JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        north.add(createMenuBar());
        north.add(createHeader());

        return north;
    }

    protected JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuOptions = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            new StoreScreen(store, cart);
            dispose();
        });

        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(e -> new CartScreen(cart));

        JMenu updateStore = new JMenu("Update store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            new AddBookToStoreScreen(store, cart);
            dispose();
        });

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store, cart);
            dispose();
        });

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store, cart);
            dispose();
        });

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));

        updateStore.add(addBook);
        updateStore.add(addCD);
        updateStore.add(addDVD);

        menuOptions.add(viewStore);
        menuOptions.add(viewCart);
        menuOptions.add(updateStore);
        menuOptions.addSeparator();
        menuOptions.add(exit);

        menuBar.add(menuOptions);

        return menuBar;
    }

    protected JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());

        JLabel title = new JLabel(getScreenTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 36));
        title.setForeground(Color.CYAN);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        header.add(title, BorderLayout.CENTER);

        return header;
    }

    protected JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        mainPanel.add(createBasicInfoPanel(), BorderLayout.NORTH);

        JPanel specificPanel = createSpecificInfoPanel();
        if (specificPanel != null) {
            mainPanel.add(specificPanel, BorderLayout.CENTER);
        }

        mainPanel.add(createButtonPanel(), BorderLayout.SOUTH);

        return mainPanel;
    }

    protected JPanel createBasicInfoPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Basic information"));

        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfCost = new JTextField();

        panel.add(new JLabel("Title:"));
        panel.add(tfTitle);

        panel.add(new JLabel("Category:"));
        panel.add(tfCategory);

        panel.add(new JLabel("Cost:"));
        panel.add(tfCost);

        return panel;
    }

    protected JPanel createButtonPanel() {
        JPanel panel = new JPanel();

        JButton btnAdd = new JButton("Add to store");
        JButton btnReset = new JButton("Reset");
        JButton btnBack = new JButton("Back to store");

        btnAdd.addActionListener(e -> addMediaToStore());

        btnReset.addActionListener(e -> {
            clearBasicFields();
            clearSpecificFields();
        });

        btnBack.addActionListener(e -> {
            new StoreScreen(store, cart);
            dispose();
        });

        panel.add(btnAdd);
        panel.add(btnReset);
        panel.add(btnBack);

        return panel;
    }

    private void addMediaToStore() {
        try {
            Media media = createMedia();

            if (media == null) {
                showErrorMessage("Cannot create media.");
                return;
            }

            if (store.getItemsInStore().contains(media)) {
                showErrorMessage("This media already exists in the store.");
                return;
            }

            store.addMedia(media);

            JOptionPane.showMessageDialog(
                    this,
                    media.getTitle() + " has been added to the store.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

            clearBasicFields();
            clearSpecificFields();

        } catch (NumberFormatException e) {
            showErrorMessage("Cost, length, or ID must be a valid number.");
        } catch (IllegalArgumentException e) {
            showErrorMessage(e.getMessage());
        } catch (Exception e) {
            showErrorMessage("Error: " + e.getMessage());
        }
    }

    protected String getTitleInput() {
        String title = tfTitle.getText().trim();

        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }

        return title;
    }

    protected String getCategoryInput() {
        String category = tfCategory.getText().trim();

        if (category.isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty.");
        }

        return category;
    }

    protected float getCostInput() {
        String costText = tfCost.getText().trim();

        if (costText.isEmpty()) {
            throw new IllegalArgumentException("Cost cannot be empty.");
        }

        float cost = Float.parseFloat(costText);

        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative.");
        }

        return cost;
    }

    protected int parsePositiveInt(String text, String fieldName) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty.");
        }

        int value = Integer.parseInt(text.trim());

        if (value < 0) {
            throw new IllegalArgumentException(fieldName + " cannot be negative.");
        }

        return value;
    }

    protected void clearBasicFields() {
        tfTitle.setText("");
        tfCategory.setText("");
        tfCost.setText("");
    }

    protected void clearSpecificFields() {
        // Subclasses can override this method if needed.
    }

    protected void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(
                this,
                message,
                "Input Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    protected abstract String getScreenTitle();

    protected abstract JPanel createSpecificInfoPanel();

    protected abstract Media createMedia() throws Exception;
}