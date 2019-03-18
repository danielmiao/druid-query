package com.light.druid.protocol;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.light.druid.utils.SerializableUtils;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danielmiao
 */
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DruidQuery {


    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String queryType;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String dataSource;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String granularity;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String dimension;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private int threshold;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private DruidMetric metric;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private DruidLimitSpec limitSpec;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private DruidFilter filter;

    @Getter
    private List<DruidAggregation> aggregations = new ArrayList<>();

    @Getter
    private List<DruidPostAggregation> postAggregations = new ArrayList<>();

    @Getter
    private List<String> intervals = new ArrayList<>();

    protected DruidQuery() {
    }

    @Override
    public String toString() {
        try {
            return SerializableUtils.json.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}
