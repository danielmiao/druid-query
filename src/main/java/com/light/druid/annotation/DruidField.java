package com.light.druid.annotation;

import com.light.druid.type.DruidFieldType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: danielmiao
 * @Date: 2019/3/15 18:15
 * @Version 0.0.1
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DruidField {

    String name();

    DruidFieldType type() default DruidFieldType.DIMENSION;
}