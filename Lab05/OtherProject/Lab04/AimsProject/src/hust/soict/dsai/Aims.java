package hust.soict.dsai;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	private static final Scanner scanner = new Scanner(System.in);
	private static final Store store = new Store();
	private static final Cart cart = new Cart();
	private static int nextId = 100;

	public static void main(String[] args) {
		initStore();

		int choice;
		do {
			showMenu();
			choice = readInt();
			switch (choice) {
			case 1:
				viewStore();
				break;
			case 2:
				updateStore();
				break;
			case 3:
				viewCart();
				break;
			case 0:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} while (choice != 0);
	}

	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void mediaDetailsMenu(boolean playable) {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		if (playable) {
			System.out.println("2. Play");
		}
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println(playable ? "Please choose a number: 0-1-2" : "Please choose a number: 0-1");
	}

	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

	private static void initStore() {
		store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87));
		store.addMedia(new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 87));
		store.addMedia(new DigitalVideoDisc(3, "Aladin", "Animation", 18.99f, "John Musker", 90));

		Book book = new Book(4, "Effective Java", "Programming", 45.50f);
		book.addAuthor("Joshua Bloch");
		book.setContent("Best practices for Java programming and object oriented design.");
		store.addMedia(book);

		CompactDisc cd = new CompactDisc(5, "Greatest Hits", "Music", 14.95f, "Various", "Queen");
		cd.addTrack(new Track("Bohemian Rhapsody", 6));
		cd.addTrack(new Track("Don't Stop Me Now", 4));
		store.addMedia(cd);
	}

	private static void viewStore() {
		int choice;
		do {
			store.print();
			storeMenu();
			choice = readInt();
			switch (choice) {
			case 1:
				showMediaDetails();
				break;
			case 2:
				addMediaToCart();
				break;
			case 3:
				playMediaFromStore();
				break;
			case 4:
				viewCart();
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} while (choice != 0);
	}

	private static void showMediaDetails() {
		Media media = askMediaFromStore();
		if (media == null) {
			return;
		}

		System.out.println(media);
		boolean playable = media instanceof Playable;
		int choice;
		do {
			mediaDetailsMenu(playable);
			choice = readInt();
			switch (choice) {
			case 1:
				cart.addMedia(media);
				printCartCountAfterAdding(media);
				break;
			case 2:
				if (playable) {
					((Playable) media).play();
				} else {
					System.out.println("This media cannot be played.");
				}
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} while (choice != 0);
	}

	private static void addMediaToCart() {
		Media media = askMediaFromStore();
		if (media != null) {
			cart.addMedia(media);
			printCartCountAfterAdding(media);
		}
	}

	private static void playMediaFromStore() {
		Media media = askMediaFromStore();
		playMedia(media);
	}

	private static void updateStore() {
		System.out.println("1. Add media");
		System.out.println("2. Remove media");
		System.out.println("0. Back");
		int choice = readInt();
		switch (choice) {
		case 1:
			store.addMedia(createMediaFromInput());
			break;
		case 2:
			Media media = askMediaFromStore();
			if (media != null) {
				store.removeMedia(media);
			}
			break;
		case 0:
			break;
		default:
			System.out.println("Invalid choice.");
		}
	}

	private static Media createMediaFromInput() {
		System.out.println("Choose media type: 1. Book  2. DVD  3. CD");
		int type = readInt();
		System.out.println("Title:");
		String title = scanner.nextLine();
		System.out.println("Category:");
		String category = scanner.nextLine();
		System.out.println("Cost:");
		float cost = readFloat();

		switch (type) {
		case 1:
			Book book = new Book(nextId++, title, category, cost);
			System.out.println("Author:");
			book.addAuthor(scanner.nextLine());
			System.out.println("Content:");
			book.setContent(scanner.nextLine());
			return book;
		case 2:
			System.out.println("Director:");
			String dvdDirector = scanner.nextLine();
			System.out.println("Length:");
			int dvdLength = readInt();
			return new DigitalVideoDisc(nextId++, title, category, cost, dvdDirector, dvdLength);
		case 3:
			System.out.println("Director:");
			String cdDirector = scanner.nextLine();
			System.out.println("Artist:");
			String artist = scanner.nextLine();
			CompactDisc cd = new CompactDisc(nextId++, title, category, cost, cdDirector, artist);
			System.out.println("Number of tracks:");
			int trackCount = readInt();
			for (int i = 0; i < trackCount; i++) {
				System.out.println("Track title:");
				String trackTitle = scanner.nextLine();
				System.out.println("Track length:");
				int trackLength = readInt();
				cd.addTrack(new Track(trackTitle, trackLength));
			}
			return cd;
		default:
			System.out.println("Invalid media type. A default book is created.");
			return new Book(nextId++, title, category, cost);
		}
	}

	private static void viewCart() {
		int choice;
		do {
			cart.print();
			cartMenu();
			choice = readInt();
			switch (choice) {
			case 1:
				filterCart();
				break;
			case 2:
				sortCart();
				break;
			case 3:
				removeMediaFromCart();
				break;
			case 4:
				playMediaFromCart();
				break;
			case 5:
				cart.emptyCart();
				System.out.println("An order is created.");
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} while (choice != 0);
	}

	private static void filterCart() {
		System.out.println("1. Filter by id");
		System.out.println("2. Filter by title");
		int choice = readInt();
		if (choice == 1) {
			System.out.println("Enter id:");
			cart.searchByID(readInt());
		} else if (choice == 2) {
			System.out.println("Enter title:");
			cart.searchByTitle(scanner.nextLine());
		} else {
			System.out.println("Invalid choice.");
		}
	}

	private static void sortCart() {
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		int choice = readInt();
		if (choice == 1) {
			cart.sortByTitleCost();
			cart.print();
		} else if (choice == 2) {
			cart.sortByCostTitle();
			cart.print();
		} else {
			System.out.println("Invalid choice.");
		}
	}

	private static void removeMediaFromCart() {
		System.out.println("Enter title:");
		Media media = cart.searchMediaByTitle(scanner.nextLine());
		if (media != null) {
			cart.removeMedia(media);
		} else {
			System.out.println("The media was not found in the cart.");
		}
	}

	private static void playMediaFromCart() {
		System.out.println("Enter title:");
		Media media = cart.searchMediaByTitle(scanner.nextLine());
		playMedia(media);
	}

	private static Media askMediaFromStore() {
		System.out.println("Enter title:");
		Media media = store.searchMediaByTitle(scanner.nextLine());
		if (media == null) {
			System.out.println("The media was not found in the store.");
		}
		return media;
	}

	private static void playMedia(Media media) {
		if (media == null) {
			return;
		}
		if (media instanceof Playable) {
			((Playable) media).play();
		} else {
			System.out.println("This media cannot be played.");
		}
	}

	private static void printCartCountAfterAdding(Media media) {
		if (media instanceof DigitalVideoDisc) {
			System.out.println("Number of DVDs in current cart: " + cart.getNumberOfDVDs());
		} else {
			System.out.println("Current cart size: " + cart.getNumberOfItems());
		}
	}

	private static int readInt() {
		while (!scanner.hasNextInt()) {
			System.out.println("Please enter a valid integer:");
			scanner.nextLine();
		}
		int value = scanner.nextInt();
		scanner.nextLine();
		return value;
	}

	private static float readFloat() {
		while (!scanner.hasNextFloat()) {
			System.out.println("Please enter a valid number:");
			scanner.nextLine();
		}
		float value = scanner.nextFloat();
		scanner.nextLine();
		return value;
	}
}
