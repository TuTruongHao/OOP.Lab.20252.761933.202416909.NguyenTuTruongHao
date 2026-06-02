import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {

        int option = JOptionPane.showConfirmDialog(
                null,
                "Do you want to change to the first class ticket?"
        );

        String result;

        if (option == JOptionPane.YES_OPTION) {
            result = "You've chosen: Yes";
        } else if (option == JOptionPane.NO_OPTION) {
            result = "You've chosen: No";
        } else {
            result = "You've chosen: Cancel";
        }

        JOptionPane.showMessageDialog(null, result);

        System.exit(0);
    }
}