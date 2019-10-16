package com.sharding.persistence.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Title: Order
 * @ProjectName sharding-master-slave
 * @Author FlyShadow
 * @Date 2019/10/14 14:54
 */
@Getter
@Setter
public class OrderDO {
    private Integer orderId;
    private Integer userId;
}
