package com.aspiro.profile.api.service;

import com.aspiro.profile.domain.entity.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FollowingService {

    @Transactional
    void follow(Long followerId, Long followedId);

    @Transactional
    void unfollow(Long followerId, Long followedId);

    List<Profile> getFollowers(Long userId);

    List<Profile> getFollowing(Long userId);
}
