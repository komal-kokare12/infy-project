package com.example.controller;

import com.example.model.Post;
import com.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @PostMapping("/add-post")
    public ResponseEntity<Post> createPost(
            @RequestParam("title") String title,
            @RequestParam("caption") String caption,
            @RequestParam("image") MultipartFile image) {
        Post post = postService.createPost(title, caption, image);
        return ResponseEntity.ok(post);
    }
}