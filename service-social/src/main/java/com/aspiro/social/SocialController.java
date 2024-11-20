package com.aspiro.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/socials")
public class SocialController {
    @Autowired
    private UserClient userClient;
    @Autowired
    private UserClient2 userClient2;

    List<Social> socials;

    {
        socials = IntStream.range(1, 9)
                .mapToObj(id -> new Social(id, LocalDateTime.now().minusDays(id), id, 100 + id))
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<Social> findAllSocials() {
        return socials;
    }

    @GetMapping("/{id}")
    public Social findSocialById(@PathVariable("id") int id) {
        return socials.stream().filter(social -> social.id() == id).findFirst().orElse(null);
    }

    @GetMapping("/{id}/user")
    public ResponseEntity<User> findUserOfSocial(@PathVariable("id") int id) {
        Social socialById = findSocialById(id);

        // Check if the social exists before making a request to user service
        if (socialById == null) {
            return ResponseEntity.notFound().build();
        }

        User user1 = userClient.findUserById(socialById.userId());
        User user2 = userClient2.findUserById(socialById.userId());
        return ResponseEntity.ok(user2);
    }

    @GetMapping("/test-load-balancing-1")
    public List<User> testLoadBalancing() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            // Call the service-user multiple times
            User user = userClient.findUserById(i);  // or restTemplate call if using RestTemplate
            users.add(user);
            System.out.println("Called instance for user ID " + i + ": " + user);
        }
        return users;
    }

    @GetMapping("/test-load-balancing-2")
    public List<User> testLoadBalancing2() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            // Call the service-user multiple times
            User user = userClient2.findUserById(i);  // or restTemplate call if using RestTemplate
            users.add(user);
            System.out.println("Called instance for user ID " + i + ": " + user);
        }
        return users;
    }
}
