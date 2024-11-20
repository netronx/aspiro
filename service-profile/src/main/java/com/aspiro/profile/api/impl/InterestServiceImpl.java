package com.aspiro.profile.api.impl;

import com.aspiro.profile.api.repository.InterestRepository;
import com.aspiro.profile.api.service.InterestService;
import com.aspiro.profile.domain.entity.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InterestServiceImpl implements InterestService {
    private final InterestRepository interestRepository;

    public InterestServiceImpl(InterestRepository interestRepository) {
        this.interestRepository = interestRepository;
    }


    @Override
    @Transactional
    public void addInterest(Long userId, String interest) {
        interestRepository.addInterest(userId, interest);
    }

    @Override
    @Transactional
    public void removeInterest(Long userId, String interest) {
        interestRepository.removeInterest(userId, interest);
    }

    @Override
    public List<Profile> findProfilesByInterest(String interest) {
        return interestRepository.findProfilesByInterest(interest);
    }
}
