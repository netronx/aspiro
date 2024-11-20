package com.aspiro.profile.api.service;

import com.aspiro.profile.domain.entity.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface FriendRequestService {
    @Transactional
    void sendFriendRequest(Long userId, Long friendId);

    @Transactional
    void acceptFriendRequest(Long userId, Long friendId);

    @Transactional
    void rejectFriendRequest(Long userId, Long friendId);

    @Transactional
    void cancelFriendRequest(Long userId, Long friendId);

    Set<Profile> getPendingRequests(Long userId);
}
