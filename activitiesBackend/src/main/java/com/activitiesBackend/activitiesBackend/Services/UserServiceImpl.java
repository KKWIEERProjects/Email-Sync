package com.activitiesBackend.activitiesBackend.Services;

import com.activitiesBackend.activitiesBackend.Repositories.UserRepo;
import com.activitiesBackend.activitiesBackend.dto.User;
import com.activitiesBackend.activitiesBackend.model.UserDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> userOptional = userRepo.findByUsername(username);
//        return userOptional.map(UserDetailModel::new).orElseThrow(()->new UsernameNotFoundException("Username not found"));
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // Retrieve the user from the repository
//        User user = userRepo.findById(username).orElse(null);
//        System.out.println(user);
//        // Log or print debugging information
//        System.out.println("Loading user by username: " + username);
//
//        // Check if user is null and throw UsernameNotFoundException
//        if (user == null) {
//            System.out.println("User not found: " + username);
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        // Create and return a CustomUserDetails object
//        UserDetailModel customUserDetails = new UserDetailModel(user);
//
//        System.out.println("User found and CustomUserDetails created for: " + username);
//
//        return customUserDetails;
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        Optional<User> user = userRepo.findByUsername(username);
//        if (user.isEmpty()) {
//            throw new UsernameNotFoundException(username);
//        }
//        System.out.println(user);
//        return new UserDetailModel(user.orElse(null));
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username).orElse(null);
        System.out.println("==================="+user);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return new UserDetailModel(user);
    }


}
