package com.javaman.microservice.two.config;

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

    /**
     * 当前连接注册中心配置
     */
    @Bean("my-registry")
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(registryAddr);
        registryConfig.setSimplified(true);
        return registryConfig;
    }

}

