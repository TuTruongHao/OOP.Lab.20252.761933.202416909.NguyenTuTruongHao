package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfArtist;
    private JTextField tfDirector;
    private JTextArea taTracks;

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        buildScreen();
    }

    @Override
    protected String getScreenTitle() {
        return "Add CD To Store";
    }

    @Override
    protected JPanel createSpecificInfoPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("CD information"));

        JPanel topPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        tfArtist = new JTextField();
        tfDirector = new JTextField();

        topPanel.add(new JLabel("Artist:"));
        topPanel.add(tfArtist);

        topPanel.add(new JLabel("Director:"));
        topPanel.add(tfDirector);

        JPanel trackPanel = new JPanel(new BorderLayout(5, 5));

        JLabel trackGuide = new JLabel("Tracks: enter each track as Title:length, one track per line");
        taTracks = new JTextArea(6, 30);

        JScrollPane scrollPane = new JScrollPane(taTracks);

        trackPanel.add(trackGuide, BorderLayout.NORTH);
        trackPanel.add(scrollPane, BorderLayout.CENTER);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(trackPanel, BorderLayout.CENTER);

        return panel;
    }

    @Override
    protected Media createMedia() throws Exception {
        String title = getTitleInput();
        String category = getCategoryInput();
        float cost = getCostInput();

        String artist = tfArtist.getText().trim();
        String director = tfDirector.getText().trim();

        if (artist.isEmpty()) {
            throw new IllegalArgumentException("Artist cannot be empty.");
        }

        if (director.isEmpty()) {
            throw new IllegalArgumentException("Director cannot be empty.");
        }

        CompactDisc cd = new CompactDisc(
                title,
                category,
                artist,
                director,
                cost
        );

        addTracksToCd(cd);

        return cd;
    }

    private void addTracksToCd(CompactDisc cd) {
        String tracksText = taTracks.getText().trim();

        if (tracksText.isEmpty()) {
            return;
        }

        String[] lines = tracksText.split("\\n");

        for (String line : lines) {
            String trackInfo = line.trim();

            if (trackInfo.isEmpty()) {
                continue;
            }

            String[] parts = trackInfo.split(":");

            if (parts.length != 2) {
                throw new IllegalArgumentException(
                        "Invalid track format: " + trackInfo
                        + ". Correct format is Title:length"
                );
            }

            String trackTitle = parts[0].trim();
            String lengthText = parts[1].trim();

            if (trackTitle.isEmpty()) {
                throw new IllegalArgumentException("Track title cannot be empty.");
            }

            int trackLength = Integer.parseInt(lengthText);

            if (trackLength < 0) {
                throw new IllegalArgumentException("Track length cannot be negative.");
            }

            Track track = new Track(trackTitle, trackLength);
            cd.addTrack(track);
        }
    }

    @Override
    protected void clearSpecificFields() {
        if (tfArtist != null) {
            tfArtist.setText("");
        }

        if (tfDirector != null) {
            tfDirector.setText("");
        }

        if (taTracks != null) {
            taTracks.setText("");
        }
    }
}