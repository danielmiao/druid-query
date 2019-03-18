package com.light.druid.annotation;

import com.light.druid.protocol.DruidFilterBuilder;
import com.light.druid.protocol.DruidQuery;
import com.light.druid.protocol.DruidTimeseriesQueryBuilder;
import com.light.druid.type.DruidFilterType;
import com.light.druid.type.DruidQueryGranularity;
import org.junit.Test;

/**
 * @author danielmiao
 */
public class DruidTimeseriesQueryBuilderTests {

    @Test
    public void testQueryBuilder() {
        long storeId = 775393801979035653L;
        long ruleId = 12345;
        long timestamp = System.currentTimeMillis();

        DruidQuery query = DruidTimeseriesQueryBuilder.create(CouponStat.class, CouponQueryItem.class)
                .setGranularity(DruidQueryGranularity.DAY)
                .setFilter(DruidFilterBuilder.create()
                        .setFilter(DruidFilterType.AND)
                        .addFilter(DruidFilterType.SELECTOR, CouponStatDefine.DIMENSIONS_STORE_ID,
                                Long.toString(storeId))
                        .addFilter(DruidFilterType.SELECTOR, CouponStatDefine.DIMENSIONS_RULE_ID, Long.toString(ruleId))
                        .build())
                .addInterval(StatisticsDateConvert.getMinOfDay(timestamp), StatisticsDateConvert.getMaxOfDay
                        (timestamp)).build();

        System.out.println(query.toString());
    }
}
