package com.light.druid.protocol;

import com.light.druid.type.DruidFilterOrdering;
import com.light.druid.type.DruidFilterType;

/**
 * The type Druid filter builder.
 *
 * @author danielmiao
 */
public class DruidFilterBuilder {

    private DruidFilter filter;


    /**
     * Instantiates a new Druid filter builder.
     */
    public DruidFilterBuilder() {
        this.filter = new DruidFilter();
    }

    /**
     * Create druid filter builder.
     *
     * @return the druid filter builder
     */
    public static DruidFilterBuilder create() {
        return new DruidFilterBuilder();
    }

    /**
     * Sets filter.
     *
     * @param type      the type
     * @param dimension the dimension
     * @param value     the value
     * @return the filter
     */
    public DruidFilterBuilder setFilter(DruidFilterType type, String dimension, String value) {
        this.filter.setType(type.getValue());
        this.filter.setDimension(dimension);
        this.filter.setValue(value);
        return this;
    }

    /**
     * Sets filter.
     *
     * @param type the type
     * @return the filter
     */
    public DruidFilterBuilder setFilter(DruidFilterType type) {
        this.filter.setType(type.getValue());
        return this;
    }


    /**
     * Add filter druid filter builder.
     *
     * @param type      the type
     * @param dimension the dimension
     * @param value     the value
     * @return the druid filter builder
     */
    public DruidFilterBuilder addFilter(DruidFilterType type, String dimension, String value) {
        this.filter.getFields().add(new DruidFilter(type.getValue(), dimension, value));
        return this;
    }

    /**
     * Add bound filter druid filter builder.
     *
     * @param dimension the dimension
     * @param lower     the lower
     * @param upper     the upper
     * @return the druid filter builder
     */
    public DruidFilterBuilder addBoundFilter(String dimension, long lower, long upper) {
        this.filter.getFields().add(new DruidFilter(DruidFilterType.BROUND.getValue(), dimension, Long.toString
                (lower), Long.toString(upper), DruidFilterOrdering.NUMERIC.getValue()));
        return this;
    }

    /**
     * Add filter druid filter builder.
     *
     * @param filter the filter
     * @return the druid filter builder
     */
    public DruidFilterBuilder addFilter(DruidFilter filter) {
        this.filter.getFields().add(filter);
        return this;
    }

    /**
     * Build druid filter.
     *
     * @return the druid filter
     */
    public DruidFilter build() {
        return this.filter;
    }
}
