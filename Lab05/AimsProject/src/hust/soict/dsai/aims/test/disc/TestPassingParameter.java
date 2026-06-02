package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[] args) {

        // Tao 2 DVD
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        System.out.println("Before swap:");
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
        System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());

        // Thu swap binh thuong
        swap(jungleDVD, cinderellaDVD);

        System.out.println("\nAfter swap:");
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
        System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());

        // Thu changeTitle
        changeTitle(jungleDVD, cinderellaDVD.getTitle());

        System.out.println("\nAfter changeTitle:");
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
        System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());

        // Cach swap dung: tra ve mang va gan lai bien
        DigitalVideoDisc[] swappedList = correctSwap(jungleDVD, cinderellaDVD);
        jungleDVD = swappedList[0];
        cinderellaDVD = swappedList[1];

        System.out.println("\nAfter correctSwap:");
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
        System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());
    }

    public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
        DigitalVideoDisc tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);

        dvd = new DigitalVideoDisc(oldTitle);
    }

    public static DigitalVideoDisc[] correctSwap(
            DigitalVideoDisc dvd1,
            DigitalVideoDisc dvd2) {

        DigitalVideoDisc[] result = new DigitalVideoDisc[2];

        result[0] = dvd2;
        result[1] = dvd1;

        return result;
    }
}