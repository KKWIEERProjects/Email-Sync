package com.activitiesBackend.activitiesBackend.controller.Notification.Admin;

import com.activitiesBackend.activitiesBackend.Services.NotificationService.AssignService;
import com.activitiesBackend.activitiesBackend.Services.UserManageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
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

    //its taking usernames
    @PostMapping("/admin/assign")
    public ModelAndView assignAPost(@RequestParam String event, @RequestParam String cus, @RequestParam String info,@RequestParam String mail){

        System.out.println("\n==================\n~~~~~~~~~~~~~~~~~~"+cus+"\n========~~~~~~~~~~==============\n");
        assignService.setPost(event, cus, info);

        return new ModelAndView("redirect:/admin");

    }

    @PostMapping("/admin/gotoassign")
    public ModelAndView gotoassign(@NonNull @RequestParam String id){
        System.out.println("\n======================"+id+"==============================\n");
        return new ModelAndView("admin/assign").addObject("cus",id);
    }

}
