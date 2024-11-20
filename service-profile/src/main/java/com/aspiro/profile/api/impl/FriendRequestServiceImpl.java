package com.aspiro.profile.api.impl;

import com.aspiro.profile.api.repository.ProfileRepository;
import com.aspiro.profile.api.service.FriendRequestService;
import com.aspiro.profile.domain.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class FriendRequestServiceImpl implements FriendRequestService {
    @Autowired
    private ProfileRepository profileRepository;

    @Transactional
    @Override
    public void sendFriendRequest(Long userId, Long friendId) {
        Profile user = profileRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Profile friend = profileRepository.findById(friendId).orElseThrow(() -> new RuntimeException("Friend not found"));

        // Check if the user has already sent a request or if they are already friends
        if (user.getSentRequests().contains(friend) || user.getFriends().contains(friend)) {
            throw new RuntimeException("Friend request already sent or they are already friends");
        }

        // Create the sent request relationship
        user.sendFriendRequest(friend);
        friend.receiveFriendRequest(user);

        profileRepository.save(user);
        profileRepository.save(friend);
    }

    @Transactional
    @Override
    public void acceptFriendRequest(Long userId, Long friendId) {
        Profile user = profileRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Profile friend = profileRepository.findById(friendId).orElseThrow(() -> new RuntimeException("Friend not found"));

        // Check if the user has received the request
        if (!user.getReceivedRequests().contains(friend)) {
            throw new RuntimeException("No friend request to accept");
        }

        // Convert request to friend relationship
        user.addFriend(friend);
        friend.addFriend(user);

        // Remove the sent and received requests
        user.cancelFriendRequest(friend);
        friend.rejectFriendRequest(user);

        profileRepository.save(user);
        profileRepository.save(friend);
    }

    @Transactional
    @Override
    public void rejectFriendRequest(Long userId, Long friendId) {
        Profile user = profileRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Profile friend = profileRepository.findById(friendId).orElseThrow(() -> new RuntimeException("Friend not found"));

        // Remove the received request
        user.rejectFriendRequest(friend);
        friend.cancelFriendRequest(user);

        profileRepository.save(user);
        profileRepository.save(friend);
    }

    @Transactional
    @Override
    public void cancelFriendRequest(Long userId, Long friendId) {
        Profile user = profileRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Profile friend = profileRepository.findById(friendId).orElseThrow(() -> new RuntimeException("Friend not found"));

        // Remove the sent request
        user.cancelFriendRequest(friend);
        friend.rejectFriendRequest(user);

        profileRepository.save(user);
        profileRepository.save(friend);
    }

    @Override
    public Set<Profile> getPendingRequests(Long userId) {
        Profile user = profileRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getReceivedRequests();
    }
}
