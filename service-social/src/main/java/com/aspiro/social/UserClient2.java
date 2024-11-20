package com.aspiro.social;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class UserClient2 {
    String userServiceUrl = "http://service-user/users";

    private final RestTemplate restTemplate;

    UserClient2(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") int id) {
        String userByIdServiceUrl = String.format("%s/%d", userServiceUrl, id);
        ResponseEntity<User> userResponse = restTemplate.getForEntity(userByIdServiceUrl, User.class, id);
        return userResponse.getBody();
    }
}