package hust.soict.dsai.test.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class MediaTest {
	public static void main(String[] args) {
		ArrayList<Media> mediae = new ArrayList<Media>();

		DigitalVideoDisc dvd = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);

		Book book = new Book(2, "Effective Java", "Programming", 45.50f);
		book.addAuthor("Joshua Bloch");

		CompactDisc cd = new CompactDisc(3, "Greatest Hits", "Music", 14.95f, "Various", "Queen");
		cd.addTrack(new Track("Bohemian Rhapsody", 6));
		cd.addTrack(new Track("Don't Stop Me Now", 4));

		mediae.add(dvd);
		mediae.add(book);
		mediae.add(cd);

		for (Media media : mediae) {
			System.out.println(media.toString());
		}
	}
}
