package com.javaman.microservice.two.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @auther: pengzhe
 * @date: 2019/5/17 23:37
 * @description:
 */
@Data
public class User {
    private int id;
    private String username;
    private int age;
    private Date ctm;

}
