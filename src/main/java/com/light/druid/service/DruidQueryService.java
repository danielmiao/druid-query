package com.light.druid.service;

import com.light.druid.protocol.DruidQuery;
import com.light.druid.result.DruidTopQueryResult;

import java.util.List;

/**
 * The interface Druid query service.
 *
 * @author danielmiao
 */
public interface DruidQueryService {
    /**
     * Query list.
     *
     * @param <T>   the type parameter
     * @param query the query
     * @param clazz the clazz
     * @return the list
     */
    <T> List<T> query(DruidQuery query, Class<T> clazz);

//    <C extends Collection, E> List<C> query(DruidQuery query, Class<C> cClazz, Class<E> eClazz);

    <T> List<DruidTopQueryResult<T>> queryTopN(DruidQuery query, Class<T> cClazz);
}
