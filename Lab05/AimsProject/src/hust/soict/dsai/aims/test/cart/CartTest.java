package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;

public class CartTest {

    public static void main(String[] args) {

        // Tao cart
        Cart cart = new Cart();

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
        System.out.println("\n===== TEST ADD MEDIA =====");
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(book1);
        cart.addMedia(book2);
        cart.addMedia(cd1);

        // Test add duplicate
        cart.addMedia(dvd1);

        // Test print cart
        System.out.println("\n===== TEST PRINT CART =====");
        cart.print();

        // Test totalCost
        System.out.println("\n===== TEST TOTAL COST =====");
        System.out.println("Total cost: " + cart.totalCost() + " $");

        // Test search by ID
        System.out.println("\n===== TEST SEARCH BY ID =====");
        cart.searchById(dvd1.getId());
        cart.searchById(999);

        // Test search by title
        System.out.println("\n===== TEST SEARCH BY TITLE =====");
        cart.searchByTitle("Lion");
        cart.searchByTitle("Java");

        // Test sort by title then cost
        System.out.println("\n===== TEST SORT BY TITLE COST =====");
        cart.sortByTitleCost();
        cart.print();

        // Test sort by cost then title
        System.out.println("\n===== TEST SORT BY COST TITLE =====");
        cart.sortByCostTitle();
        cart.print();

        // Test play media
        System.out.println("\n===== TEST PLAY MEDIA =====");
        playMedia(dvd1);
        playMedia(cd1);
        playMedia(book1);

        // Test removeMedia
        System.out.println("\n===== TEST REMOVE MEDIA =====");
        cart.removeMedia(dvd2);
        cart.removeMedia(dvd2);
        cart.print();

        // Test clearCart
        System.out.println("\n===== TEST CLEAR CART =====");
        cart.clearCart();
        cart.print();
    }

    private static void playMedia(Media media) {
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println(media.getTitle() + " is not playable.");
        }
    }
}