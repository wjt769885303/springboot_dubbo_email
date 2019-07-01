package com.qf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.entity.User;

/**
 * @Author WJT
 * @Date 2019/6/29 10:45
 * @Version 1.0
 **/


public interface UserLoginMapper extends BaseMapper<User> {

    public User selectUserByusername(String username);
    public void updatePassword(User user);

    public User selectByUser(User user);
}
