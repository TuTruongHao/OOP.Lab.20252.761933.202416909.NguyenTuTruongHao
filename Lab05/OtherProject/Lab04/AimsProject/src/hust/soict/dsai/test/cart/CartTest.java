package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.cart.Cart;

public class CartTest {

	public static void main(String[] args) {
		// Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King",
            "Animation", 19.95f, "Roger Allers", 87);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars",
            "Science Fiction", 24.95f, "George Lucas", 87);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin",
            "Animation", 18.99f, null, 0);
        cart.addMedia(dvd3);

        // Test the print method
        cart.print();
        
        // Test the search methods
        cart.searchByID(2);
        cart.searchByTitle("Aladin");
	}

}
