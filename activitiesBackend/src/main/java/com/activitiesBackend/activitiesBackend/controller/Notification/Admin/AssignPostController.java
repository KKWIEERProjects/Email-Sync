package com.activitiesBackend.activitiesBackend.controller.Notification.Admin;

import com.activitiesBackend.activitiesBackend.Services.NotificationService.AssignService;
import com.activitiesBackend.activitiesBackend.Services.UserManageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
public class AssignPostController {

    @Autowired
    private AssignService assignService;

    @Autowired
    private UserManageService userManageService;

    @PostMapping("/admin/assign")
    public ModelAndView assignAPost(@RequestParam String event, @RequestParam String cus, @RequestParam String info){

       // System.out.println("\n==================\n~~~~~~~~~~~~~~~~~~"+cus+"\n========~~~~~~~~~~==============\n");
        assignService.setPost(event, cus, info);

        return new ModelAndView("redirect:/admin");

    }

    @PostMapping("/admin/gotoassign")
    public ModelAndView gotoassign(@RequestParam String id){
        return new ModelAndView("admin/assign").addObject("cus",id);
    }

}
