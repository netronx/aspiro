package com.aspiro.profile.api.impl;

import com.aspiro.profile.api.repository.CommunityRepository;
import com.aspiro.profile.api.service.CommunityService;
import com.aspiro.profile.domain.entity.Community;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommunityServiceImpl implements CommunityService {
    private final CommunityRepository communityRepository;

    public CommunityServiceImpl(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    @Override
    public Optional<Community> getCommunityById(Long id) {
        return communityRepository.findById(id);
    }

    @Override
    public List<Community> findCommunitiesByCategory(String category) {
        return communityRepository.findByCategory(category);
    }

    @Override
    @Transactional
    public void addMemberToCommunity(Long userId, Long communityId) {
        communityRepository.addMemberToCommunity(userId, communityId);
    }

    @Override
    @Transactional
    public void removeMemberFromCommunity(Long userId, Long communityId) {
        communityRepository.removeMemberFromCommunity(userId, communityId);
    }

    @Override
    public Community createCommunity(Community community) {
        community.setCreatedAt(LocalDateTime.now());
        return communityRepository.save(community);
    }

    @Override
    public void deleteCommunity(Long communityId) {
        communityRepository.deleteById(communityId);
    }
}
