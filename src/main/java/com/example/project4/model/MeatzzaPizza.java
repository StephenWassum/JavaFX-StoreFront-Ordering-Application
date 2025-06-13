package com.example.project4.model;

/** The Class MeatzzaPizza represents Meatzaa Pizza.
 * 
 * @author Stephen Wassum */
public class MeatzzaPizza extends Pizza {

    /** Instantiates a new meatzza pizza. */
    public MeatzzaPizza() {
        super("Meatzza");
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.BEEF);
        toppings.add(Topping.HAM);
        sauce= Sauce.TOMATO;
    }

    /* (non-Javadoc)
     * @see com.example.project4.model.Pizza#price()
     */
    @Override
    public double price() {
        double price= 16.99;
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
