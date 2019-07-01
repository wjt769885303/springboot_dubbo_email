package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;

import com.qf.dao.UserRegistorMapper;


import com.qf.entity.User;
import com.qf.service.IUserResgistor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;


/**
 * @Author WJT
 * @Date 2019/6/29 10:10
 * @Version 1.0
 **/


@Service
public class UserResgistorServiceImpl implements IUserResgistor {

    @Autowired
    UserRegistorMapper userRegistorMapper;


    @Override
    public Boolean selectByName(String username) {

        String i = userRegistorMapper.selectByName(username);
        if(i!=null){
            return true;
        }
        return false;
    }

    @Override
    public int inserUser(User user) {
        return userRegistorMapper.insert(user);
    }
}
