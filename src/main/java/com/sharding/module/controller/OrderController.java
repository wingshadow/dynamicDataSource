package com.sharding.module.controller;


import com.sharding.persistence.entity.OrderDO;
import com.sharding.persistence.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Title: OrderController
 * @ProjectName sharding-master-slave
 * @Author FlyShadow
 * @Date 2019/10/15 11:37
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(path = "/order/add",method = RequestMethod.GET)
    public String add(){
        OrderDO order = new OrderDO();
        order.setOrderId(1);
        order.setUserId(1);
        orderService.inert(order);
        OrderDO order2 = new OrderDO();
        order2.setOrderId(2);
        order2.setUserId(2);
        orderService.inert(order2);
        return "success";
    }

    @RequestMapping(path = "/order/list", method = {RequestMethod.GET})
    public List<OrderDO> getOrderList() {
        return orderService.list();
    }
}

