package com.light.druid.protocol;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DruidPostAggregation {

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String type;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String name;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String fn;

    private List<DruidFiledAccessor> fields = new ArrayList<>();

    protected DruidPostAggregation() {
    }

    protected DruidPostAggregation(String type, String name, String fn) {
        this.type = type;
        this.name = name;
        this.fn = fn;
    }
}
