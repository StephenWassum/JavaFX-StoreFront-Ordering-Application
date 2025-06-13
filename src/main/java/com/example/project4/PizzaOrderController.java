package com.example.project4;

import java.io.IOException;

import com.example.project4.model.Order;
import com.example.project4.model.Pizza;
import com.example.project4.model.PizzaMaker;
import com.example.project4.model.Sauce;
import com.example.project4.model.Size;
import com.example.project4.model.Topping;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;

/** The Class PizzaOrderController is controller for buy own pizza order view.
 * 
 * @author Stephen Wassum */
public class PizzaOrderController extends Controller {

    /** The Add item button. */
    @FXML
    private Button AddItemButton;

    /** The Add to order button. */
    @FXML
    private Button AddToOrderButton;

    /** The Additional topping list. */
    @FXML
    private ListView<Topping> AdditionalToppingList;

    /** The Alfredo sauce button. */
    @FXML
    private RadioButton AlfredoSauceButton;

    /** The Clear all H box. */
    @FXML
    private HBox ClearAll_HBox;

    /** The Extra cheese button. */
    @FXML
    private CheckBox ExtraCheeseButton;

    /** The Extra sauce button. */
    @FXML
    private CheckBox ExtraSauceButton;

    /** The Pizza size combo button. */
    @FXML
    private ComboBox<Size> PizzaSizeComboButton;

    /** The Price display. */
    @FXML
    private TextArea PriceDisplay;

    /** The Remove item. */
    @FXML
    private Button RemoveItem;

    /** The Sauces. */
    @FXML
    private ToggleGroup Sauces;

    /** The Selected toppings list. */
    @FXML
    private ListView<Topping> SelectedToppingsList;

    /** The Tomato sauce button. */
    @FXML
    private RadioButton TomatoSauceButton;

    /** The are you sure. */
    @FXML
    private HBox areYouSure;

    /** The pizza. */
    private Pizza pizza;

    /** Initialize. */
    public void initialize() {
        PizzaSizeComboButton.getItems().addAll(Size.values());
        PizzaSizeComboButton.getSelectionModel().selectedItemProperty()
            .addListener(new ChangeListener<Size>() {
                @Override
                public void changed(ObservableValue<? extends Size> selected, Size oldPizzaSize,
                    Size newPizzaSize) {

                    if (newPizzaSize != null) {
                        if (pizza == null)
                            pizza= PizzaMaker.createPizza("own");

                        pizza.setSize(newPizzaSize);
                        showCurrentPizza();
                    }
                }
            });

        PizzaSizeComboButton.getSelectionModel().select(0);
        AdditionalToppingList.getItems().addAll(Topping.values());

    }

    /** Show current pizza. */
    public void showCurrentPizza() {
        showToppings();

        if (pizza == null) {
            PizzaSizeComboButton.getSelectionModel().clearSelection();
            PizzaSizeComboButton.getSelectionModel().select(0);
        } else {

            ExtraCheeseButton.selectedProperty().setValue(pizza.hasExtraCheese());
            ExtraSauceButton.selectedProperty().setValue(pizza.hasExtraSauce());

            if (pizza.getSauce() == Sauce.TOMATO)
                TomatoSauceButton.selectedProperty().set(true);
            else if (pizza.getSauce() == Sauce.ALFREDO)
                AlfredoSauceButton.selectedProperty().set(true);

            PriceDisplay.setText(String.format("%.2f", pizza.price()));
        }

    }

    /** Show toppings. */
    private void showToppings() {
        SelectedToppingsList.getItems().clear();
        AdditionalToppingList.getItems().clear();

        AdditionalToppingList.getItems().addAll(Topping.values());

        if (pizza == null) { return; }

        AdditionalToppingList.getItems().removeAll(pizza.getToppings());
        SelectedToppingsList.getItems().addAll(pizza.getToppings());
    }

    /** On add item pressed.
     *
     * @param event the event */
    @FXML
    void OnAddItemPressed(ActionEvent event) {
        if (pizza == null)
            return;

        for (Topping topping : AdditionalToppingList.getSelectionModel().getSelectedItems()) {
            pizza.addTopping(topping);
        }

        showCurrentPizza();
    }

    /** On alfredo sauce button press.
     *
     * @param event the event */
    @FXML
    void OnAlfredoSauceButtonPress(ActionEvent event) {
        if (pizza != null) {
            pizza.setSauce(Sauce.ALFREDO);
            showCurrentPizza();
        }
    }

    /** On add to order pressed.
     *
     * @param event the event */
    @FXML
    void OnAddToOrderPressed(ActionEvent event) {

        if (pizza != null) {
            if (pizza.getToppings().size() < 3 || pizza.getToppings().size() > 7) {
                showAlert("Pizza topings should be between 3 and 7.");
                return;
            }

            Order order= getModel().getOrCreateOrder();
            order.addPizza(pizza);
            showAlert("Pizza added");
            pizza= null;
            showCurrentPizza();

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

    /** Show alert.
     *
     * @param message the message */
    public void showAlert(String message) {
        Alert alert= new Alert(AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setContentText(message);
        alert.showAndWait();
    }

    /** On extra cheese button press.
     *
     * @param event the event */
    @FXML
    void OnExtraCheeseButtonPress(ActionEvent event) {
        if (pizza == null) { return; }

        pizza.setExtraCheese(ExtraCheeseButton.isSelected());
        showCurrentPizza();
    }

    /** On extra sauce button press.
     *
     * @param event the event */
    @FXML
    void OnExtraSauceButtonPress(ActionEvent event) {
        if (pizza == null) { return; }

        pizza.setExtraSauce(ExtraSauceButton.isSelected());
        showCurrentPizza();
    }

    /** On remove item pressed.
     *
     * @param event the event */
    @FXML
    void OnRemoveItemPressed(ActionEvent event) {
        if (pizza == null)
            return;

        for (Topping topping : SelectedToppingsList.getSelectionModel().getSelectedItems()) {
            pizza.removeTopping(topping);
        }

        showCurrentPizza();
    }

    /** On tomato sauce button press.
     *
     * @param event the event */
    @FXML
    void OnTomatoSauceButtonPress(ActionEvent event) {
        if (pizza != null) {
            pizza.setSauce(Sauce.TOMATO);
            showCurrentPizza();
        }
    }

}
