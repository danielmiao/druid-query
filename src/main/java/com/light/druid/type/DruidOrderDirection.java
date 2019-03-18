package com.light.druid.type;

/**
 * The enum Druid order direction.
 */
public enum DruidOrderDirection {

    /**
     * Ascending druid order direction.
     */
    ASCENDING("ascending"),

    /**
     * Decending druid order direction.
     */
    DECENDING("descending");

    private String value;

    DruidOrderDirection(String value) {
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
