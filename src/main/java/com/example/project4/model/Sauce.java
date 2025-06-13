package com.example.project4.model;

/** The Enum Sauce represents pizza sauce.
 * 
 * @author Stephen Wassum */
public enum Sauce {

    /** The tomato. */
    TOMATO("Tomato"),
    /** The alfredo. */
    ALFREDO("Alferdo");

    /** The name. */
    private String name;

    /** Instantiates a new sauce.
     *
     * @param name the name */
    private Sauce(String name) {
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
