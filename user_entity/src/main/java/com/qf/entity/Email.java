package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author WJT
 * @Date 2019/6/29 15:38
 * @Version 1.0
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email implements Serializable {


    private String from;
    private String  addTo;
    private String setSubject;
    private String  setText;


}
