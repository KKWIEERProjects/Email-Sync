package com.activitiesBackend.activitiesBackend.Repositories;

import com.activitiesBackend.activitiesBackend.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Connection through jpa
 */
public interface UserRepo extends JpaRepository<User,String> {

    @Override
    Optional<User> findById(String s);

    Optional<User> findByUsername(String username);
}
