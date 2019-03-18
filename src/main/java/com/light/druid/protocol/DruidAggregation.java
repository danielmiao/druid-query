package com.light.druid.protocol;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * @author danielmiao
 */
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DruidAggregation {

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String type;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String name;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String fieldName;

    protected DruidAggregation() {
    }

    protected DruidAggregation(String type, String name, String fieldName) {
        this.type = type;
        this.name = name;
        this.fieldName = fieldName;
    }
}
