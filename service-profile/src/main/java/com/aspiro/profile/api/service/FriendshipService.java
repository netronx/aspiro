package com.aspiro.profile.api.service;

import com.aspiro.profile.domain.entity.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface FriendshipService {
    @Transactional
    void addFriend(Long userId, Long friendId);

    @Transactional
    void removeFriend(Long userId, Long friendId);

    Set<Profile> getFriends(Long userId);
}
