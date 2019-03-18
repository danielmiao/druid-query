package com.light.druid.type;

/**
 * The enum Druid query granularity.
 *
 * @author danielmiao
 */
public enum DruidQueryGranularity {

    /**
     * None druid query granularity.
     */
    NONE("none"),

    /**
     * Year druid query granularity.
     */
    YEAR("year"),

    /**
     * Quarter druid query granularity.
     */
    QUARTER("quarter"),

    /**
     * Month druid query granularity.
     */
    MONTH("month"),

    /**
     * Week druid query granularity.
     */
    WEEK("week"),

    /**
     * Day druid query granularity.
     */
    DAY("day"),

    /**
     * Hour druid query granularity.
     */
    HOUR("hour"),

    /**
     * Thiryty minute druid query granularity.
     */
    THIRYTY_MINUTE("thirty_minute"),

    /**
     * Fifteen minute druid query granularity.
     */
    FIFTEEN_MINUTE("fifteen_minute"),

    /**
     * Minute druid query granularity.
     */
    MINUTE("minute"),

    /**
     * Second druid query granularity.
     */
    SECOND("second"),

    /**
     * All druid query granularity.
     */
    ALL("all");

    private String value;

    DruidQueryGranularity(String value) {
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
