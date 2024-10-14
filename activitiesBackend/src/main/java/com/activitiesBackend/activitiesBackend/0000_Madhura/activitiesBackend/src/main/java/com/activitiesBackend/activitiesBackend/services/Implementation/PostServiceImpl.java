package com.activitiesBackend.activitiesBackend.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activitiesBackend.activitiesBackend.Entities.Post;
import com.activitiesBackend.activitiesBackend.repositories.PostRepository;
import com.activitiesBackend.activitiesBackend.services.PostService;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(String id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(String id, Post post) {
        Post existingPost = postRepository.findById(id).orElse(null);
        if (existingPost != null) {
            existingPost.setTitle(post.getTitle());
            existingPost.setContent(post.getContent());
            return postRepository.save(existingPost);
        }
        return null;
    }

    @Override
    public void deletePost(String id) {
        postRepository.deleteById(id);
    }
}
