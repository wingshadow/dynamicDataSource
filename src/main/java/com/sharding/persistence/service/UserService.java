package com.sharding.persistence.service;

import com.sharding.persistence.dao.UserMapper;
import com.sharding.persistence.entity.UserDO;
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
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserDO> list(){
        return userMapper.list();
    }

    public void inert(UserDO user){
        userMapper.insert(user);
    }
}
