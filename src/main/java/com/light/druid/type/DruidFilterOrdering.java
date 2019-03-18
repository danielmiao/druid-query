package com.light.druid.type;

/**
 * The enum Druid filter ordering.
 */
public enum DruidFilterOrdering {

    /**
     * Lexico graphic druid filter ordering.
     */
    LEXICO_GRAPHIC("lexicographic"),

    /**
     * Alpha numeric druid filter ordering.
     */
    ALPHA_NUMERIC("alphanumeric"),

    /**
     * Numeric druid filter ordering.
     */
    NUMERIC("numeric"),

    /**
     * Str len druid filter ordering.
     */
    STR_LEN("strlen");

    private String value;

    DruidFilterOrdering(String value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }
}
