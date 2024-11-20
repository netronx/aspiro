package com.aspiro.social.controller;

import com.aspiro.social.internal.KafkaProducer;
import com.aspiro.social.service.PostService;
import com.aspiro.social.domain.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/notif/{message}")
    public ResponseEntity<String> notif(@PathVariable("message") String message) {
        kafkaProducer.sendNotification(message);
        return new ResponseEntity<>("message sent! > " + kafkaProducer, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.createPost(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/profile/{profileId}")
    public ResponseEntity<List<Post>> getPostsByProfileId(@PathVariable Long profileId) {
        List<Post> posts = postService.getPostsByProfileId(profileId);
        return ResponseEntity.ok(posts);
    }
}
