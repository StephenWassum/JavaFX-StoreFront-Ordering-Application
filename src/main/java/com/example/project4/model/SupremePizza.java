package com.example.project4.model;

/** The Class SupremePizza is used to represent supreme pizza.
 * 
 * @author Stephen Wassum */
public class SupremePizza extends Pizza {

    /** Instantiates a new supreme pizza. */
    public SupremePizza() {
        super("Supreme");
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.HAM);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.BLACK_OLIVE);
        toppings.add(Topping.MUSHROOM);
        sauce= Sauce.TOMATO;
    }

    /* (non-Javadoc)
     * @see com.example.project4.model.Pizza#price()
     */
    @Override
    public double price() {
        double price= 15.99;
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
