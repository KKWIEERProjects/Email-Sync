package com.activitiesBackend.activitiesBackend.Repositories;

import com.activitiesBackend.activitiesBackend.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Connection through jpa
 */
@Repository
public interface UserRepo extends JpaRepository<User,String> {

    @Override
    Optional<User> findById(String s);

    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.admin_id = :adminId")
    List<User> findUsernamesByAdminId(@Param("adminId") String adminId);

    @Query("SELECT u FROM User u WHERE u.admin_id = :adminId and u.name like %:name%")
    List<User> findUsernamesByAdminIdAndSearch(@Param("adminId") String adminId,@Param("name") String name);

    @Query("SELECT u FROM User u WHERE u.token = :token")
    void changeToken(@Param("token") String token);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    void changeEmail(@Param("email") String email);



}
