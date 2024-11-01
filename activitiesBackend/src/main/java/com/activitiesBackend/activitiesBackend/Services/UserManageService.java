package com.activitiesBackend.activitiesBackend.Services;

import com.activitiesBackend.activitiesBackend.Repositories.UserRepo;
import com.activitiesBackend.activitiesBackend.dto.Template;
import com.activitiesBackend.activitiesBackend.dto.User;
import com.activitiesBackend.activitiesBackend.exceptions.UserAlreadyThereException;
import com.activitiesBackend.activitiesBackend.exceptions.UserNotFound;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
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
    public List<User> getWorkers(String admin_id) {
        return userRepo.findUsernamesByAdminId(admin_id);
    }

    public List<User> getWorkersBySearch(String admin_id,String search){
        return userRepo.findUsernamesByAdminIdAndSearch(admin_id,search);
    }



    public User getUser(String id) throws Exception {
        return userRepo.findById(id).orElseThrow(()->new UserNotFound("User not found"));
    }

    public List<Template> getAllTemplates(String id){
        return userRepo.findById(id).orElse(null).getTemplates();
    }

    public void changeToken(String id,String token){

        User user=userRepo.findById(id).orElseThrow(()->new UserNotFound("User not found!"));
        user.setToken(token);
        userRepo.save(user);

    }

    public void changeEmail(String id,String email){

        User user=userRepo.findById(id).orElseThrow(()->new UserNotFound("User not found!"));
        user.setEmail(email);
        userRepo.save(user);

    }
}
