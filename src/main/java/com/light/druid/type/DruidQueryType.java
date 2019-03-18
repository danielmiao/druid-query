package com.light.druid.type;

/**
 * The enum Druid query type.
 */
public enum DruidQueryType {

    /**
     * Timeseries druid query type.
     */
    TIMESERIES("timeseries"),

    /**
     * Top n druid query type.
     */
    TOP_N("topN"),

    /**
     * Group by druid query type.
     */
    GROUP_BY("groupBy");

    private String value;

    DruidQueryType(String value) {
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
