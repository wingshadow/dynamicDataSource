package com.sharding.datasource;

import com.sharding.datasource.configuration.MasterDataSourceProp;
import com.sharding.datasource.configuration.ShardingDataSourceUtil;
import com.sharding.datasource.configuration.SlaveDataSourceProp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: DataSourceConfig
 * @ProjectName sharding-master-slave
 * @Author FlyShadow
 * @Date 2019/10/15 18:29
 */
@Configuration
public class DataSourceConfig {

    @Resource
    private MasterDataSourceProp masterDataSourceProp;

    @Resource
    private SlaveDataSourceProp slaveDataSourceProp;

    public DataSource master(){
        return ShardingDataSourceUtil.makeDataSource(masterDataSourceProp);
    }

    public DataSource slave(){
        return ShardingDataSourceUtil.makeDataSource(slaveDataSourceProp);
    }

    @Bean(name = "dynamicSource")
    public DynamicDataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();

        Map<Object, Object> dsMap = new HashMap<>(5);
        dsMap.put("dataSourceFirst", master());
        dsMap.put("dataSourceSecond", slave());
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }
}
