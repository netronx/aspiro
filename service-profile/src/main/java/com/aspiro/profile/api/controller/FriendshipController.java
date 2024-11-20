package com.aspiro.profile.api.controller;

import com.aspiro.profile.api.service.FriendshipService;
import com.aspiro.profile.domain.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/friends")
public class FriendshipController {

    @Autowired
    private FriendshipService friendshipService;

    @PostMapping("/add")
    public ResponseEntity<Void> addFriend(@RequestParam Long userId, @RequestParam Long friendId) {
        friendshipService.addFriend(userId, friendId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeFriend(@RequestParam Long userId, @RequestParam Long friendId) {
        friendshipService.removeFriend(userId, friendId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/friends")
    public ResponseEntity<Set<Profile>> getFriends(@PathVariable Long userId) {
        Set<Profile> friends = friendshipService.getFriends(userId);
        return ResponseEntity.ok(friends);
    }
}