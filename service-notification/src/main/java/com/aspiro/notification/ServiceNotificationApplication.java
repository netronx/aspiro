package com.aspiro.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class ServiceNotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceNotificationApplication.class, args);
    }

}
