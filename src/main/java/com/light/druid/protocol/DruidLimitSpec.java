package com.light.druid.protocol;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DruidLimitSpec {

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String type;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String limit;

    private List<String> columns = new ArrayList<>();

    protected DruidLimitSpec() {
    }

    protected DruidLimitSpec(String type, String limit) {
        this.type = type;
        this.limit = limit;
    }
}
