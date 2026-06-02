package AimsProject;

public class Aims {
    public static void main(String[] args) {
        // Create a new cart
        Cart anOrder = new Cart();

        // Create new DVD objects
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
                "Aladin",
                "Animation",
                18.99f
        );

        // Add DVDs to the cart
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        // Print total cost
        System.out.println("Total cost is: " + anOrder.totalCost());

        // Test remove
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("Total cost after removing one disc: " + anOrder.totalCost());
    }
}

