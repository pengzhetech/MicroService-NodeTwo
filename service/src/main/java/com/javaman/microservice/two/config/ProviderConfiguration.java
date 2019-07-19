package com.javaman.microservice.two.config;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther: pengzhe
 * @since: 2019/7/18 22:43
 * @description:
 */
@Configuration
@DubboComponentScan("com.javaman.microservice.two.config.ProviderConfiguration") // 扫描 Dubbo 组件
public class ProviderConfiguration {

    @Value("${dubbo.registry.address}")
    private String registryAddr;
    @Value("${dubbo.protocol.name}")
    private String protocolName;
    @Value("${dubbo.protocol.port}")
    private int protocolPort;
    @Value("${application.name}")
    private String applicationName;

    /**
     * 当前应用配置
     */
    @Bean("dubbo-annotation-provider")
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(applicationName);
        return applicationConfig;
    }

    /**
     * 当前连接注册中心配置
     */
    @Bean("zk-registry")
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(registryAddr);
        registryConfig.setSimplified(false);
        return registryConfig;
    }

    /**
     * 当前连接注册中心配置
     */
    @Bean("dubbo")
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(protocolName);
        protocolConfig.setPort(protocolPort);
        return protocolConfig;
    }

}

