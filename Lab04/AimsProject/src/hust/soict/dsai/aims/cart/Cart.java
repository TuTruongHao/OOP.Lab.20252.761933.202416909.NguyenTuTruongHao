package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
    // Recreate itemsOrdered field as an object ArrayList
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // qtyOrdered field is no longer needed since we use ArrayList 
    // private int qtyOrdered = 0; 

    // Create addMedia() to replace addDigitalVideoDisc()
    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media has been added: " + media.getTitle());
        } else {
            System.out.println("The media is already in the cart.");
        }
    }

    // Create removeMedia() to replace removeDigitalVideoDisc()
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed: " + media.getTitle());
        } else {
            System.out.println("The media was not found in the cart.");
        }
    }

    public void addDigitalVideoDisc(Media media) {
        addMedia(media);
    }

    public void removeDigitalVideoDisc(Media media) {
        removeMedia(media);
    }

    // Update the totalCost() method to work with ArrayList
    public float totalCost() {
        float sum = 0;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }

    // Update print method to iterate through ArrayList
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        }
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
        System.out.println("Total Cost: " + totalCost());
        System.out.println("***************************************************");
    }
    
    // Update search methods to work with Media type
    public void searchByID(int targetID) {
        for (Media media : itemsOrdered) {
            if (media.getId() == targetID) {
                System.out.println("Media Found:");
                System.out.println(media.toString());
                return;
            }
        }
        System.out.println("No media with ID " + targetID + " found!");
    }
    
    public void searchByTitle(String targetTitle) {
        for (Media media : itemsOrdered) {
            // Lưu ý: isMatch cần được định nghĩa trong class Media hoặc dùng equals/contains
            if (media.getTitle().equalsIgnoreCase(targetTitle)) {
                System.out.println("Media Found:");
                System.out.println(media.toString());
                return;
            }
        }
        System.out.println("No media with title \"" + targetTitle + "\" found!");
    }

    public Media searchMediaByTitle(String targetTitle) {
        for (Media media : itemsOrdered) {
            if (media.getTitle() != null && media.getTitle().equalsIgnoreCase(targetTitle)) {
                return media;
            }
        }
        return null;
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void emptyCart() {
        itemsOrdered.clear();
    }

    public int getNumberOfItems() {
        return itemsOrdered.size();
    }

    public int getNumberOfDVDs() {
        int count = 0;
        for (Media media : itemsOrdered) {
            if (media instanceof DigitalVideoDisc) {
                count++;
            }
        }
        return count;
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}
