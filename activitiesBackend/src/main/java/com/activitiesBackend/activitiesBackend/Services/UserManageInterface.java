package com.activitiesBackend.activitiesBackend.Services;

import com.activitiesBackend.activitiesBackend.dto.User;
import com.activitiesBackend.activitiesBackend.exceptions.UserAlreadyThereException;

public interface UserManageInterface {

    public Boolean checkUsername(String username);

  //  public String getId(String username) throws Exception;

    public User save(User user) throws UserAlreadyThereException;

    public Boolean deleteUser(User user);

    public Boolean updateUser(User user);
}