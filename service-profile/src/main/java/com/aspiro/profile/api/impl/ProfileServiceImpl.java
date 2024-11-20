package com.aspiro.profile.api.impl;

import com.aspiro.profile.api.repository.CommunityRepository;
import com.aspiro.profile.api.repository.ProfileRepository;
import com.aspiro.profile.api.service.ProfileService;
import com.aspiro.profile.domain.entity.Community;
import com.aspiro.profile.domain.entity.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final CommunityRepository communityRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository, CommunityRepository communityRepository) {
        this.profileRepository = profileRepository;
        this.communityRepository = communityRepository;
    }

    @Override
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile getProfileById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    @Override
    public Profile updateProfile(Long id, Profile updatedProfile) {
        Optional<Profile> existingProfile = profileRepository.findById(id);
        if (existingProfile.isPresent()) {
            Profile profile = existingProfile.get();
            profile.setUsername(updatedProfile.getUsername());
            profile.setBio(updatedProfile.getBio());
            profile.setLocation(updatedProfile.getLocation());
            return profileRepository.save(profile);
        }
        return null;
    }

    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    @Transactional
    public void joinCommunity(Long profileId, Long communityId) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("Profile not found"));
        Community community = communityRepository.findById(communityId).orElseThrow(() -> new RuntimeException("Community not found"));
        profile.joinCommunity(community);
        profileRepository.save(profile);
    }

    @Override
    @Transactional
    public void leaveCommunity(Long profileId, Long communityId) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("Profile not found"));
        Community community = communityRepository.findById(communityId).orElseThrow(() -> new RuntimeException("Community not found"));
        profile.leaveCommunity(community);
        profileRepository.save(profile);
    }
}
