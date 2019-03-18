package com.light.druid.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.HashMap;

/**
 * @author danielmiao
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DefaultDruidQueryResult extends DruidQueryResult<HashMap<String, String>> {
}
