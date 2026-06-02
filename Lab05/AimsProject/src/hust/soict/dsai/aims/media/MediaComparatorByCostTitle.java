package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

    @Override
    public int compare(Media media1, Media media2) {

        if (media1 == null && media2 == null) {
            return 0;
        }

        if (media1 == null) {
            return 1;
        }

        if (media2 == null) {
            return -1;
        }

        // Cost cao hon dung truoc
        int costCompare = Float.compare(media2.getCost(), media1.getCost());

        if (costCompare != 0) {
            return costCompare;
        }

        // Neu cost bang nhau thi sort theo title tang dan
        String title1 = media1.getTitle();
        String title2 = media2.getTitle();

        if (title1 == null && title2 == null) {
            return 0;
        }

        if (title1 == null) {
            return 1;
        }

        if (title2 == null) {
            return -1;
        }

        return title1.compareToIgnoreCase(title2);
    }
}