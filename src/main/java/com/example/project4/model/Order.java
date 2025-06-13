package com.example.project4.model;

import java.util.ArrayList;

/** The Class Order represents a single order.
 * 
 * @author Stephen Wassum */
public class Order {

    /** The Constant SALES_TAX. */
    public static final double SALES_TAX= 0.06625;

    /** The order number. */
    private int orderNumber;

    /** The pizzas. */
    private ArrayList<Pizza> pizzas;

    /** Instantiates a new order.
     *
     * @param orderNumber the order number */
    public Order(int orderNumber) {
        this.orderNumber= orderNumber;
        pizzas= new ArrayList<>();
    }

    /** Adds the pizza.
     *
     * @param pizza the pizza */
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    /** Removes the pizza.
     *
     * @param pizza the pizza */
    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    /** Gets the order number.
     *
     * @return the order number */
    public int getOrderNumber() {
        return orderNumber;
    }

    /** Gets the pizzas.
     *
     * @return the pizzas */
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    /** To file string.
     *
     * @return the string to write to file */
    public String toFileString() {
        String out= "";
        out+= "Order Number: " + orderNumber + "\n";
        for (int i= 0; i < pizzas.size(); i++ ) {
            out+= "\nPizza " + (i + 1) + ": ";
            out+= pizzas.get(i);
            out+= "\n";
        }

        out+= String.format("\n\n >> Subtotal: $%.2f\n", subtotal());
        out+= String.format(" >> Salex Tax: $%.2f\n", salesTax());
        out+= String.format(" >> Order Total: $%.2f\n", totalPrice());

        return out;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return orderNumber + "";
    }

    /** Gets the subtotal.
     *
     * @return the subtotal */
    public double subtotal() {
        double total= 0;
        for (Pizza pizza : pizzas) {
            total+= pizza.price();
        }
        return total;
    }

    /** Calculates Sales tax.
     *
     * @return the sales tax */
    public double salesTax() {
        return subtotal() * SALES_TAX;
    }

    /** Calculates the Total price.
     *
     * @return the total */
    public double totalPrice() {
        return subtotal() + salesTax();
    }

}
