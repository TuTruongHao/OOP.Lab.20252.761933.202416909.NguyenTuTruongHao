package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	private String content = "";
	
	public Book() {
		super();
	}

	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public List<String> getAuthors() {
		return new ArrayList<String>(authors);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? "" : content;
	}

	public int getContentLength() {
		String trimmedContent = content.trim();
		if (trimmedContent.isEmpty()) {
			return 0;
		}
		return trimmedContent.split("\\s+").length;
	}
	
	public void addAuthor(String authorName) {
        if (authorName != null && !authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Added author: " + authorName);
        } else {
            System.out.println("Author " + authorName + " is already in the list.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Removed author: " + authorName);
        } else {
            System.out.println("Author " + authorName + " not found in the list.");
        }
    }

    @Override
    public String toString() {
        return getId() + ". Book - " + getTitle() + " - " + getCategory()
                + " - Authors: " + authors + " - Content length: " + getContentLength()
                + ": " + getCost() + " $";
    }
}
