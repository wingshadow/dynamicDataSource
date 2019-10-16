package com.sharding.persistence.service;

import com.sharding.persistence.dao.OrderMapper;
import com.sharding.persistence.entity.OrderDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: OrderService
 * @ProjectName sharding-master-slave
 * @Author FlyShadow
 * @Date 2019/10/14 15:13
 */
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public List<OrderDO> list(){
        return orderMapper.list();
    }

    public void inert(OrderDO order){
        orderMapper.insert(order);
    }
}
