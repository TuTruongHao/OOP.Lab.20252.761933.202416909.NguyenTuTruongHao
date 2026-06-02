package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book extends Media {

    private ArrayList<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) {
            System.out.println("Author name cannot be empty.");
            return;
        }

        if (authors.contains(authorName)) {
            System.out.println("The author already exists.");
        } else {
            authors.add(authorName);
            System.out.println("The author has been added.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) {
            System.out.println("Author name cannot be empty.");
            return;
        }

        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("The author has been removed.");
        } else {
            System.out.println("The author does not exist.");
        }
    }

    public List<String> getAuthors() {
        return Collections.unmodifiableList(authors);
    }

    @Override
    public String toString() {
        return "Book - "
                + getTitle()
                + " - " + getCategory()
                + " - " + authors
                + ": " + getCost() + " $";
    }
}