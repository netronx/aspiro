package com.aspiro.profile.api.controller;

import com.aspiro.profile.api.service.CommunityService;
import com.aspiro.profile.domain.entity.Community;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/communities")
public class CommunityController {

    private final CommunityService communityService;

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    // Create a new community
    @PostMapping
    public Community createCommunity(@RequestBody Community community) {
        return communityService.createCommunity(community);
    }

    // Get a community by ID
    @GetMapping("/{id}")
    public ResponseEntity<Community> getCommunity(@PathVariable Long id) {
        return communityService.getCommunityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Find communities by category
    @GetMapping("/category/{category}")
    public List<Community> getCommunitiesByCategory(@PathVariable String category) {
        return communityService.findCommunitiesByCategory(category);
    }

    // Add a user to a community
    @PostMapping("/{communityId}/join")
    public ResponseEntity<Void> joinCommunity(@PathVariable Long communityId, @RequestParam Long userId) {
        communityService.addMemberToCommunity(userId, communityId);
        return ResponseEntity.ok().build();
    }

    // Remove a user from a community
    @DeleteMapping("/{communityId}/leave")
    public ResponseEntity<Void> leaveCommunity(@PathVariable Long communityId, @RequestParam Long userId) {
        communityService.removeMemberFromCommunity(userId, communityId);
        return ResponseEntity.ok().build();
    }

    // Delete a community by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommunity(@PathVariable Long id) {
        communityService.deleteCommunity(id);
        return ResponseEntity.noContent().build();
    }
}
