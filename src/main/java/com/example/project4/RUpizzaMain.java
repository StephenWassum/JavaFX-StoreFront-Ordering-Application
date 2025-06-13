package com.example.project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.project4.model.StoreOrders;

/** The Class RUpizzaMain is main class for application.
 * 
 * @author Stephen Wassum */
public class RUpizzaMain extends Application {

    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage stage) throws IOException {
        StoreOrders model= new StoreOrders();
        displayView("RUpizza.fxml", "RU Pizza", stage, model);

    }

    /** Display view.
     *
     * @param fxml  the fxml
     * @param title the title
     * @param stage the stage
     * @param model the model
     * @throws IOException Signals that an I/O exception has occurred. */
    public static void displayView(String fxml, String title, Stage stage, StoreOrders model)
        throws IOException {
        FXMLLoader loader= new FXMLLoader(Controller.class.getResource(fxml), null, null,
            type -> {
                try {
                    Controller controller= (Controller) type.newInstance();
                    controller.setModel(model);
                    controller.setStage(stage);

                    return controller;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

        Parent root= loader.load();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.sizeToScene();
        stage.show();
    }

    /** The main method.
     *
     * @param args the arguments */
    public static void main(String[] args) {
        launch();
    }

}