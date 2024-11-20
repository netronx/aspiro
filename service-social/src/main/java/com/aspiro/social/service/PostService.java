package com.aspiro.social.service;

import com.aspiro.social.domain.entity.Post;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PostService {
    @Transactional
    Post createPost(Post post);

    Optional<Post> getPostById(Long postId);

    List<Post> getPostsByProfileId(Long profileId);
}