package com.light.druid.protocol;

import com.light.druid.type.DruidQueryType;

/**
 * @author danielmiao
 */
public class DruidTimeseriesQueryBuilder extends DruidQueryBuilder {

    private DruidTimeseriesQueryBuilder(Class<?> target, Class<?> result) {
        super(DruidQueryType.TIMESERIES, target, result);
    }

    public static DruidTimeseriesQueryBuilder create(Class<?> target, Class<?> result) {
        return new DruidTimeseriesQueryBuilder(target, result);
    }
}
