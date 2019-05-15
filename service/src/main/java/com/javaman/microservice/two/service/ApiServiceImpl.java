package com.javaman.microservice.two.service;

import javax.annotation.PostConstruct;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;

import com.javaman.microservice.api.service.MicroService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author pengzhe
 * @date 2019-05-09 23:01
 * @description
 */

@Service(version = "${dubbo.service.version}")
public class ApiServiceImpl implements MicroService {

    @Value("${dubbo.service.name}")
    private String serviceName;

    @PostConstruct
    public String test() {
        return "OK";
    }

    @Override
    public String fetchInfo(int i) {
        RpcContext rpcContext = RpcContext.getContext();
        return String.format("Service [name :%s , port : %d] %s(\"%s\") : Hello,%s",
            serviceName,
            rpcContext.getLocalPort(),
            rpcContext.getMethodName(),
            String.valueOf(i),
            String.valueOf(i));
    }
}
