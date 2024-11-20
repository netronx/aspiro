package com.aspiro.profile.api.service;

import com.aspiro.profile.domain.entity.Community;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public interface CommunityService {


    Optional<Community> getCommunityById(Long id);

    List<Community> findCommunitiesByCategory(String category);

    @Transactional
    void addMemberToCommunity(Long userId, Long communityId);

    @Transactional
    void removeMemberFromCommunity(Long userId, Long communityId);

    Community createCommunity(Community community);

    void deleteCommunity(Long communityId);
}
