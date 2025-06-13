package com.example.project4.model;

/** The Class DeluxePizza represents Deluxe Pizza.
 * 
 * @author Stephen Wassum */
public class DeluxePizza extends Pizza {

    /** Instantiates a new deluxe pizza. */
    public DeluxePizza() {
        super("Deluxe");
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.MUSHROOM);
        sauce= Sauce.TOMATO;
    }

    /* (non-Javadoc)
     * @see com.example.project4.model.Pizza#price()
     */
    @Override
    public double price() {
        double price= 14.99;
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
