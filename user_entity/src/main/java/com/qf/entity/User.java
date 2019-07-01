package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author WJT
 * @Date 2019/6/29 10:12
 * @Version 1.0
 **/


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  implements Serializable {
    String  username;
    String  password;
    String  petname;
    String email;


}
