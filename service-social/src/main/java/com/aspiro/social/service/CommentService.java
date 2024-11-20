package com.aspiro.social.service;

import com.aspiro.social.domain.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Long postId, Comment comment);

    List<Comment> getCommentsByPostId(Long postId);
}
