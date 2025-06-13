package com.example.project4;

import com.example.project4.model.StoreOrders;

import javafx.stage.Stage;

/** The Class Controller represents controller base class for all type of controllers.
 * 
 * @author Stephen Wassum */
public abstract class Controller {

    /** The model. */
    private StoreOrders model;

    /** The stage. */
    private Stage stage;

    /** Gets the model.
     *
     * @return the model */
    public StoreOrders getModel() {
        return model;
    }

    /** Gets the stage.
     *
     * @return the stage */
    public Stage getStage() {
        return stage;
    }

    /** Sets the model.
     *
     * @param model the new model */
    public void setModel(StoreOrders model) {
        this.model= model;
    }

    /** Sets the stage.
     *
     * @param stage the new stage */
    public void setStage(Stage stage) {
        this.stage= stage;
    }

}