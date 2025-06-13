package com.example.project4;

import java.io.IOException;

import com.example.project4.model.Order;
import com.example.project4.model.Pizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

/** The Class CurrentOrderController is controller for viewing current order.
 * 
 * @author Stephen Wassum */
public class CurrentOrderController extends Controller {

    /** The Order number input. */
    @FXML
    private TextField OrderNumberInput;

    /** The Order total output box. */
    @FXML
    private TextField OrderTotalOutputBox;

    /** The Pizza order list. */
    @FXML
    private ListView<Pizza> PizzaOrderList;

    /** The Place order button. */
    @FXML
    private Button PlaceOrderButton;

    /** The Remove order box. */
    @FXML
    private Button RemoveOrderBox;

    /** The Sales tax output box. */
    @FXML
    private TextField SalesTaxOutputBox;

    /** The Subtotal output box. */
    @FXML
    private TextField SubtotalOutputBox;

    /** Initialize. */
    public void initialize() {
        showCurrentOrder();

    }

    /** Show current order. */
    public void showCurrentOrder() {
        PizzaOrderList.getItems().clear();
        SubtotalOutputBox.setText("");
        SalesTaxOutputBox.setText("");
        OrderTotalOutputBox.setText("");
        OrderNumberInput.setText("");

        Order order= getModel().getCurrentOrder();

        if (order != null) {
            PizzaOrderList.getItems().addAll(order.getPizzas());
            OrderNumberInput.setText(order.getOrderNumber() + "");
            SubtotalOutputBox.setText(String.format("%.2f", order.subtotal()));
            SalesTaxOutputBox.setText(String.format("%.2f", order.salesTax()));
            OrderTotalOutputBox.setText(String.format("%.2f", order.totalPrice()));
        }
    }

    /** On place order pressed.
     *
     * @param event the event */
    @FXML
    void OnPlaceOrderPressed(ActionEvent event) {
        Order order= getModel().getCurrentOrder();

        if (order != null) {
            getModel().finalizeOrder();
            showAlert("Order Placed");
            showCurrentOrder();
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

    /** On remove order pressed.
     *
     * @param event the event */
    @FXML
    void OnRemoveOrderPressed(ActionEvent event) {
        Order order= getModel().getCurrentOrder();

        if (order != null) {
            Pizza selected= PizzaOrderList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                order.removePizza(selected);
                showCurrentOrder();
            }

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
