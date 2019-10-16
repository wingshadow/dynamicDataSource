package com.sharding.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Title: DynamicRoutingDataSource
 * @ProjectName sharding-master-slave
 * @Author FlyShadow
 * @Date 2019/10/15 11:37
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDB();
    }
}
