package com.light.druid.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.light.druid.protocol.DruidStatus;
import lombok.*;

/**
 * @author danielmiao
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DruidResult {

    private DruidStatus result;
}
