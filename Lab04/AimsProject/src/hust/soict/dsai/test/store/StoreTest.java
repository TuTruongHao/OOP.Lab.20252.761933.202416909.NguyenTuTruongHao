package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// Create a new store
		Store store = new Store();
	
		// Add DVDs to the store
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King",
			 "Animation", 19.95f, "Roger Allers", 87);
		store.addMedia(dvd1);
	
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars",
			 "Science Fiction", 24.95f, "George Lucas", 87);
		store.addMedia(dvd2);
	
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin",
			 "Animation", 18.99f, null, 0);
		store.addMedia(dvd3);
		
		// Remove DVDs from the store
		store.removeMedia(dvd1);
		store.removeMedia(dvd2);
		store.removeMedia(dvd3);
		store.removeMedia(dvd3);
	}

}
