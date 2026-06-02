package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;

	public DigitalVideoDisc(String title) {
		this(++nbDigitalVideoDiscs, title, null, 0, null, 0);
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		this(++nbDigitalVideoDiscs, title, category, cost, null, 0);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this(++nbDigitalVideoDiscs, title, category, cost, director, length);
	}

	public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
		super(id, title, category, cost, director, length);
		if (id > nbDigitalVideoDiscs) {
			nbDigitalVideoDiscs = id;
		}
	}

	public int getid() {
		return getId();
	}
	
	@Override
	public String toString() {
		return getId() + ". DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector()
				+ " - " + getLength() + ": " + getCost() + " $";
	}
	
	public boolean isMatch(String title) {
		return getTitle() != null && getTitle().equals(title);
	}

	@Override
	public void play() {
		if (getLength() <= 0) {
			System.out.println("Cannot play DVD: " + getTitle());
			System.out.println("DVD length is non-positive.");
			return;
		}
		System.out.println("Playing DVD: " + getTitle());
		System.out.println("DVD length: " + getLength());
	}
	
}
