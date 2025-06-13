package com.example.project4.model;

/** The Enum Size representssize of pizza.
 * 
 * @author Stephen Wassum */
public enum Size {

    /** The small. */
    SMALL("Small"),
    /** The medium. */
    MEDIUM("Medium"),
    /** The large. */
    LARGE("Large");

    /** The name. */
    private String name;

    /** Instantiates a new size.
     *
     * @param name the name */
    private Size(String name) {
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
