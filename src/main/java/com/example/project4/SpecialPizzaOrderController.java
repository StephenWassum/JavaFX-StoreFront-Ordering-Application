package com.example.project4;

import java.io.IOException;

import com.example.project4.model.Order;
import com.example.project4.model.Pizza;
import com.example.project4.model.PizzaMaker;
import com.example.project4.model.Size;
import com.example.project4.model.Topping;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/** The Class SpecialPizzaOrderController is controller for speciality pizza orders.
 * 
 * 
 * @author Stephen Wassum */
public class SpecialPizzaOrderController extends Controller {

    /** The Add to order button. */
    @FXML
    private Button AddToOrderButton;

    /** The Extra cheese button. */
    @FXML
    private CheckBox ExtraCheeseButton;

    /** The Extra sauce button. */
    @FXML
    private CheckBox ExtraSauceButton;

    /** The Large button. */
    @FXML
    private RadioButton LargeButton;

    /** The Medium button. */
    @FXML
    private RadioButton MediumButton;

    /** The Small button. */
    @FXML
    private RadioButton SmallButton;

    /** The Pizza type combo button. */
    @FXML
    private ComboBox<String> PizzaTypeComboButton;

    /** The Price display. */
    @FXML
    private TextArea PriceDisplay;

    /** The Sauce input. */
    @FXML
    private TextField SauceInput;

    /** The Topping list. */
    @FXML
    private ListView<Topping> ToppingList;

    /** The sizes. */
    @FXML
    private ToggleGroup sizes;

    /** The specialpizza. */
    @FXML
    private ImageView specialpizza;

    /** The pizza. */
    private Pizza pizza;

    /** Initialize. */
    public void initialize() {
        PizzaTypeComboButton.getItems().addAll("Deluxe", "Supreme", "Meatzza", "Seafood",
            "Pepperoni");
        PizzaTypeComboButton.getSelectionModel().selectedItemProperty()
            .addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> selected, String oldPizza,
                    String newPizza) {

                    if (newPizza != null) {
                        pizza= PizzaMaker.createPizza(newPizza);
                        showCurrentPizza();
                    }
                }
            });

    }

    /** Show current pizza. */
    public void showCurrentPizza() {
        if (pizza == null) {
            PizzaTypeComboButton.getSelectionModel().clearSelection();
            if (sizes.getSelectedToggle() != null)
                sizes.getSelectedToggle().setSelected(false);
            ToppingList.getItems().clear();
            ExtraCheeseButton.selectedProperty().setValue(false);
            ExtraSauceButton.selectedProperty().setValue(false);
            SauceInput.setText("");
            PriceDisplay.setText("");

        } else {
            showSize();
            showToppings();
            SauceInput.setText(pizza.getSauce().toString());
            PriceDisplay.setText(String.format("%.2f", pizza.price()));
        }

        showPizzaImage();

    }

    /** Show pizza image. */
    public void showPizzaImage() {
        try {
            if (pizza != null) {
                Image image= new Image(SpecialPizzaOrderController.class.getResourceAsStream(
                    "../../../RUPiazzaImages/" + pizza.getName().toLowerCase() + ".jpeg"));
                specialpizza.setImage(image);
            } else {
                Image image= new Image(SpecialPizzaOrderController.class
                    .getResourceAsStream("../../../RUPiazzaImages/" + "pizzas.jpeg"));
                specialpizza.setImage(image);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Show size. */
    private void showSize() {
        if (pizza == null) { return; }

        Size size= pizza.getSize();
        if (size == Size.SMALL)
            SmallButton.selectedProperty().set(true);
        else if (size == Size.MEDIUM)
            MediumButton.selectedProperty().set(true);
        else if (size == Size.LARGE)
            LargeButton.selectedProperty().set(true);
    }

    /** Show toppings. */
    private void showToppings() {
        if (pizza == null) { return; }

        ToppingList.getItems().clear();
        ToppingList.getItems().addAll(pizza.getToppings());
    }

    /** On add to order pressed.
     *
     * @param event the event */
    @FXML
    void OnAddToOrderPressed(ActionEvent event) {

        if (pizza != null) {
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

    /** On large button press.
     *
     * @param event the event */
    @FXML
    void OnLargeButtonPress(ActionEvent event) {
        if (pizza == null) { return; }

        if (LargeButton.isSelected())
            pizza.setSize(Size.LARGE);
        showCurrentPizza();
    }

    /** On medium button press.
     *
     * @param event the event */
    @FXML
    void OnMediumButtonPress(ActionEvent event) {
        if (pizza == null) { return; }

        if (MediumButton.isSelected())
            pizza.setSize(Size.MEDIUM);
        showCurrentPizza();
    }

    /** On small button pressed.
     *
     * @param event the event */
    @FXML
    void OnSmallButtonPressed(ActionEvent event) {
        if (pizza == null) { return; }

        if (SmallButton.isSelected())
            pizza.setSize(Size.SMALL);
        showCurrentPizza();
    }

}
