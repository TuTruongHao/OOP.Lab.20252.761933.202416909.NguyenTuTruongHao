package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist) {
		super(id, title, category, cost, director, length);
		this.artist = artist;
	}

	public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
		super(id, title, category, cost, director, 0);
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	public List<Track> getTracks() {
		return new ArrayList<Track>(tracks);
	}
	
	public void addTrack(Track track) {
        if (track == null) {
            System.out.println("Cannot add a null track.");
        } else if (tracks.contains(track)) {
            System.out.println("Track " + track.getTitle() + " is already in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " has been added.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " has been removed.");
        } else {
            System.out.println("Track " + track.getTitle() + " does not exist in the CD.");
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
	public void play() {
		if (getLength() <= 0) {
			System.out.println("Cannot play CD: " + getTitle());
			System.out.println("CD length is non-positive.");
			return;
		}
		System.out.println("Playing CD: " + getTitle());
		System.out.println("CD length: " + getLength());
		for (Track track : tracks) {
			track.play();
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getId()).append(". CD - ").append(getTitle()).append(" - ").append(getCategory())
				.append(" - Artist: ").append(artist).append(" - Director: ").append(getDirector())
				.append(" - Length: ").append(getLength()).append(": ").append(getCost()).append(" $");
		if (tracks.isEmpty()) {
			builder.append(System.lineSeparator()).append("Tracks: []");
		} else {
			builder.append(System.lineSeparator()).append("Tracks:");
			for (Track track : tracks) {
				builder.append(System.lineSeparator()).append("  ").append(track);
			}
		}
		return builder.toString();
	}
}
