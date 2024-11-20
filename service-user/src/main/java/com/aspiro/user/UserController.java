package com.aspiro.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/users")
public class UserController {
    List<User> users;

    {
        users = IntStream.range(1, 9)
                .mapToObj(id -> new User(id, "user" + id, 20 + id))
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<User> findAllUsers() {
        return users;
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") int id) {
        System.out.println("Handling request findUserById: " + id);
        return users.stream().filter(user -> user.id() == id).findFirst().orElse(null);
    }
}
