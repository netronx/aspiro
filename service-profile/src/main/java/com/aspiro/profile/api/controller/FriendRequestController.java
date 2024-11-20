package com.aspiro.profile.api.controller;

import com.aspiro.profile.api.service.FriendRequestService;
import com.aspiro.profile.domain.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/friends")
public class FriendRequestController {

    @Autowired
    private FriendRequestService friendRequestService;

    @PostMapping("/send")
    public ResponseEntity<Void> sendFriendRequest(@RequestParam Long userId, @RequestParam Long friendId) {
        friendRequestService.sendFriendRequest(userId, friendId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/accept")
    public ResponseEntity<Void> acceptFriendRequest(@RequestParam Long userId, @RequestParam Long friendId) {
        friendRequestService.acceptFriendRequest(userId, friendId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reject")
    public ResponseEntity<Void> rejectFriendRequest(@RequestParam Long userId, @RequestParam Long friendId) {
        friendRequestService.rejectFriendRequest(userId, friendId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cancel")
    public ResponseEntity<Void> cancelFriendRequest(@RequestParam Long userId, @RequestParam Long friendId) {
        friendRequestService.cancelFriendRequest(userId, friendId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/pending-requests")
    public ResponseEntity<Set<Profile>> getPendingRequests(@PathVariable Long userId) {
        Set<Profile> pendingRequests = friendRequestService.getPendingRequests(userId);
        return ResponseEntity.ok(pendingRequests);
    }
}
