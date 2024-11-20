package com.aspiro.profile.api.impl;

import com.aspiro.profile.api.repository.ProfileRepository;
import com.aspiro.profile.api.service.FriendshipService;
import com.aspiro.profile.domain.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class FriendshipServiceImpl implements FriendshipService {
    @Autowired
    private ProfileRepository profileRepository;

    @Transactional
    @Override
    public void addFriend(Long userId, Long friendId) {
        Profile user = profileRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Profile friend = profileRepository.findById(friendId).orElseThrow(() -> new RuntimeException("Friend not found"));

        // Create friendship in both directions
        user.addFriend(friend);
        friend.addFriend(user);

        profileRepository.save(user);
        profileRepository.save(friend);
    }

    @Transactional
    @Override
    public void removeFriend(Long userId, Long friendId) {
        Profile user = profileRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Profile friend = profileRepository.findById(friendId).orElseThrow(() -> new RuntimeException("Friend not found"));

        // Remove friendship in both directions
        user.removeFriend(friend);
        friend.removeFriend(user);

        profileRepository.save(user);
        profileRepository.save(friend);
    }

    @Override
    public Set<Profile> getFriends(Long userId) {
        Profile user = profileRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getFriends();
    }
}
