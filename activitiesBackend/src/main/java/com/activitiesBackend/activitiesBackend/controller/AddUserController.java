package com.activitiesBackend.activitiesBackend.controller;

import com.activitiesBackend.activitiesBackend.Services.UserManageService;
import com.activitiesBackend.activitiesBackend.dto.User;
import com.activitiesBackend.activitiesBackend.exceptions.UserAlreadyThereException;
import com.github.javafaker.Faker;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
//@RequestMapping("/user")
public class AddUserController {

    @Autowired
    private UserManageService userManageService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/add")
    public ModelAndView getUserView(){
        return new ModelAndView("newUser").addObject("credit",null);
    }



    /**
     * i have no f-ing idea of what i am doing
     */
   // @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public ModelAndView addUser(@RequestParam(defaultValue = "ROLE_USER",required = false) String roles,
                                @RequestParam String name,
                                @RequestParam String email,
                                HttpSession session)
            throws UserAlreadyThereException {
        System.out.println(roles);
        Faker faker=new Faker();
        String username=faker.superhero().prefix()+faker.name().firstName()+faker.address().buildingNumber();
        User user=null;

        //do not touch this or it will go for ini=finity
        while(userManageService.checkUsername(username)){
            username=faker.superhero().prefix()+faker.name().firstName()+faker.address().buildingNumber();
        }
        String password=RandomStringUtils.random(10,"qwertyuiopasdfghjklzxcvbnm1234567890");
        user=User.builder()
                .id(UUID.randomUUID().toString())
                .username(username)
                .password(passwordEncoder.encode( password))
                .roles(roles)
                .name(name)
                .email(email)
                .admin_id((String)session.getAttribute("id"))
                .build();

        //garbage collection boi
        faker=null;
        username=null;

        System.out.println(user);
        userManageService.save(user);

//        return new ModelAndView("newUser")
//                .addObject("credit",user.getUsername())
//                .addObject("password",password);
//
        String id=(String) session.getAttribute("id");
        return new ModelAndView("admin/admin").addObject("coos",userManageService.getWorkers(id))
                .addObject("credit",user.getUsername())
                .addObject("password",password);

    }

}
