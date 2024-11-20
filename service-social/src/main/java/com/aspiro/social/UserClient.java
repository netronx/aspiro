package com.aspiro.social;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-user", path = "/users") // The name of the service registered in Eureka or Config Server
public interface UserClient {

    @GetMapping("/{id}")
    User findUserById(@PathVariable("id") int id);

}