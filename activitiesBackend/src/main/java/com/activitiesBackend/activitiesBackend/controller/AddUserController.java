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
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class AddUserController {

    @Autowired
    private UserManageService userManageService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/user")
    public ModelAndView getUserView(){
        return new ModelAndView("newUser").addObject("credit",null);
    }



    /**
     * i have no f-ing idea of what i am doing
     */
   // @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public ModelAndView addUser(@RequestParam String roles,
                                @RequestParam String name,
                                @RequestParam String email)
            throws UserAlreadyThereException {
        System.out.println(roles);
        Faker faker=new Faker();
        String username=faker.superhero().prefix()+faker.name().firstName()+faker.address().buildingNumber();
        User user=null;

        //do not touch this or it will go for ini=finity
        while(userManageService.checkUsername(username)){
            username=faker.superhero().prefix()+faker.name().firstName()+faker.address().buildingNumber();
        }
        user=User.builder()
                .username(username)
                .password(passwordEncoder.encode( RandomStringUtils.random(10,"qwertyuiopasdfghjklzxcvbnm1234567890")))
                .roles(roles)
                .name(name)
                .email(email)
                .build();

        //garbage collection boi
        faker=null;
        username=null;

        System.out.println(user);
      //  userManageService.save(user);

        return new ModelAndView("newUser").addObject("credit",user);

    }

}
