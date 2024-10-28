package com.activitiesBackend.activitiesBackend.exceptions;

public class PostNotFoundById extends RuntimeException {
    public PostNotFoundById(String message) {
        super(message);
    }
}
