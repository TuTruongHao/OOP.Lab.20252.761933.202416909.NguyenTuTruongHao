package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_ITEMS_IN_STORE = 100;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();

	// ============ ADD ============

	public void addMedia(Media media) {
		if (itemsInStore.size() >= MAX_ITEMS_IN_STORE) {
			System.out.println("The store is full");
			return;
		}

		if (!itemsInStore.contains(media)) {
			itemsInStore.add(media);
			System.out.println("The media has been added to store: " + media.getTitle());
		} else {
			System.out.println("The media is already in store: " + media.getTitle());
		}
	}

	// ============ REMOVE ============

	public void removeMedia(Media media) {
		if (itemsInStore.remove(media)) {
			System.out.println("The media has been removed from store: " + media.getTitle());
		} else {
			System.out.println("The media is not in store: " + media.getTitle());
		}
	}

	public void addDVD(DigitalVideoDisc dvd) {
		addMedia(dvd);
	}

	public void removeDVD(DigitalVideoDisc dvd) {
		removeMedia(dvd);
	}

	public Media searchMediaByTitle(String title) {
		for (Media media : itemsInStore) {
			if (media.getTitle() != null && media.getTitle().equalsIgnoreCase(title)) {
				return media;
			}
		}
		return null;
	}

	public void print() {
		System.out.println("***********************STORE***********************");
		System.out.println("Items in store:");
		if (itemsInStore.isEmpty()) {
			System.out.println("The store is empty.");
		}
		for (Media media : itemsInStore) {
			System.out.println(media.toString());
		}
		System.out.println("***************************************************");
	}

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
}
