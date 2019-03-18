package com.light.druid.protocol;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DruidMetric {

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String type;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String metric;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String previousStop;

    protected DruidMetric() {
    }

    public DruidMetric(String type, String metric) {
        this.type = type;
        this.metric = metric;
    }
}
