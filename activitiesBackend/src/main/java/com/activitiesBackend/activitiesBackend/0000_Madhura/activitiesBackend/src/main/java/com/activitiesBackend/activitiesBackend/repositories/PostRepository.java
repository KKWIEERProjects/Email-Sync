package com.activitiesBackend.activitiesBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.activitiesBackend.activitiesBackend.Entities.Post;

public interface PostRepository extends JpaRepository<Post, String> {
}
