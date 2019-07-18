package com.javaman.microservice.two.service;

import com.javaman.microservice.api.service.MicroService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Value;

/**
 * @auther: pengzhe
 * @since: 2019/7/18 21:52
 * @description:
 */
@Service(version = "${dubbo.service.version}",group = "service2")
public class ApiServiceImpl2 implements MicroService {


    @Value("${dubbo.service.name}")
    private String serviceName;

    @Override
    public String fetchInfo(int i) {
        RpcContext rpcContext = RpcContext.getContext();
        String attachment = rpcContext.getAttachment("consumerKey");
        System.out.println("attachment---->" + attachment);
        return String.format("Service2222222 [name :%s , port : %d] %s(\"%s\") : Hello,%s,%s",
                serviceName,
                rpcContext.getLocalPort(),
                rpcContext.getMethodName(),
                String.valueOf(i),
                String.valueOf(i),
                attachment);
    }
}
