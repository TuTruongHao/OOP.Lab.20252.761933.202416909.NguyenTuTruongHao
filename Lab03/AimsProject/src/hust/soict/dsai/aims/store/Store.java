package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_ITEMS_IN_STORE = 100;
	private DigitalVideoDisc[] itemsInStore = 
			new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
	private int qtyInStore = 0;

	// ============ ADD ============

	public void addDVD(DigitalVideoDisc dvd) {
		if (qtyInStore < MAX_ITEMS_IN_STORE) {
			itemsInStore[qtyInStore] = dvd;
			qtyInStore++;
			System.out.println("The DVD has been added to store");
		} else {
			System.out.println("The store is full");
		}
	}

	// ============ REMOVE ============

	public void removeDVD(DigitalVideoDisc dvd) {
		boolean found = false;

		for (int i = 0; i < qtyInStore; i++) {
			if (itemsInStore[i] == dvd) {
				found = true;

				for (int j = i; j < qtyInStore - 1; j++) {
					itemsInStore[j] = itemsInStore[j + 1];
				}

				itemsInStore[qtyInStore - 1] = null;
				qtyInStore--;

				System.out.println("The DVD has been removed from store");
				break;
			}
		}

		if (!found) {
			System.out.println("The DVD is not in store");
		}
	}
}package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_ITEMS_IN_STORE = 100;
	private DigitalVideoDisc[] itemsInStore = 
			new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
	private int qtyInStore = 0;

	// ============ ADD ============

	public void addDVD(DigitalVideoDisc dvd) {
		if (qtyInStore < MAX_ITEMS_IN_STORE) {
			itemsInStore[qtyInStore] = dvd;
			qtyInStore++;
			System.out.println("The DVD has been added to store");
		} else {
			System.out.println("The store is full");
		}
	}

	// ============ REMOVE ============

	public void removeDVD(DigitalVideoDisc dvd) {
		boolean found = false;

		for (int i = 0; i < qtyInStore; i++) {
			if (itemsInStore[i] == dvd) {
				found = true;

				for (int j = i; j < qtyInStore - 1; j++) {
					itemsInStore[j] = itemsInStore[j + 1];
				}

				itemsInStore[qtyInStore - 1] = null;
				qtyInStore--;

				System.out.println("The DVD has been removed from store");
				break;
			}
		}

		if (!found) {
			System.out.println("The DVD is not in store");
		}
	}
}