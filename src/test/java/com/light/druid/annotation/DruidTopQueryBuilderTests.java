package com.light.druid.annotation;

import com.light.druid.protocol.DruidFilterBuilder;
import com.light.druid.protocol.DruidQuery;
import com.light.druid.protocol.DruidTopQueryBuilder;
import com.light.druid.type.DruidFilterOrdering;
import com.light.druid.type.DruidFilterType;
import com.light.druid.type.DruidQueryGranularity;
import org.junit.Test;

/**
 * @author danielmiao
 */
public class DruidTopQueryBuilderTests {

    private final static String LOCAL_DEPLOY_AMOUNT = "amt";

    @Test
    public void testQueryBuilder() {
        long storeId = 775393801979035653L;
        long timestamp = System.currentTimeMillis() - 2 * 86400000;

        DruidQuery query = DruidTopQueryBuilder.create(CouponStat.class, CouponQueryItem.class)
                .setRequiredParam(CouponStatDefine.DIMENSIONS_RULE_ID, 100, LOCAL_DEPLOY_AMOUNT,
                        DruidFilterOrdering.NUMERIC)
                .setGranularity(DruidQueryGranularity.DAY)
                .setFilter(DruidFilterBuilder.create()
                        .setFilter(DruidFilterType.AND)
                        .addFilter(DruidFilterType.SELECTOR, CouponStatDefine.DIMENSIONS_STORE_ID,
                                Long.toString(storeId)).build())
                .addInterval(StatisticsDateConvert.getMinOfDay(timestamp), StatisticsDateConvert.getMaxOfDay
                        (timestamp)).build();

        System.out.println(query.toString());
    }
}
