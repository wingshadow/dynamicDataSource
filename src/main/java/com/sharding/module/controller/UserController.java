package com.sharding.module.controller;

import com.sharding.persistence.entity.UserDO;
import com.sharding.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Title: UserController
 * @ProjectName sharding-master-slave
 * @Author FlyShadow
 * @Date 2019/10/15 11:37
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/user/add",method = RequestMethod.GET)
    public String add(){
        UserDO user = new UserDO();
        user.setId(1);
        user.setName("a");
        userService.inert(user);
        UserDO user2 = new UserDO();
        user2.setId(2);
        user2.setName("b");
        userService.inert(user2);
        return "success";
    }

    @RequestMapping(path = "/user/list", method = {RequestMethod.GET})
    public List<UserDO> getUserList() {
        return userService.list();
    }
}

