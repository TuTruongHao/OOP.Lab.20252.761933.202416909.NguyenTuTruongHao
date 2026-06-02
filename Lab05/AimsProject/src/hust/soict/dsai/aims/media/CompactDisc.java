package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
        super();
    }

    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, String artist, String director, float cost) {
        super(title, category, director, 0, cost);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, String artist, String director, float cost) {
        super(id, title, category, director, 0, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void addTrack(Track track) {
        if (track == null) {
            System.out.println("The track is null.");
            return;
        }

        if (tracks.contains(track)) {
            System.out.println("The track already exists in this CD.");
        } else {
            tracks.add(track);
            System.out.println("The track has been added.");
        }
    }

    public void removeTrack(Track track) {
        if (track == null) {
            System.out.println("The track is null.");
            return;
        }

        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("The track has been removed.");
        } else {
            System.out.println("The track does not exist in this CD.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;

        for (Track track : tracks) {
            totalLength += track.getLength();
        }

        return totalLength;
    }

    @Override
    public void play() throws PlayerException {
        if (getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }

        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD length: " + getLength());
        System.out.println("Artist: " + artist);

        for (Track track : tracks) {
            try {
                track.play();
            } catch (PlayerException e) {
                throw e;
            }
        }
    }

    @Override
    public String toString() {
        return "CD - "
                + getTitle()
                + " - " + getCategory()
                + " - " + artist
                + " - " + getDirector()
                + " - " + getLength()
                + ": " + getCost() + " $";
    }
}