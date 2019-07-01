package com.qf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.entity.User;


/**
 * @Author WJT
 * @Date 2019/6/29 10:09
 * @Version 1.0
 **/

public interface UserRegistorMapper extends BaseMapper<User> {

   public String  selectByName(String username);


}
