package com.light.druid.protocol;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danielmiao
 */
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DruidFilter {

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String type;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String dimension;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String value;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String lower;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String upper;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String ordering;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private boolean lowerStrict;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private boolean upperStrict;

    @Getter
    private List<DruidFilter> fields = new ArrayList<>();

    DruidFilter() {
    }

    DruidFilter(String type, String dimension, String value) {
        this.type = type;
        this.dimension = dimension;
        this.value = value;
    }

    DruidFilter(String type, String dimension, String lower, String upper, String ordering) {
        this.type = type;
        this.lower = lower;
        this.upper = upper;
        this.ordering = ordering;
        this.dimension = dimension;
    }
}
