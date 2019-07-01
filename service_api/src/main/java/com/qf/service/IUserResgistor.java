package com.qf.service;

import com.qf.entity.User;

/**
 * @Author WJT
 * @Date 2019/6/29 11:24
 * @Version 1.0
 **/

public interface IUserResgistor {

    public Boolean selectByName(String username);

    public  int inserUser(User user);
}
