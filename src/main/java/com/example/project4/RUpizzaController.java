package com.example.project4;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/** The Class RUpizzaController is controller for main view.
 * 
 * @author Stephen Wassum */
public class RUpizzaController extends Controller {

    /** The Build pizza button. */
    @FXML
    private Button BuildPizzaButton;

    /** The Current order button. */
    @FXML
    private Button CurrentOrderButton;

    /** The Specialty pizza button. */
    @FXML
    private Button SpecialtyPizzaButton;

    /** The Store orders button. */
    @FXML
    private Button StoreOrdersButton;

    /** The orderimage. */
    @FXML
    private ImageView orderimage;

    /** The pizza. */
    @FXML
    private ImageView pizza;

    /** The specialpizza. */
    @FXML
    private ImageView specialpizza;

    /** The storeimage. */
    @FXML
    private ImageView storeimage;

    /** On build pizza button.
     *
     * @param event the event
     * @throws IOException Signals that an I/O exception has occurred. */
    @FXML
    void OnBuildPizzaButton(ActionEvent event) throws IOException {

        RUpizzaMain.displayView("PizzaOrder.fxml", "Build Your Own Pizza", getStage(), getModel());
    }

    /** On current order button.
     *
     * @param event the event
     * @throws IOException Signals that an I/O exception has occurred. */
    @FXML
    void OnCurrentOrderButton(ActionEvent event) throws IOException {
        RUpizzaMain.displayView("CurrentOrder.fxml", "Current Order", getStage(), getModel());
    }

    /** On specialty pizza button.
     *
     * @param event the event
     * @throws IOException Signals that an I/O exception has occurred. */
    @FXML
    void OnSpecialtyPizzaButton(ActionEvent event) throws IOException {
        RUpizzaMain.displayView("SpecialPizzaOrder.fxml", "Speciality Pizza Order", getStage(),
            getModel());
    }

    /** On store orders button.
     *
     * @param event the event
     * @throws IOException Signals that an I/O exception has occurred. */
    @FXML
    void OnStoreOrdersButton(ActionEvent event) throws IOException {
        RUpizzaMain.displayView("StoreOrder.fxml", "Store Orders", getStage(), getModel());
    }

}
