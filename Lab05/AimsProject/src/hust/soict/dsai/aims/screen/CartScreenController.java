package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

    private Cart cart;
    private FilteredList<Media> filteredItems;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label lblTotalCost;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    public void initialize() {

        // Gan du lieu cho cac cot cua TableView
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        // Dung FilteredList de vua hien thi vua loc du lieu
        filteredItems = new FilteredList<Media>(cart.getItemsOrdered(), media -> true);
        tblMedia.setItems(filteredItems);

        // Ban dau chua chon media nao nen an nut
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        updateTotalCost();

        // Khi chon media trong bang thi cap nhat nut Play / Remove
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(
                            ObservableValue<? extends Media> observable,
                            Media oldValue,
                            Media newValue) {

                        updateButtonBar(newValue);
                    }
                });

        // Khi user go filter thi loc lai danh sach
        if (tfFilter != null) {
            tfFilter.textProperty().addListener(
                    new ChangeListener<String>() {
                        @Override
                        public void changed(
                                ObservableValue<? extends String> observable,
                                String oldValue,
                                String newValue) {

                            showFilteredMedia();
                        }
                    });
        }

        // Khi doi radio button thi loc lai danh sach
        if (radioBtnFilterId != null) {
            radioBtnFilterId.setOnAction(e -> showFilteredMedia());
        }

        if (radioBtnFilterTitle != null) {
            radioBtnFilterTitle.setOnAction(e -> showFilteredMedia());
        }

        // Khi cart thay doi thi cap nhat total
        cart.getItemsOrdered().addListener(
                (javafx.collections.ListChangeListener<Media>) change -> updateTotalCost()
        );
    }

    private void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
            return;
        }

        btnRemove.setVisible(true);

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    private void btnRemovePressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        if (selectedMedia == null) {
            showInfoDialog("No media selected", "Please select a media to remove.");
            return;
        }

        cart.removeMedia(selectedMedia);
        tblMedia.getSelectionModel().clearSelection();

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        updateTotalCost();
    }

    @FXML
    private void btnPlayPressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        if (selectedMedia == null) {
            showInfoDialog("No media selected", "Please select a media to play.");
            return;
        }

        if (!(selectedMedia instanceof Playable)) {
            showInfoDialog("Cannot play", "This media is not playable.");
            return;
        }

        try {
            ((Playable) selectedMedia).play();

            showInfoDialog(
                    "Playing media",
                    "Playing: " + selectedMedia.getTitle()
            );

        } catch (PlayerException e) {
            showErrorDialog("Player Error", e.getMessage());
        }
    }

    @FXML
    private void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            showInfoDialog("Empty cart", "Your cart is empty.");
            return;
        }

        cart.clearCart();
        tblMedia.getSelectionModel().clearSelection();

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        updateTotalCost();

        showInfoDialog(
                "Order created",
                "An order has been created successfully."
        );
    }

    private void showFilteredMedia() {
        if (filteredItems == null) {
            return;
        }

        String filterText = "";

        if (tfFilter != null && tfFilter.getText() != null) {
            filterText = tfFilter.getText().trim().toLowerCase();
        }

        final String keyword = filterText;

        filteredItems.setPredicate(media -> {
            if (keyword.isEmpty()) {
                return true;
            }

            if (media == null) {
                return false;
            }

            if (radioBtnFilterId != null && radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(keyword);
            }

            if (radioBtnFilterTitle != null && radioBtnFilterTitle.isSelected()) {
                return media.getTitle() != null
                        && media.getTitle().toLowerCase().contains(keyword);
            }

            return true;
        });
    }

    private void updateTotalCost() {
        if (lblTotalCost != null) {
            lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
        }
    }

    private void showInfoDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showErrorDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}