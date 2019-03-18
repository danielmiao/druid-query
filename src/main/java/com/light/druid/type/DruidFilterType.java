package com.light.druid.type;

/**
 * The enum Druid filter type.
 */
public enum DruidFilterType {

    /**
     * Selector druid filter type.
     */
    SELECTOR("selector"),

    /**
     * Column comparison druid filter type.
     */
    COLUMN_COMPARISON("columnComparison"),

    /**
     * Regex druid filter type.
     */
    REGEX("regex"),

    /**
     * And druid filter type.
     */
    AND("and"),

    /**
     * Or druid filter type.
     */
    OR("or"),

    /**
     * Bround druid filter type.
     */
    BROUND("bound");

    private String value;

    DruidFilterType(String value) {
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
