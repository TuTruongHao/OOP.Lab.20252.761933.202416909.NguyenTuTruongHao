package hust.soict.dsai.test.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

    public static void main(String[] args) {

        // Tao store
        Store store = new Store();

        // Tao DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f
        );

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars",
                "Science Fiction",
                "George Lucas",
                87,
                24.95f
        );

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Aladdin",
                "Animation",
                "John Musker",
                90,
                18.99f
        );

        // Tao Book
        Book book1 = new Book(
                "Clean Code",
                "Programming",
                35.75f
        );
        book1.addAuthor("Robert C. Martin");

        Book book2 = new Book(
                "The Alchemist",
                "Novel",
                12.50f
        );
        book2.addAuthor("Paulo Coelho");

        // Tao CD
        CompactDisc cd1 = new CompactDisc(
                "25",
                "Pop",
                "Adele",
                "Adele",
                21.99f
        );

        cd1.addTrack(new Track("Hello", 295));
        cd1.addTrack(new Track("Send My Love", 223));
        cd1.addTrack(new Track("When We Were Young", 290));

        // Test addMedia
        System.out.println("\n===== TEST ADD MEDIA TO STORE =====");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(cd1);

        // Test add duplicate media
        System.out.println("\n===== TEST ADD DUPLICATE MEDIA =====");
        store.addMedia(dvd1);

        // Test printStore
        System.out.println("\n===== TEST PRINT STORE =====");
        store.printStore();

        // Test search by exact title
        System.out.println("\n===== TEST SEARCH MEDIA BY TITLE =====");
        Media foundMedia = store.searchMediaByTitle("The Lion King");

        if (foundMedia != null) {
            System.out.println("Found media:");
            System.out.println(foundMedia);
        }

        Media notFoundMedia = store.searchMediaByTitle("Unknown Media");

        if (notFoundMedia == null) {
            System.out.println("Unknown Media was not found.");
        }

        // Test search by keyword
        System.out.println("\n===== TEST SEARCH MEDIA BY KEYWORD =====");
        ArrayList<Media> searchResults = store.searchMediaByKeyword("the");

        if (!searchResults.isEmpty()) {
            System.out.println("Search results:");
            for (Media media : searchResults) {
                System.out.println(media);
            }
        }

        // Test removeMedia
        System.out.println("\n===== TEST REMOVE MEDIA FROM STORE =====");
        store.removeMedia(dvd2);

        // Test remove media that is no longer in store
        store.removeMedia(dvd2);

        // Print store after removing
        System.out.println("\n===== STORE AFTER REMOVE =====");
        store.printStore();
    }
}