package com.sharding.datasource.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;

/**
 * @Title: ShardingDataSourceUtil
 * @ProjectName sharding-master-slave
 * @Author FlyShadow
 * @Date 2019/10/15 9:42
 */
@Slf4j
public class ShardingDataSourceUtil {
    public static DataSource makeDataSource(BaseDataSourceProp baseDataSourceProp){
        HikariConfig jdbcConfig = new HikariConfig();
        jdbcConfig.setDriverClassName(baseDataSourceProp.getDriverClassName());
        jdbcConfig.setJdbcUrl(baseDataSourceProp.getUrl());
        jdbcConfig.setUsername(baseDataSourceProp.getUsername());
        jdbcConfig.setPassword(baseDataSourceProp.getPassword());
        jdbcConfig.setMinimumIdle(baseDataSourceProp.getMinimumIdle());
        jdbcConfig.setMaximumPoolSize(baseDataSourceProp.getMaximumPoolSize());
        jdbcConfig.setAutoCommit(baseDataSourceProp.getAutoCommit());
        jdbcConfig.setIdleTimeout(baseDataSourceProp.getIdleTimeout());
        jdbcConfig.setPoolName(baseDataSourceProp.getPoolName());
        jdbcConfig.setMaxLifetime(baseDataSourceProp.getMaxLifetime());
        jdbcConfig.setConnectionTimeout(baseDataSourceProp.getConnectionTimeout());
        jdbcConfig.setConnectionTestQuery(baseDataSourceProp.getConnectionTestQuery());
        return new HikariDataSource(jdbcConfig);
    }

}
