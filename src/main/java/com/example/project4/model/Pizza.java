package com.example.project4.model;

import java.util.ArrayList;

/** The Class Pizza is base class for all types of pizzas.
 * 
 * @author Stephen Wassum */
public abstract class Pizza {

    /** The toppings. */
    protected ArrayList<Topping> toppings; // Topping is a enum class

    /** The size. */
    protected Size size; // Size is a enum class

    /** The sauce. */
    protected Sauce sauce; // Sauce is a enum class

    /** The extra sauce. */
    protected boolean extraSauce;

    /** The extra cheese. */
    protected boolean extraCheese;

    /** The name. */
    protected String name;

    /** Instantiates a new pizza.
     *
     * @param name the name */
    public Pizza(String name) {
        toppings= new ArrayList<>();
        size= Size.SMALL;
        sauce= Sauce.TOMATO;
        extraCheese= false;
        extraCheese= false;
        this.name= name;
    }

    /** Gets the toppings.
     *
     * @return the toppings */
    public ArrayList<Topping> getToppings() {
        return new ArrayList<>(toppings);
    }

    /** Gets the size.
     *
     * @return the size */
    public Size getSize() {
        return size;
    }

    /** Gets the sauce.
     *
     * @return the sauce */
    public Sauce getSauce() {
        return sauce;
    }

    /** Checks for extra sauce.
     *
     * @return true, if successful */
    public boolean hasExtraSauce() {
        return extraSauce;
    }

    /** Checks for extra cheese.
     *
     * @return true, if successful */
    public boolean hasExtraCheese() {
        return extraCheese;
    }

    /** Adds the topping.
     *
     * @param topping the topping
     * @return true, if successful */
    public boolean addTopping(Topping topping) {
        if (!toppings.contains(topping)) {
            toppings.add(topping);
            return true;
        }

        return false;
    }

    /** Removes the topping.
     *
     * @param topping the topping
     * @return true, if successful */
    public boolean removeTopping(Topping topping) {
        if (toppings.contains(topping)) {
            toppings.remove(topping);
            return true;
        }

        return false;
    }

    /** Sets the size.
     *
     * @param size the new size */
    public void setSize(Size size) {
        this.size= size;
    }

    /** Sets the sauce.
     *
     * @param sauce the new sauce */
    public void setSauce(Sauce sauce) {
        this.sauce= sauce;
    }

    /** Sets the extra sauce.
     *
     * @param extraSauce the new extra sauce */
    public void setExtraSauce(boolean extraSauce) {
        this.extraSauce= extraSauce;
    }

    /** Sets the extra cheese.
     *
     * @param extraCheese the new extra cheese */
    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese= extraCheese;
    }

    /** Gets the name.
     *
     * @return the name */
    public String getName() {
        return name;
    }

    /** Calculates Price of pizza.
     *
     * @return the price */
    public abstract double price(); // polymorphism

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String out= name + " Pizza [" + size + "]";
        out+= "\nSauce: " + sauce;
        out+= "\nToppings: " + toppings;
        if (extraSauce)
            out+= "\nExtra Sauce";
        if (extraCheese)
            out+= "\nExtra Cheese";
        out+= String.format("\nPrice: $%.2f", price());
        return out;
    }
}