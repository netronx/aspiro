package com.aspiro.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InstanceIdLogger implements CommandLineRunner {

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @Value("${server.port}")
    private String serverPort;

    @Override
    public void run(String... args) {
        System.out.println("Assigned Port: " + serverPort);
    }
}