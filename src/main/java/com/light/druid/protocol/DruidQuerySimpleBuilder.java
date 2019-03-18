package com.light.druid.protocol;

import com.light.druid.type.DruidFieldType;
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
public class DruidQuerySimpleBuilder {

    private DruidQuery query;


    public DruidQuerySimpleBuilder() {
        this.query = new DruidQuery();
    }

    public static DruidQuerySimpleBuilder create() {
        return new DruidQuerySimpleBuilder();
    }


    /**
     * 设置查询类型
     */
    public DruidQuerySimpleBuilder setQueryType(@Valid @NotNull DruidQueryType queryType) {
        this.query.setQueryType(queryType.getValue());
        return this;
    }

    /**
     * 设置查询数据源
     */
    public DruidQuerySimpleBuilder setDataSource(@Valid @NotBlank String dataSource) {
        this.query.setDataSource(dataSource);
        return this;
    }

    /**
     * 设置查询粒度
     */
    public DruidQuerySimpleBuilder setGranularity(@Valid @NotNull DruidQueryGranularity queryGranularity) {
        this.query.setGranularity(queryGranularity.getValue());
        return this;
    }

    /**
     * 设置Ton N维度
     */
    public DruidQuerySimpleBuilder setDimension(@Valid @NotNull String dimension) {
        if (!DruidQueryType.TOP_N.getValue().equals(this.query.getQueryType())) {
            throw new IllegalArgumentException("dimension is only worked in top n.");
        }
        this.query.setDimension(dimension);
        return this;
    }

    /**
     * 设置Ton N阈值
     */
    public DruidQuerySimpleBuilder setThreshold(@Valid @NotNull int threshold) {
        if (!DruidQueryType.TOP_N.getValue().equals(this.query.getQueryType())) {
            throw new IllegalArgumentException("dimension is only worked in top n.");
        }
        this.query.setThreshold(threshold);
        return this;
    }

    /**
     * 设置Ton N 维度
     */
    public DruidQuerySimpleBuilder setMetric(@Valid @NotBlank String metric, DruidFilterOrdering order) {
        if (!DruidQueryType.TOP_N.getValue().equals(this.query.getQueryType())) {
            throw new IllegalArgumentException("dimension is only worked in top n.");
        }

        DruidMetric druidMetric = new DruidMetric();
        druidMetric.setMetric(metric);
        if (order != null) {
            druidMetric.setType(order.getValue());
        }
        this.query.setMetric(druidMetric);
        return this;
    }

    /**
     * 设置GroupBy维度 *未实现
     */
    public DruidQuerySimpleBuilder setDimensions(@Valid @NotNull String dimension) {
        return this;
    }

    /**
     * 设置过滤器
     */
    public DruidQuerySimpleBuilder setFilter(@Valid @NotNull DruidFilter filter) {
        this.query.setFilter(filter);
        return this;
    }

    /**
     * 设置聚合
     */
    public DruidQuerySimpleBuilder addAggregation(@Valid @NotNull DruidAggregation aggregation) {
        this.query.getAggregations().add(aggregation);
        return this;
    }

    /**
     * 设置聚合
     */
    public DruidQuerySimpleBuilder addAggregation(@Valid @NotNull DruidFieldType type, @Valid @NotBlank String name,
                                                  @Valid @NotBlank String fieldName) {
        this.query.getAggregations().add(new DruidAggregation(type.getAggregationName(), name, fieldName));
        return this;
    }

    /**
     * 设置聚合
     */
    public DruidQuerySimpleBuilder addInterval(@Valid @Min(0) long start, @Valid @Min(0) long end) {
        this.query.getIntervals().add(DruidDateConvert.convertTimestamp(start) + "/" + DruidDateConvert
                .convertTimestamp(end));
        return this;
    }

    public DruidQuery build() {
        return this.query;
    }
}
