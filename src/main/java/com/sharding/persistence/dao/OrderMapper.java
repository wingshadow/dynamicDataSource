package com.sharding.persistence.dao;

import com.sharding.datasource.annotation.DBSource;
import com.sharding.persistence.entity.OrderDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Title: OrderMapper
 * @ProjectName sharding-master-slave
 * @Author FlyShadow
 * @Date 2019/10/14 15:02
 */
@Mapper
@Repository
public interface OrderMapper {
    @DBSource("dataSourceSecond")
    List<OrderDO> list();

    @DBSource("dataSourceFirst")
    void insert(OrderDO order);
}
