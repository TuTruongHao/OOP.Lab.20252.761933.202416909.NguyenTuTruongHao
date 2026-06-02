package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc() {
        super();
        setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title) {
        super(title);
        setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        super(title, category, cost);
        setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(title, category, director, 0, cost);
        setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
        setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, director, length, cost);
        nbDigitalVideoDiscs++;
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    public boolean isMatch(String title) {
        if (title == null || getTitle() == null) {
            return false;
        }

        String[] keywords = title.trim().toLowerCase().split("\\s+");
        String dvdTitle = getTitle().toLowerCase();

        for (String keyword : keywords) {
            if (dvdTitle.contains(keyword)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void play() throws PlayerException {
        if (getLength() > 0) {
            System.out.println("Playing DVD: " + getTitle());
            System.out.println("DVD length: " + getLength());
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    @Override
    public String toString() {
        return "DVD - "
                + getTitle()
                + " - " + getCategory()
                + " - " + getDirector()
                + " - " + getLength()
                + ": " + getCost() + " $";
    }
}