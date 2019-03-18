package com.light.druid.annotation;

import com.light.druid.protocol.DruidFilterBuilder;
import com.light.druid.protocol.DruidQuery;
import com.light.druid.protocol.DruidQuerySimpleBuilder;
import com.light.druid.type.DruidFieldType;
import com.light.druid.type.DruidFilterType;
import com.light.druid.type.DruidQueryGranularity;
import com.light.druid.type.DruidQueryType;
import org.junit.Test;

/**
 * @author danielmiao
 */
public class DruidSimpleQueryBuilderTests {


    private final static String LOCAL_USED_COUPON = "ucop";
    private final static String LOCAL_USED_AMOUNT = "uamt";
    private final static String LOCAL_DEPLOY_COUPON = "cop";
    private final static String LOCAL_DEPLOY_USER = "user";
    private final static String LOCAL_DEPLOY_AMOUNT = "amt";

    @Test
    public void testQueryBuilder() {
        long storeId = 775393801979035653L;
        long ruleId = 12345;
        long timestamp = System.currentTimeMillis();
        //get used by daily
        DruidQuery query = DruidQuerySimpleBuilder.create()
                .setQueryType(DruidQueryType.TIMESERIES)
                .setDataSource(CouponStatDefine.DATA_SOURCE)
                .setGranularity(DruidQueryGranularity.ALL)
                .setFilter(DruidFilterBuilder.create()
                        .setFilter(DruidFilterType.AND)
                        .addFilter(DruidFilterType.SELECTOR, CouponStatDefine.DIMENSIONS_STORE_ID, Long
                                .toString(storeId))
                        .addFilter(DruidFilterType.SELECTOR, CouponStatDefine.DIMENSIONS_RULE_ID, Long
                                .toString(ruleId))
                        .build())
                .addAggregation(DruidFieldType.HYPER_UNIQUE, LOCAL_DEPLOY_USER, CouponStatDefine
                        .METRICS_SPEC_HYPER_UNIQUE_DEPLOY_USER_ID)
                .addAggregation(DruidFieldType.LONG_SUM, LOCAL_DEPLOY_AMOUNT, CouponStatDefine
                        .METRICS_SPEC_LONG_SUM_DEPLOY_AMOUNT)
                .addAggregation(DruidFieldType.HYPER_UNIQUE, LOCAL_DEPLOY_COUPON, CouponStatDefine
                        .METRICS_SPEC_HYPER_UNIQUE_DEPLOY_COUPON_ID)
                .addAggregation(DruidFieldType.LONG_SUM, LOCAL_USED_AMOUNT, CouponStatDefine
                        .METRICS_SPEC_LONG_SUM_USED_AMOUNT)
                .addAggregation(DruidFieldType.HYPER_UNIQUE, LOCAL_USED_COUPON, CouponStatDefine
                        .METRICS_SPEC_HYPER_UNIQUE_DEPLOY_COUPON_ID)
                .addInterval(StatisticsDateConvert.getMinOfDay(timestamp), StatisticsDateConvert.getMaxOfDay
                        (timestamp)).build();

        System.out.println(query.toString());
    }
}
