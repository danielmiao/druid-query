package com.light.druid.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * @author danielmiao
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DruidQueryResult<T> {

    private String timestamp;

    public T result;

}
