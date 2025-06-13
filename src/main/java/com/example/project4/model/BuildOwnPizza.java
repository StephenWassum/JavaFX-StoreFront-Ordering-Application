package com.example.project4.model;

/** The Class BuildOwnPizza allows user to create own pizza.
 * 
 * @author Stephen Wassum */
public class BuildOwnPizza extends Pizza {

    public static final int MAX_TOPPINGS= 7, MIN_TOPPINGS= 3;

    /** Instantiates a new builds the own pizza. */
    public BuildOwnPizza() {
        super("Build your own");
    }

    /* (non-Javadoc)
     * @see com.example.project4.model.Pizza#addTopping(com.example.project4.model.Topping)
     */
    @Override
    public boolean addTopping(Topping topping) {
        if (toppings.size() == MAX_TOPPINGS)
            return false;

        return super.addTopping(topping);
    }

    /* (non-Javadoc)
     * @see com.example.project4.model.Pizza#price()
     */
    @Override
    public double price() {
        double price= 8.99;
        if (size == Size.MEDIUM)
            price+= 2;
        else if (size == Size.LARGE)
            price+= 4;

        if (extraCheese)
            price+= 1;

        if (extraSauce)
            price+= 1;

        if (toppings.size() > MIN_TOPPINGS) {
            price+= 1.49 * (toppings.size() - MIN_TOPPINGS);
        }

        return price;
    }

}
