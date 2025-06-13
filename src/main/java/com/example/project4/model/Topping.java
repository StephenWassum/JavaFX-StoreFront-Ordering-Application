package com.example.project4.model;

/** The Enum Topping. represents toppings
 * 
 * @author Stephen Wassum */
public enum Topping {

    /** The sausage. */
    SAUSAGE("Sausage"),
    /** The pepperoni. */
    PEPPERONI("Pepperoni"),
    /** The green pepper. */
    GREEN_PEPPER("Green Pepper"),
    /** The onion. */
    ONION("Onion"),

    /** The mushroom. */
    MUSHROOM("Mushroom"),
    /** The ham. */
    HAM("Ham"),
    /** The black olive. */
    BLACK_OLIVE("Black Olives"),
    /** The pineapple. */
    PINEAPPLE("Pineapple"),

    /** The beef. */
    BEEF("Beef"),
    /** The shrimp. */
    SHRIMP("Shrimp"),
    /** The squid. */
    SQUID("Squid"),
    /** The crab. */
    CRAB("Crab Meats"),
    /** The sweet corn. */
    SWEET_CORN("Sweet Corn");

    /** The name. */
    private String name;

    /** Instantiates a new topping.
     *
     * @param name the name */
    private Topping(String name) {
        this.name= name;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return name;
    }
}
