package com.light.druid.protocol;

import com.light.druid.type.DruidFilterOrdering;
import com.light.druid.type.DruidQueryGranularity;
import com.light.druid.type.DruidQueryType;
import com.light.druid.utils.DruidDateConvert;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author danielmiao
 */
public class DruidTopQueryBuilder extends DruidQueryBuilder {

    private DruidTopQueryBuilder(Class<?> target, Class<?> result) {
        super(DruidQueryType.TOP_N, target, result);
    }

    public static DruidTopQueryBuilder create(Class<?> target, Class<?> result) {
        return new DruidTopQueryBuilder(target, result);
    }

    /**
     * 设置必填参数
     */
    public DruidTopQueryBuilder setRequiredParam(@Valid @NotNull String dimension, @Valid @NotNull int threshold, @Valid
    @NotBlank String metric, DruidFilterOrdering order) {
        this.query.setDimension(dimension);
        this.query.setThreshold(threshold);
        DruidMetric druidMetric = new DruidMetric();
        druidMetric.setMetric(metric);
        if (order != null) {
            druidMetric.setType(order.getValue());
        }
        this.query.setMetric(druidMetric);
        return this;
    }


}
