package com.javaman.microservice.two.response;

import lombok.Data;

/**
 * @auther: pengzhe
 * @date: 2019/5/17 23:34
 * @description:
 */
@Data
public class JsonResult {

    private String status = null;

    private Object result = null;
}
