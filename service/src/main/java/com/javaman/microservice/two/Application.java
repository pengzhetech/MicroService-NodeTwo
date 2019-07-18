package com.javaman.microservice.two;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

/**
 * @author pengzhe
 * @date 2019-05-09 22:28
 * @description
 */

@SpringBootApplication
@EnableDubbo
@Slf4j
@EnableSwagger2
public class Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setBannerMode(Mode.OFF);
        ConfigurableApplicationContext applicationContext = application.run(args);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

      /*  System.out.println("实例化Bean数量:" + beanDefinitionNames.length);
        //  Arrays.asList(beanDefinitionNames).forEach(System.out::println);
        Arrays.asList(beanDefinitionNames).forEach(beanName -> {
            Object bean = applicationContext.getBean(beanName);
            System.out.println("bean的名称:" + beanName + "------bean类名:" + bean.getClass().getName());
        });*/

    }
}
