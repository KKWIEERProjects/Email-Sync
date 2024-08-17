package com.activitiesBackend.activitiesBackend.controller;

import com.activitiesBackend.activitiesBackend.Repositories.UserRepo;
import com.activitiesBackend.activitiesBackend.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginControl {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public ModelAndView modelAndView(){
        System.out.println("jdjrhsdfj");
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView reg(){
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public void reg(@RequestParam(value = "username") String username,@RequestParam String password){
        System.out.println("ahsghjasdjahsdk");
        User user=new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles("ROLE_ADMIN");
        System.out.println(user.toString());
        userRepo.save(user);
    }


}
