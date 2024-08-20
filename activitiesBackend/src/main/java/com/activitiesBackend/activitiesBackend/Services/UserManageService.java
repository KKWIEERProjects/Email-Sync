package com.activitiesBackend.activitiesBackend.Services;

import com.activitiesBackend.activitiesBackend.Repositories.UserRepo;
import com.activitiesBackend.activitiesBackend.dto.User;
import com.activitiesBackend.activitiesBackend.exceptions.UserAlreadyThereException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManageService implements UserManageInterface{

    @Autowired
    private UserRepo userRepo;

    @Override
    public Boolean checkUsername(String username) {
        return userRepo.findByUsername(username).isPresent();
    }
//
//    @Deprecated
//    @Override
//    public User getId(String username) throws Exception {
//        return userRepo.findById(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
//    }

    @Override
    public User save(User user) throws UserAlreadyThereException {
        if(userRepo.findById(user.getId()).isPresent()){
            throw new UserAlreadyThereException("User already present");
        }

        return userRepo.save(user);

    }

    @Override
    public Boolean deleteUser(User user) {
        return null;
    }

    @Override
    public Boolean updateUser(User user) {
        return null;
    }

    @Override
    public List<String> getWorkers(String admin_id) {
        return userRepo.findUsernamesByAdminId(admin_id);
    }
}
