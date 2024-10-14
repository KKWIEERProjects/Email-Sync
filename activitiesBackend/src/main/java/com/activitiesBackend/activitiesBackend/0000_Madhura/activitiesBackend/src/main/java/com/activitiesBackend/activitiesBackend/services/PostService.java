package com.activitiesBackend.activitiesBackend.services;

import java.util.List;

import com.activitiesBackend.activitiesBackend.Entities.Post;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(String id);
    Post createPost(Post post);
    Post updatePost(String id, Post post);
    void deletePost(String id);
}
