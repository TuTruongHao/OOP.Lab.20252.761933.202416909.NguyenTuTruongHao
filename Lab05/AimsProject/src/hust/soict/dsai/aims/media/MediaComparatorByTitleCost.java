package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

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

        String title1 = media1.getTitle();
        String title2 = media2.getTitle();

        if (title1 == null && title2 == null) {
            return Float.compare(media2.getCost(), media1.getCost());
        }

        if (title1 == null) {
            return 1;
        }

        if (title2 == null) {
            return -1;
        }

        int titleCompare = title1.compareToIgnoreCase(title2);

        if (titleCompare != 0) {
            return titleCompare;
        }

        // Neu title giong nhau, media co cost cao hon dung truoc
        return Float.compare(media2.getCost(), media1.getCost());
    }
}