package com.example.project4.model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/** The Class StoreOrders represents store orders and acts as model.
 * 
 * @author Stephen Wassum */
public class StoreOrders {

    /** The next order number. */
    private static int nextOrderNumber= 10001;

    /** The orders. */
    private ArrayList<Order> orders;

    /** The current order. */
    private Order currentOrder;

    /** Instantiates a new store orders. */
    public StoreOrders() {
        orders= new ArrayList<>();
    }

    /** Creates the new order.
     *
     * @return the order */
    public Order createNewOrder() {
        currentOrder= new Order(nextOrderNumber++ );
        return currentOrder;
    }

    /** Gets the current order.
     *
     * @return the current order */
    public Order getCurrentOrder() {
        return currentOrder;
    }

    /** Gets the or create order.
     *
     * @return the or create order */
    public Order getOrCreateOrder() {
        return currentOrder == null ? createNewOrder() : currentOrder;
    }

    /** Finalize order. */
    public void finalizeOrder() {
        orders.add(currentOrder);
        currentOrder= null;
    }

    /** Cancel order.
     *
     * @param order the order */
    public void cancelOrder(Order order) {
        orders.remove(order);
    }

    /** Gets the orders.
     *
     * @return the orders */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /** Export.
     *
     * @param filename the filename
     * @throws FileNotFoundException the file not found exception */
    public void export(String filename) throws FileNotFoundException {
        PrintWriter pw= new PrintWriter(filename);
        for (Order order : orders) {
            pw.println(order.toFileString());
            pw.println("-------------------------------------------------------");
        }

        pw.close();
    }

}
