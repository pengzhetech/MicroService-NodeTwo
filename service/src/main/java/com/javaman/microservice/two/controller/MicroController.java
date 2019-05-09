package com.javaman.microservice.two.controller;

import com.javaman.microservice.two.service.MicroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengzhe
 * @date 2019-05-09 22:28
 * @description
 */
@RestController
@RequestMapping("/api")
public class MicroController {

    @Autowired
    private MicroService microService;

    @GetMapping("/get")
    public String test() {
        return microService.microService("哲哥");
    }
}
