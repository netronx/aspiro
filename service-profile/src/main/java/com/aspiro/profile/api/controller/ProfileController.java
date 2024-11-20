package com.aspiro.profile.api.controller;

import com.aspiro.profile.api.service.ProfileService;
import com.aspiro.profile.domain.entity.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    // Create a new profile
    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        Profile createdProfile = profileService.createProfile(profile);
        return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
    }

    // Get a profile by ID
    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable("id") Long id) {
        Profile profile = profileService.getProfileById(id);
        if (profile != null) {
            return new ResponseEntity<>(profile, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update a profile by ID
    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable("id") Long id, @RequestBody Profile updatedProfile) {
        Profile profile = profileService.updateProfile(id, updatedProfile);
        if (profile != null) {
            return new ResponseEntity<>(profile, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a profile by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable("id") Long id) {
        profileService.deleteProfile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get all profiles
    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    // Join a community
    @PostMapping("/{profileId}/communities/{communityId}")
    public ResponseEntity<Void> joinCommunity(@PathVariable("profileId") Long profileId, @PathVariable("communityId") Long communityId) {
        profileService.joinCommunity(profileId, communityId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Leave a community
    @DeleteMapping("/{profileId}/communities/{communityId}")
    public ResponseEntity<Void> leaveCommunity(@PathVariable("profileId") Long profileId, @PathVariable("communityId") Long communityId) {
        profileService.leaveCommunity(profileId, communityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
