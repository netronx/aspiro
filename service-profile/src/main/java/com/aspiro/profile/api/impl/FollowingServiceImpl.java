package com.aspiro.profile.api.impl;

import com.aspiro.profile.api.repository.FollowingRepository;
import com.aspiro.profile.api.service.FollowingService;
import com.aspiro.profile.domain.entity.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FollowingServiceImpl implements FollowingService {

    private final FollowingRepository followingRepository;

    public FollowingServiceImpl(FollowingRepository followingRepository) {
        this.followingRepository = followingRepository;
    }

    @Override
    @Transactional
    public void follow(Long followerId, Long followedId) {
        followingRepository.follow(followerId, followedId);
    }

    @Override
    @Transactional
    public void unfollow(Long followerId, Long followedId) {
        followingRepository.unfollow(followerId, followedId);
    }

    @Override
    public List<Profile> getFollowers(Long userId) {
        return followingRepository.findFollowers(userId);
    }

    @Override
    public List<Profile> getFollowing(Long userId) {
        return followingRepository.findFollowing(userId);
    }
}
