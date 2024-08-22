package com.activitiesBackend.activitiesBackend.controller;

import com.activitiesBackend.activitiesBackend.Services.Email.EmailService;
import com.activitiesBackend.activitiesBackend.Services.UserManageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home")
public class GeneralController {

    @Autowired
    private UserManageService userManageService;

    @Autowired
    private EmailService emailService;

    @Value("${email}")
    private String email;

    @GetMapping("/general")
    public ModelAndView general(HttpSession session){
        ModelAndView modelAndView=new ModelAndView("general");
        if(userManageService.isAdmin((String) session.getAttribute("id") ) ){
            modelAndView.addObject("role","ADMIN");
        }else{
            modelAndView.addObject("role","USER");
        }
        return modelAndView.addObject("name",(String) session.getAttribute("user"));
    }

    @GetMapping("/send")
    public void getEmail() throws Exception {
        String content="<html> <body> <h1>hello world!</h1><p>hello</p> </body></html>";
        emailService.sendEmail(email,"test",content);
        content=null;
    }
}
