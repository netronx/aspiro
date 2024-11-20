package com.aspiro.social.service.impl;

import com.aspiro.social.repository.PostRepository;
import com.aspiro.social.service.PostService;
import com.aspiro.social.domain.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> getPostById(Long postId) {
        return postRepository.findById(postId);
    }

    @Override
    public List<Post> getPostsByProfileId(Long profileId) {
        return postRepository.findAllByProfileId(profileId);
    }
}
