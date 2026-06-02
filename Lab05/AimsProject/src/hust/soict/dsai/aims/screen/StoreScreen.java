package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {

    private Store store;
    private Cart cart;

    private JPanel centerPanel;

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("AIMS Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        north.add(createMenuBar());
        north.add(createHeader());

        return north;
    }

    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuOptions = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> refreshStore());

        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(e -> {
            new CartScreen(cart);
        });

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

    public JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        header.add(title, BorderLayout.CENTER);

        return header;
    }

    public JScrollPane createCenter() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 3, 2, 2));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (Media media : store.getItemsInStore()) {
            MediaStore mediaStore = new MediaStore(media, cart);
            centerPanel.add(mediaStore);
        }

        JScrollPane scrollPane = new JScrollPane(centerPanel);
        scrollPane.setPreferredSize(new Dimension(1024, 600));

        return scrollPane;
    }

    public void refreshStore() {
        centerPanel.removeAll();

        for (Media media : store.getItemsInStore()) {
            MediaStore mediaStore = new MediaStore(media, cart);
            centerPanel.add(mediaStore);
        }

        centerPanel.revalidate();
        centerPanel.repaint();
    }
}