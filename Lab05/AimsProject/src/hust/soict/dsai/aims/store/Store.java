package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Store {

    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public Store() {
    }

    public List<Media> getItemsInStore() {
        return Collections.unmodifiableList(itemsInStore);
    }

    public void addMedia(Media media) {
        if (media == null) {
            System.out.println("The media is null.");
            return;
        }

        if (itemsInStore.contains(media)) {
            System.out.println("The media already exists in the store.");
            return;
        }

        itemsInStore.add(media);
        System.out.println("The media has been added to the store.");
    }

    public void removeMedia(Media media) {
        if (media == null) {
            System.out.println("The media is null.");
            return;
        }

        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media has been removed from the store.");
        } else {
            System.out.println("The media does not exist in the store.");
        }
    }

    public Media searchMediaByTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Search title cannot be empty.");
            return null;
        }

        String keyword = title.trim().toLowerCase();

        for (Media media : itemsInStore) {
            if (media.getTitle() != null
                    && media.getTitle().toLowerCase().equals(keyword)) {
                return media;
            }
        }

        System.out.println("No media found with title: " + title);
        return null;
    }

    public ArrayList<Media> searchMediaByKeyword(String keyword) {
        ArrayList<Media> results = new ArrayList<Media>();

        if (keyword == null || keyword.trim().isEmpty()) {
            System.out.println("Search keyword cannot be empty.");
            return results;
        }

        String searchKeyword = keyword.trim().toLowerCase();

        for (Media media : itemsInStore) {
            if (media.getTitle() != null
                    && media.getTitle().toLowerCase().contains(searchKeyword)) {
                results.add(media);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No media found with keyword: " + keyword);
        }

        return results;
    }

    public void printStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in store:");

        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }

        System.out.println("***************************************************");
    }
}