package com.aspiro.profile.api.service;

import com.aspiro.profile.domain.entity.Profile;

import java.util.List;

public interface ProfileService {
    Profile createProfile(Profile profile);

    Profile getProfileById(Long id);

    Profile updateProfile(Long id, Profile profile);

    void deleteProfile(Long id);

    List<Profile> getAllProfiles();

    void joinCommunity(Long profileId, Long communityId);

    void leaveCommunity(Long profileId, Long communityId);
}
