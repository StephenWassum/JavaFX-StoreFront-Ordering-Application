package com.example.project4;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.example.project4.model.Order;
import com.example.project4.model.Pizza;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

/** The Class StoreOrderController is the controller for viewing all orders.
 * 
 * @author Stephen Wassum */
public class StoreOrderController extends Controller {

    /** The Constant ORDERS_FILE. */
    public static final String ORDERS_FILE= "orders.txt";

    /** The Order price input. */
    @FXML
    private TextField OrderPriceInput;

    /** The Pizza order list. */
    @FXML
    private ListView<Pizza> PizzaOrderList;

    /** The Order number combo button. */
    @FXML
    private ComboBox<Order> OrderNumberComboButton;

    /** The Remove order. */
    @FXML
    private Button RemoveOrder;

    /** The Export order. */
    @FXML
    private Button ExportOrder;

    /** Initialize. */
    public void initialize() {

        OrderNumberComboButton.getItems().addAll(getModel().getOrders());

        OrderNumberComboButton.getSelectionModel().selectedItemProperty()
            .addListener(new ChangeListener<Order>() {
                @Override
                public void changed(ObservableValue<? extends Order> selected, Order oldNumber,
                    Order newNumber) {

                    PizzaOrderList.getItems().clear();

                    if (newNumber == null) {
                        OrderPriceInput.setText("");

                    } else {
                        OrderPriceInput.setText(String.format("%.2f", newNumber.totalPrice()));
                        PizzaOrderList.getItems().addAll(newNumber.getPizzas());
                    }

                }
            });

    }

    /** On remove order pressed.
     *
     * @param event the event */
    @FXML
    void OnRemoveOrderPressed(ActionEvent event) {
        if (OrderNumberComboButton.getSelectionModel().getSelectedItem() != null) {
            getModel().cancelOrder(OrderNumberComboButton.getSelectionModel().getSelectedItem());
            showAlert("Order Cancelled");
            OrderNumberComboButton.getItems().clear();
            OrderNumberComboButton.getItems().addAll(getModel().getOrders());

        }
    }

    /** Show alert.
     *
     * @param message the message */
    public void showAlert(String message) {
        Alert alert= new Alert(AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setContentText(message);
        alert.showAndWait();
    }

    /** On export order pressed.
     *
     * @param event the event */
    @FXML
    void OnExportOrderPressed(ActionEvent event) {
        try {
            getModel().export(ORDERS_FILE);
            showAlert("Orders exported to " + ORDERS_FILE);
        } catch (FileNotFoundException e) {
            showAlert("Unable to save orders to " + ORDERS_FILE);
        }
    }

    /** On back pressed.
     *
     * @param event the event
     * @throws IOException Signals that an I/O exception has occurred. */
    @FXML
    void OnBackPressed(ActionEvent event) throws IOException {
        RUpizzaMain.displayView("RUpizza.fxml", "RU Pizza", getStage(), getModel());

    }

}
