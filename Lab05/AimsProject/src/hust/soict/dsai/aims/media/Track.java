package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {

    private String title;
    private int length;

    public Track() {
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if (length > 0) {
            System.out.println("Playing track: " + title);
            System.out.println("Track length: " + length);
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Track)) {
            return false;
        }

        Track other = (Track) obj;

        if (this.title == null) {
            return other.title == null && this.length == other.length;
        }

        return this.title.equalsIgnoreCase(other.title)
                && this.length == other.length;
    }

    @Override
    public int hashCode() {
        int result = 17;

        if (title != null) {
            result = 31 * result + title.toLowerCase().hashCode();
        }

        result = 31 * result + length;

        return result;
    }

    @Override
    public String toString() {
        return "Track - "
                + title
                + " - " + length;
    }
}