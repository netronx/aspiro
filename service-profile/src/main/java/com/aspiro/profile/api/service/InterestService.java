package com.aspiro.profile.api.service;

import com.aspiro.profile.domain.entity.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InterestService {
    @Transactional
    void addInterest(Long userId, String interest);

    @Transactional
    void removeInterest(Long userId, String interest);

    List<Profile> findProfilesByInterest(String interest);
}
