package com.example.project4.model;

/** The Class PizzaMaker is factory class to create any type of pizza.
 * 
 * @author Stephen Wassum */
public class PizzaMaker {

    /** Creates the pizza.
     *
     * @param pizzaType the pizza type
     * @return the pizza */
    public static Pizza createPizza(String pizzaType) {

        switch (pizzaType.toLowerCase()) {
        case "deluxe":
            return new DeluxePizza();
        case "supreme":
            return new SupremePizza();
        case "meatzza":
            return new MeatzzaPizza();
        case "seafood":
            return new SeafoodPizza();
        case "pepperoni":
            return new PepperoniPizza();
        case "own":
            return new BuildOwnPizza();

        default:
            throw new IllegalArgumentException("Invalid pizza type - " + pizzaType);
        }

    }
}