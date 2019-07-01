package com.qf.service;

import com.qf.entity.User;

/**
 * @Author WJT
 * @Date 2019/6/29 10:05
 * @Version 1.0
 **/

public interface IUserLogin {

    public User selectUserByusername(String username);

    public void updatePassword(User user);

    public Boolean selectByUser(User user);
}
