package com.activitiesBackend.activitiesBackend.controller;

import com.activitiesBackend.activitiesBackend.Services.UserManageService;
import com.activitiesBackend.activitiesBackend.dto.User;
import com.activitiesBackend.activitiesBackend.exceptions.UserAlreadyThereException;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AddUserController {

    @Autowired
    private UserManageService userManageService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * i have no f-ing idea of what i am doing
     */
   // @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public void addUser(@RequestParam String roles) throws UserAlreadyThereException {
        System.out.println(roles);
        Faker faker=new Faker();
        String username=faker.superhero().prefix()+faker.name().firstName()+faker.address().buildingNumber();
        User user=null;
        while(userManageService.checkUsername(username)){
            username=faker.superhero().prefix()+faker.name().firstName()+faker.address().buildingNumber();
        }
        user=User.builder().
                username(username).password(passwordEncoder.encode( RandomStringUtils.random(10,"qwertyuiopasdfghjklzxcvbnm1234567890"))).roles(roles).
                build();
        faker=null;
        username=null;
        System.out.println(user);
        userManageService.save(user);
        user=null;
    }

}
