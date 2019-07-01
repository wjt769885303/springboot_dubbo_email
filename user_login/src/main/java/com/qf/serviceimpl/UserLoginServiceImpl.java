package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.UserLoginMapper;
import com.qf.entity.User;
import com.qf.service.IUserLogin;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author WJT
 * @Date 2019/6/29 10:46
 * @Version 1.0
 **/

@Service
public class UserLoginServiceImpl implements IUserLogin {

    @Autowired
    UserLoginMapper userLoginMapper;

    @Override
    public User selectUserByusername(String username) {
        return userLoginMapper.selectUserByusername(username);
    }

    @Override
    public void updatePassword(User user) {
       userLoginMapper.updatePassword(user);
    }

    @Override
    public Boolean selectByUser(User user) {
        User i = userLoginMapper.selectByUser(user);
        if (i!=null){
            return true;
        }
        return false;
    }
}
