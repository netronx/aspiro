package com.aspiro.social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
/* @EnableEurekaClient not needed
configured by default by presence of spring-cloud-starter-netflix-eureka-client dependency */
@EnableFeignClients
public class ServiceSocialApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSocialApplication.class, args);
    }

}
