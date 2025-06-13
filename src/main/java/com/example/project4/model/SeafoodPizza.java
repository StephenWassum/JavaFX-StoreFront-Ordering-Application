package com.example.project4.model;

/** The Class SeafoodPizza represents Seafood Pizza.
 * 
 * @author Stephen Wassum */
public class SeafoodPizza extends Pizza {

    /** Instantiates a new seafood pizza. */
    public SeafoodPizza() {
        super("Seafood");
        toppings.add(Topping.SHRIMP);
        toppings.add(Topping.SQUID);
        toppings.add(Topping.CRAB);
        sauce= Sauce.ALFREDO;
    }

    /* (non-Javadoc)
     * @see com.example.project4.model.Pizza#price()
     */
    @Override
    public double price() {
        double price= 17.99;
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
