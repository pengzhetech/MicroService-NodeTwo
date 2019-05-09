package com.javaman.microservice.two.service;

import org.springframework.stereotype.Service;

/**
 * @author pengzhe
 * @date 2019-05-09 22:27
 * @description
 */
@Service
public class MicroService {

    public String microService(String param) {
        return param + " is OK";
    }
}
