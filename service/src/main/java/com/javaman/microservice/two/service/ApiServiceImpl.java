package com.javaman.microservice.two.service;

import javax.annotation.PostConstruct;

import com.javaman.microservice.api.service.MicroService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
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
        String attachment = rpcContext.getAttachment("consumerKey");
        System.out.println("attachment---->" + attachment);
        return String.format("Service [name :%s , port : %d] %s(\"%s\") : Hello,%s,%s",
            serviceName,
            rpcContext.getLocalPort(),
            rpcContext.getMethodName(),
            String.valueOf(i),
            String.valueOf(i),
            attachment);
    }
}
