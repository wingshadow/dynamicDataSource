package com.sharding.datasource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: DataSourceContextHolder
 * @ProjectName sharding-master-slave
 * @Author FlyShadow
 * @Date 2019/10/15 18:34
 */
@Slf4j
@Data
public class DataSourceContextHolder {
    /**
     * 默认数据源
     */
    static final String DEFAULT_DS = "dataSourceFirst";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    static void setDB(String dbType) {
        log.debug("切换到{}数据源", dbType);
        contextHolder.set(dbType);
    }

    static String getDB() {
        return contextHolder.get();
    }

    static void clearDB() {
        contextHolder.remove();
    }
}
