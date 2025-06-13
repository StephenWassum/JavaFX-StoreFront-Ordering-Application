package com.example.project4.model;

/** The Class PepperoniPizza represents Pepperoni Pizza.
 * 
 * @author Stephen Wassum */
public class PepperoniPizza extends Pizza {

    /** Instantiates a new pepperoni pizza. */
    public PepperoniPizza() {
        super("Pepperoni");
        toppings.add(Topping.PEPPERONI);
        sauce= Sauce.TOMATO;
    }

    /* (non-Javadoc)
     * @see com.example.project4.model.Pizza#price()
     */
    @Override
    public double price() {
        double price= 10.99;
        if (size == Size.MEDIUM)
            price+= 2;
        else if (size == Size.LARGE)
            price+= 4;

        if (extraCheese)
            price+= 1;

        if (extraSauce)
            price+= 1;

        return price;
    }

}
