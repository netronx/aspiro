package com.aspiro.profile.api.controller;

import com.aspiro.profile.api.service.FollowingService;
import com.aspiro.profile.domain.entity.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/following")
public class FollowingController {

    private final FollowingService followingService;

    public FollowingController(FollowingService followingService) {
        this.followingService = followingService;
    }

    @PostMapping("/follow")
    public ResponseEntity<Void> follow(@RequestParam Long followerId, @RequestParam Long followedId) {
        followingService.follow(followerId, followedId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/unfollow")
    public ResponseEntity<Void> unfollow(@RequestParam Long followerId, @RequestParam Long followedId) {
        followingService.unfollow(followerId, followedId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/followers")
    public List<Profile> getFollowers(@PathVariable Long userId) {
        return followingService.getFollowers(userId);
    }

    @GetMapping("/{userId}/following")
    public List<Profile> getFollowing(@PathVariable Long userId) {
        return followingService.getFollowing(userId);
    }
}
